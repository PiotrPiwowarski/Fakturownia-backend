package pl.piwowarski.fakturowniabackend.dtos.authentication;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginDto {

    @NotNull
    private String email;
    @NotNull
    private String password;
}
