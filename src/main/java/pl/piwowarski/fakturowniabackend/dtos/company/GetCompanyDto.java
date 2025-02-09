package pl.piwowarski.fakturowniabackend.dtos.company;

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
    private String name;
    private String street;
    private String buildingNumber;
    private String postCode;
    private String city;
    private String nip;
    private String bankName;
    private String accountNumber;
    private long userId;
}
