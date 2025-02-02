package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.piwowarski.fakturowniabackend.dtos.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.NewCompanyDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.enums.Role;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CompanyMapper {

    public static Company map(NewCompanyDto newCompanyDto, PasswordEncoder passwordEncoder) {
        return Company.builder()
                .companyName(newCompanyDto.getCompanyName())
                .street(newCompanyDto.getStreet())
                .buildingNumber(newCompanyDto.getBuildingNumber())
                .postCode(newCompanyDto.getPostCode())
                .city(newCompanyDto.getCity())
                .nip(newCompanyDto.getNip())
                .bankName(newCompanyDto.getBankName())
                .bankAccountNumber(newCompanyDto.getBankAccountNumber())
                .email(newCompanyDto.getEmail())
                .phoneNumber(newCompanyDto.getPhoneNumber())
                .password(passwordEncoder.encode(newCompanyDto.getPassword()))
                .role(Role.USER)
                .build();
    }

    public static GetCompanyDto map(Company company) {
        return GetCompanyDto.builder()
                .id(company.getId())
                .companyName(company.getCompanyName())
                .street(company.getStreet())
                .buildingNumber(company.getBuildingNumber())
                .postCode(company.getPostCode())
                .city(company.getCity())
                .nip(company.getNip())
                .bankName(company.getBankName())
                .bankAccountNumber(company.getBankAccountNumber())
                .email(company.getEmail())
                .phoneNumber(company.getPhoneNumber())
                .build();
    }
}
