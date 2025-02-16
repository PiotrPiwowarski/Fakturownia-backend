package pl.piwowarski.fakturowniabackend.services.invoice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoiceDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.GetInvoicePositionDto;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.Invoice;
import pl.piwowarski.fakturowniabackend.entites.InvoicePosition;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.exceptions.NoUserInSecurityContextHolderException;
import pl.piwowarski.fakturowniabackend.exceptions.NoUsersWithSuchIdException;
import pl.piwowarski.fakturowniabackend.mappers.BuyerCompanyMapper;
import pl.piwowarski.fakturowniabackend.mappers.InvoiceMapper;
import pl.piwowarski.fakturowniabackend.mappers.InvoicePositionMapper;
import pl.piwowarski.fakturowniabackend.mappers.SellerCompanyMapper;
import pl.piwowarski.fakturowniabackend.repository.CompanyRepository;
import pl.piwowarski.fakturowniabackend.repository.InvoicePositionRepository;
import pl.piwowarski.fakturowniabackend.repository.InvoiceRepository;
import pl.piwowarski.fakturowniabackend.repository.UserRepository;
import pl.piwowarski.fakturowniabackend.services.invoice.InvoiceService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
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
        } catch(Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        List<Invoice> invoices = invoiceRepository.findByUser(user);
        return invoices.stream().map(InvoiceMapper::map).toList();
    }
}

