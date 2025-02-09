package pl.piwowarski.fakturowniabackend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.company.NewCompanyDto;
import pl.piwowarski.fakturowniabackend.services.company.CompanyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
@Tag(name = "Companies API")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "Dodanie nowej firmy")
    @PostMapping("/add")
    public ResponseEntity<Void> addCompany(@RequestBody NewCompanyDto newCompanyDto) {
        companyService.addNewCompany(newCompanyDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Pobranie firmy po nipie")
    @GetMapping("/{nip}")
    public ResponseEntity<GetCompanyDto> getCompany(@PathVariable String nip) {
        GetCompanyDto getCompanyDto = companyService.getCompany(nip);
        return ResponseEntity.ok(getCompanyDto);
    }
}
