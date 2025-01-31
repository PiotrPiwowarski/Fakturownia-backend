package pl.piwowarski.fakturowniabackend.services.Company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.NewCompanyDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.exceptions.CompanyWithSuchEmailAlreadyExistsException;
import pl.piwowarski.fakturowniabackend.exceptions.NoCompaniesWithSuchNipException;
import pl.piwowarski.fakturowniabackend.mappers.CompanyMapper;
import pl.piwowarski.fakturowniabackend.repository.CompanyRepository;
import pl.piwowarski.fakturowniabackend.services.Company.CompanyService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addNewCompany(NewCompanyDto newCompanyDto) {
        Optional<Company> optionalCompany = companyRepository.findByEmail(newCompanyDto.getEmail());

        if(optionalCompany.isPresent()) {
            throw new CompanyWithSuchEmailAlreadyExistsException();
        }

        Company newCompany = CompanyMapper.map(newCompanyDto, passwordEncoder);
        companyRepository.save(newCompany);
    }

    @Override
    public GetCompanyDto getCompany(String nip) {
        Company company = companyRepository.findByNip(nip)
                .orElseThrow(NoCompaniesWithSuchNipException::new);
        return CompanyMapper.map(company);
    }
}
