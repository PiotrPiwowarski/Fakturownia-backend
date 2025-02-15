package pl.piwowarski.fakturowniabackend.services.user;

import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.authentication.AuthenticationDto;
import pl.piwowarski.fakturowniabackend.dtos.authentication.LoginDto;
import pl.piwowarski.fakturowniabackend.dtos.user.GetUserDto;
import pl.piwowarski.fakturowniabackend.dtos.user.NewUserDto;

@Service
public interface UserService {

    AuthenticationDto login(LoginDto loginDto);
    void addUser(NewUserDto newUserDto);
    GetUserDto getUser();
    void deleteUser();
}
