package pl.piwowarski.fakturowniabackend.dtos.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewCompanyDto {

    private String companyName;
    private String street;
    private String buildingNumber;
    private String postCode;
    private String city;
    private String nip;
    private String bankName;
    private String bankAccountNumber;
    private long userId;
}
