package pl.piwowarski.fakturowniabackend.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.enums.PaymentPlan;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewUserDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String phoneNumber;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 5)
    private String password;
    @NotNull
    private String paymentPlan;
}
