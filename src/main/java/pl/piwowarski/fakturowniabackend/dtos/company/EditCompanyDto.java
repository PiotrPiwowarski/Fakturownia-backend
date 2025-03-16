package pl.piwowarski.fakturowniabackend.dtos.company;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EditCompanyDto {

    private long id;
    @NotNull
    private String name;
    @NotNull
    private String street;
    @NotNull
    private String buildingNumber;
    @NotNull
    private String postCode;
    @NotNull
    private String city;
    @NotNull
    private String nip;
    private String bankName;
    private String accountNumber;
}
