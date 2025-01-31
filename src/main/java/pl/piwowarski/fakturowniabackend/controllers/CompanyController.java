package pl.piwowarski.fakturowniabackend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.fakturowniabackend.dtos.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.NewCompanyDto;
import pl.piwowarski.fakturowniabackend.services.Company.CompanyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
@Tag(name = "Items API")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "Dodanie nowej firmy")
    @PostMapping("/register")
    public ResponseEntity<Void> addUser(@RequestBody NewCompanyDto newCompanyDto) {
        companyService.addNewCompany(newCompanyDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Pobranie firmy po nipie")
    @GetMapping("/{nip}")
    public ResponseEntity<GetCompanyDto> getCompany(@PathVariable String nip) {
        GetCompanyDto getCompanyDto = companyService.getCompany(nip);
        return ResponseEntity.ok(getCompanyDto);
    }

    @Operation(summary = "Wylogowanie")
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.ok().build();
    }
}
