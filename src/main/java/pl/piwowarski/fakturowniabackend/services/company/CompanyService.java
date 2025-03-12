package pl.piwowarski.fakturowniabackend.services.company;

import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.company.NewCompanyDto;

import java.util.List;

@Service
public interface CompanyService {

    List<GetCompanyDto> getUserCompanies();
    void deleteCompanyById(long id);
    void addCompany(NewCompanyDto newCompanyDto);
}
