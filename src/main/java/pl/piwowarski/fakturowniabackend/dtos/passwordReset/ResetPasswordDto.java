package pl.piwowarski.fakturowniabackend.dtos.passwordReset;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResetPasswordDto {

    @NotNull
    @Email
    private String email;
    @NotNull
    private String resetToken;
    @NotNull
    @Size(min = 5)
    private String newPassword;
}
