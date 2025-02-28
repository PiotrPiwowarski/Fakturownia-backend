package pl.piwowarski.fakturowniabackend.dtos.passwordReset;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GenerateResetPasswordTokenDto {

    @NotNull
    private String email;
}
