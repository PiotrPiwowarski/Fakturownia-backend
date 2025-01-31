package pl.piwowarski.fakturowniabackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetCompanyDto {

    private long id;
    private String companyName;
    private String street;
    private String buildingNumber;
    private String postCode;
    private String city;
    private String nip;
    private String regon;
    private String bankName;
    private String bankAccountNumber;
    private String email;
    private String phoneNumber;
}
