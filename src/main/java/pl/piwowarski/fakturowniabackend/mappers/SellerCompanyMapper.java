package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SellerCompanyMapper {

    public static Company map(NewInvoiceDto newInvoiceDto, User user) {
        return Company.builder()
                .name(newInvoiceDto.getSellerCompanyName())
                .street(newInvoiceDto.getSellerCompanyStreet())
                .buildingNumber(newInvoiceDto.getSellerCompanyBuildingNumber())
                .postCode(newInvoiceDto.getSellerCompanyPostCode())
                .city(newInvoiceDto.getSellerCompanyCity())
                .nip(newInvoiceDto.getSellerCompanyNip())
                .bankName(newInvoiceDto.getSellerCompanyBankName())
                .accountNumber(newInvoiceDto.getSellerCompanyBankAccountNumber())
                .user(user)
                .build();
    }
}
