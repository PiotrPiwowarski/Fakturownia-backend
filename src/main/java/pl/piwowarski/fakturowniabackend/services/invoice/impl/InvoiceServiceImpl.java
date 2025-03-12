package pl.piwowarski.fakturowniabackend.services.invoice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoiceDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetStatisticsDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.Invoice;
import pl.piwowarski.fakturowniabackend.entites.InvoicePosition;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.enums.PaymentPlan;
import pl.piwowarski.fakturowniabackend.exceptions.NoPermissionToPerformTheOperation;
import pl.piwowarski.fakturowniabackend.exceptions.NoUserInSecurityContextHolderException;
import pl.piwowarski.fakturowniabackend.mappers.BuyerCompanyMapper;
import pl.piwowarski.fakturowniabackend.mappers.InvoiceMapper;
import pl.piwowarski.fakturowniabackend.mappers.InvoicePositionMapper;
import pl.piwowarski.fakturowniabackend.mappers.SellerCompanyMapper;
import pl.piwowarski.fakturowniabackend.repository.CompanyRepository;
import pl.piwowarski.fakturowniabackend.repository.InvoicePositionRepository;
import pl.piwowarski.fakturowniabackend.repository.InvoiceRepository;
import pl.piwowarski.fakturowniabackend.services.invoice.InvoiceService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CompanyRepository companyRepository;
    private final InvoicePositionRepository invoicePositionRepository;

    @Override
    @Transactional
    public void addInvoice(NewInvoiceDto newInvoiceDto) {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch(Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        Company buyerCompany = companyRepository.findByNip(newInvoiceDto.getBuyerCompanyNip())
                .orElseGet(() -> companyRepository.save(BuyerCompanyMapper.map(newInvoiceDto, user)));

        Company sellerCompany = companyRepository.findByNip(newInvoiceDto.getSellerCompanyNip())
                .orElseGet(() -> companyRepository.save(SellerCompanyMapper.map(newInvoiceDto, user)));

        Invoice invoice = InvoiceMapper.map(newInvoiceDto, user, buyerCompany, sellerCompany);
        invoiceRepository.save(invoice);

        List<InvoicePosition> invoicePositions = newInvoiceDto.getNewInvoicePositionList().stream().map(position -> InvoicePositionMapper.map(position, invoice)).toList();

        invoicePositionRepository.saveAll(invoicePositions);
    }

    @Override
    public List<GetInvoiceDto> getUserInvoices() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        List<Invoice> invoices;
        if(user.getPaymentPlan().equals(PaymentPlan.PRO)) {
            invoices = invoiceRepository.findAllByUserOrderByDateOfIssueDesc(user);
        } else {
            invoices = invoiceRepository.findByUserOrderByDateOfIssueDescPageable(user, PageRequest.of(0, 3));
        }
        return invoices.stream().map(InvoiceMapper::map).toList();
    }

    @Override
    public GetStatisticsDto getUserStatistics() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch(Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        List<Invoice> userInvoices = invoiceRepository.findAllByUserOrderByDateOfIssueDesc(user);

        if(userInvoices.size() == 0) {
            return null;
        } else {
            BigDecimal sumNetto = userInvoices.stream().map(Invoice::getSumNetto).reduce(BigDecimal.ZERO, BigDecimal::add);

            return GetStatisticsDto.builder()
                    .amount(userInvoices.size())
                    .sumNettoValue(sumNetto.toString())
                    .averageInvoiceValue(sumNetto.divide(BigDecimal.valueOf(userInvoices.size()), RoundingMode.HALF_UP).toString())
                    .build();
        }
    }

    @Override
    public void deleteInvoice(long id) {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch(Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        Optional<Invoice> optionalInvoice = invoiceRepository.findByIdAndUser(id, user);
        if(optionalInvoice.isEmpty()) {
            throw new NoPermissionToPerformTheOperation();
        }
        invoiceRepository.delete(optionalInvoice.get());
    }
}

