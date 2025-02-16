package pl.piwowarski.fakturowniabackend.services.company;

import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;

import java.util.List;

@Service
public interface CompanyService {

    List<GetCompanyDto> getUserCompanies();
}
