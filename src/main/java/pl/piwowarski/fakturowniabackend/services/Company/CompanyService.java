package pl.piwowarski.fakturowniabackend.services.Company;

import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.AuthenticationDto;
import pl.piwowarski.fakturowniabackend.dtos.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.LoginDto;
import pl.piwowarski.fakturowniabackend.dtos.NewCompanyDto;

@Service
public interface CompanyService {

    void addNewCompany(NewCompanyDto newCompanyDto);
    GetCompanyDto getCompany(String nip);
    AuthenticationDto login(LoginDto loginDto);
}
