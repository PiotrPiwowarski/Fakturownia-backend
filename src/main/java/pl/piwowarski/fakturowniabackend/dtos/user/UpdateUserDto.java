package pl.piwowarski.fakturowniabackend.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UpdateUserDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String phoneNumber;
}
