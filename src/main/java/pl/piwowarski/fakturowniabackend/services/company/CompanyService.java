package pl.piwowarski.fakturowniabackend.services.company;

import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.company.NewCompanyDto;

@Service
public interface CompanyService {

    void addNewCompany(NewCompanyDto newCompanyDto);
    GetCompanyDto getCompany(String nip);
}
