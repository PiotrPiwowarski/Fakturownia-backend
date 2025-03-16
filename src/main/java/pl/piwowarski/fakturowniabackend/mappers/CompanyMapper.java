package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.dtos.company.EditCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.company.GetCompanyDto;
import pl.piwowarski.fakturowniabackend.dtos.company.NewCompanyDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CompanyMapper {

    public static Company map(NewCompanyDto newCompanyDto, User user) {
        return Company.builder()
                .name(newCompanyDto.getCompanyName())
                .street(newCompanyDto.getStreet())
                .buildingNumber(newCompanyDto.getBuildingNumber())
                .postCode(newCompanyDto.getPostCode())
                .city(newCompanyDto.getCity())
                .nip(newCompanyDto.getNip())
                .bankName(newCompanyDto.getBankName())
                .accountNumber(newCompanyDto.getAccountNumber())
                .user(user)
                .build();
    }

    public static GetCompanyDto map(Company company) {
        return GetCompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .street(company.getStreet())
                .buildingNumber(company.getBuildingNumber())
                .postCode(company.getPostCode())
                .city(company.getCity())
                .nip(company.getNip())
                .bankName(company.getBankName())
                .accountNumber(company.getAccountNumber())
                .userId(company.getUser().getId())
                .build();
    }

    public static Company map(EditCompanyDto editCompanyDto, User user) {
        return Company.builder()
                .id(editCompanyDto.getId())
                .name(editCompanyDto.getName())
                .street(editCompanyDto.getStreet())
                .buildingNumber(editCompanyDto.getBuildingNumber())
                .postCode(editCompanyDto.getPostCode())
                .city(editCompanyDto.getCity())
                .nip(editCompanyDto.getNip())
                .bankName(editCompanyDto.getBankName())
                .accountNumber(editCompanyDto.getAccountNumber())
                .user(user)
                .build();
    }

}
