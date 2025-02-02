package pl.piwowarski.fakturowniabackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.piwowarski.fakturowniabackend.dtos.user.GetUserDto;
import pl.piwowarski.fakturowniabackend.dtos.user.NewUserDto;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.enums.Role;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapper {

    public static User map(NewUserDto newUserDto, PasswordEncoder passwordEncoder) {
        return User.builder()
                .firstName(newUserDto.getFirstName())
                .lastName(newUserDto.getLastName())
                .phoneNumber(newUserDto.getPhoneNumber())
                .email(newUserDto.getEmail())
                .password(passwordEncoder.encode(newUserDto.getPassword()))
                .role(Role.USER)
                .build();
    }

    public static GetUserDto map(User user) {
        return GetUserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }
}
