package pl.piwowarski.fakturowniabackend.services.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.exceptions.NoPermissionToPerformTheOperation;
import pl.piwowarski.fakturowniabackend.exceptions.NoUserInSecurityContextHolderException;
import pl.piwowarski.fakturowniabackend.mappers.CompanyMapper;
import pl.piwowarski.fakturowniabackend.repository.CompanyRepository;
import pl.piwowarski.fakturowniabackend.repository.InvoiceRepository;
import pl.piwowarski.fakturowniabackend.services.company.CompanyService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    public List<GetCompanyDto> getUserCompanies() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch(Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        List<Company> companies = companyRepository.findByUser(user);
        return companies.stream().map(CompanyMapper::map).toList();
    }

    @Override
    @Transactional
    public void deleteCompanyById(long id) {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch(Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        Optional<Company> optionalCompany = companyRepository.findByIdAndUser(id, user);
        if(optionalCompany.isEmpty()) {
            throw new NoPermissionToPerformTheOperation();
        }
        Company company = optionalCompany.get();
        invoiceRepository.deleteAllBySellerCompany(company);
        invoiceRepository.deleteAllByBuyerCompany(company);
        companyRepository.delete(company);
    }
}
