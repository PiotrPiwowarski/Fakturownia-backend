package pl.piwowarski.fakturowniabackend.services.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.exceptions.NoUserInSecurityContextHolderException;
import pl.piwowarski.fakturowniabackend.mappers.CompanyMapper;
import pl.piwowarski.fakturowniabackend.repository.UserRepository;
import pl.piwowarski.fakturowniabackend.services.company.CompanyService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    @Override
    public List<GetCompanyDto> getUserCompanies() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch(Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        List<Company> companies = user.getCompanies();
        return companies.stream().map(CompanyMapper::map).toList();
    }
}
