package pl.piwowarski.fakturowniabackend.services.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.company.NewCompanyDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.exceptions.NoCompaniesWithSuchNipException;
import pl.piwowarski.fakturowniabackend.exceptions.NoUsersWithSuchIdException;
import pl.piwowarski.fakturowniabackend.mappers.CompanyMapper;
import pl.piwowarski.fakturowniabackend.repository.CompanyRepository;
import pl.piwowarski.fakturowniabackend.repository.UserRepository;
import pl.piwowarski.fakturowniabackend.services.company.CompanyService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Override
    public void addNewCompany(NewCompanyDto newCompanyDto) {
        Optional<User> optionalUser = userRepository.findById(newCompanyDto.getUserId());

        if(optionalUser.isEmpty()) {
            throw new NoUsersWithSuchIdException();
        }
        Company newCompany = CompanyMapper.map(newCompanyDto, optionalUser.get());
        companyRepository.save(newCompany);
    }

    @Override
    public GetCompanyDto getCompany(String nip) {
        Company company = companyRepository.findByNip(nip)
                .orElseThrow(NoCompaniesWithSuchNipException::new);
        return CompanyMapper.map(company);
    }
}
