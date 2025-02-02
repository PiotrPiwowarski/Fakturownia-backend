package pl.piwowarski.fakturowniabackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.fakturowniabackend.enums.Role;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationDto {

    private String token;
    private long companyId;
    private Role role;
}
