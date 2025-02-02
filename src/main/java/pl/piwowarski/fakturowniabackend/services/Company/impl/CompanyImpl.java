package pl.piwowarski.fakturowniabackend.services.Company.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.AuthenticationDto;
import pl.piwowarski.fakturowniabackend.dtos.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.LoginDto;
import pl.piwowarski.fakturowniabackend.dtos.NewCompanyDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.Token;
import pl.piwowarski.fakturowniabackend.exceptions.CompanyWithSuchEmailAlreadyExistsException;
import pl.piwowarski.fakturowniabackend.exceptions.NoCompaniesWithSuchIdException;
import pl.piwowarski.fakturowniabackend.exceptions.NoCompaniesWithSuchNipException;
import pl.piwowarski.fakturowniabackend.mappers.CompanyMapper;
import pl.piwowarski.fakturowniabackend.repository.CompanyRepository;
import pl.piwowarski.fakturowniabackend.repository.TokenRepository;
import pl.piwowarski.fakturowniabackend.services.Company.CompanyService;
import pl.piwowarski.fakturowniabackend.services.jwt.JwtService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;

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

    @Override
    public AuthenticationDto login(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        Company company = companyRepository
                .findByEmail(loginDto.getEmail())
                .orElseThrow(NoCompaniesWithSuchIdException::new);
        String jwtToken = jwtService.generateToken(company);
        tokenRepository.deleteAllByCompany(company);
        saveCompanyToken(jwtToken, company);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .companyId(company.getId())
                .role(company.getRole())
                .build();
    }

    private void saveCompanyToken(String jwtToken, Company company) {
        Token token = Token.builder()
                .token(jwtToken)
                .company(company)
                .build();
        tokenRepository.save(token);
    }
}
