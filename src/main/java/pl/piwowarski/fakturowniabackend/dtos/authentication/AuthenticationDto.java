package pl.piwowarski.fakturowniabackend.dtos.authentication;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.enums.PaymentPlan;
import pl.piwowarski.fakturowniabackend.enums.Role;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationDto {

    @NotNull
    private String token;
    @NotNull
    private String paymentPlan;
    @NotNull
    private String role;
}
