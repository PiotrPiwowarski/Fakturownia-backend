package pl.piwowarski.fakturowniabackend.services.Company;

import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.NewCompanyDto;

@Service
public interface CompanyService {
    void addNewCompany(NewCompanyDto newCompanyDto);
}
