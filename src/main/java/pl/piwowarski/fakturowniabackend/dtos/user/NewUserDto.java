package pl.piwowarski.fakturowniabackend.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewUserDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
}
