package pl.piwowarski.fakturowniabackend.dtos.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewUserDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String phoneNumber;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Min(value = 5)
    private String password;
}
