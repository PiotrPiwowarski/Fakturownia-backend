package pl.piwowarski.fakturowniabackend.services.company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.exceptions.NoUsersWithSuchIdException;
import pl.piwowarski.fakturowniabackend.mappers.CompanyMapper;
import pl.piwowarski.fakturowniabackend.repository.CompanyRepository;
import pl.piwowarski.fakturowniabackend.repository.UserRepository;
import pl.piwowarski.fakturowniabackend.services.company.CompanyService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Override
    public List<GetCompanyDto> getCompaniesByUserId(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new NoUsersWithSuchIdException();
        }

        User user = optionalUser.get();
        List<Company> companies = user.getCompanies();
        return companies.stream().map(CompanyMapper::map).toList();
    }
}
