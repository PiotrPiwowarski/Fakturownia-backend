package pl.piwowarski.fakturowniabackend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.company.NewCompanyDto;
import pl.piwowarski.fakturowniabackend.services.company.CompanyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
@Tag(name = "Companies API")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "Pobranie listy firm")
    @GetMapping
    public ResponseEntity<List<GetCompanyDto>> getCompaniesByUserId() {
        List<GetCompanyDto> userCompanies = companyService.getUserCompanies();
        return ResponseEntity.ok(userCompanies);
    }

    @Operation(summary = "Dodanie firmy")
    @PostMapping
    public ResponseEntity<Void> addCompany(@RequestBody NewCompanyDto newCompanyDto) {
        companyService.addCompany(newCompanyDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Usuwanie firmy")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable long id) {
        companyService.deleteCompanyById(id);
        return ResponseEntity.ok().build();
    }
}
