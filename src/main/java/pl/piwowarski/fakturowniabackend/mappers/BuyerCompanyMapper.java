package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.dtos.invoice.NewInvoiceDto;
import pl.piwowarski.fakturowniabackend.entites.Company;
import pl.piwowarski.fakturowniabackend.entites.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BuyerCompanyMapper {

    public static Company map(NewInvoiceDto newInvoiceDto, User user) {
        return Company.builder()
                .name(newInvoiceDto.getBuyerCompanyName())
                .street(newInvoiceDto.getBuyerCompanyStreet())
                .buildingNumber(newInvoiceDto.getBuyerCompanyBuildingNumber())
                .postCode(newInvoiceDto.getBuyerCompanyPostCode())
                .city(newInvoiceDto.getBuyerCompanyCity())
                .nip(newInvoiceDto.getBuyerCompanyNip())
                .bankName(newInvoiceDto.getBuyerCompanyBankName())
                .accountNumber(newInvoiceDto.getBuyerCompanyBankAccountNumber())
                .user(user)
                .build();
    }
}
