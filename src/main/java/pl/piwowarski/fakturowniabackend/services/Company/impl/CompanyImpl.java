package pl.piwowarski.fakturowniabackend.services.Company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.NewCompanyDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.repository.CompanyRepository;
import pl.piwowarski.fakturowniabackend.services.Company.CompanyService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public void addNewCompany(NewCompanyDto newCompanyDto) {
        Optional<Company> optionalCompany = companyRepository.findByNip(newCompanyDto.getNip());
        if(optionalCompany.isPresent()) {
            throw new IllegalStateException("Firma o podanym nipie już istnieje");
        }
        Company newCompany = Company.builder().build();
        companyRepository.save(newCompany);
    }
}
