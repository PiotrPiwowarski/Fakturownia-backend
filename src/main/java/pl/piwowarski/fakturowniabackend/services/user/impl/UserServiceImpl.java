package pl.piwowarski.fakturowniabackend.services.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.authentication.AuthenticationDto;
import pl.piwowarski.fakturowniabackend.dtos.authentication.LoginDto;
import pl.piwowarski.fakturowniabackend.dtos.user.GetUserDto;
import pl.piwowarski.fakturowniabackend.dtos.user.NewUserDto;
import pl.piwowarski.fakturowniabackend.entites.Token;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.exceptions.*;
import pl.piwowarski.fakturowniabackend.mappers.UserMapper;
import pl.piwowarski.fakturowniabackend.repository.TokenRepository;
import pl.piwowarski.fakturowniabackend.repository.UserRepository;
import pl.piwowarski.fakturowniabackend.services.jwt.JwtService;
import pl.piwowarski.fakturowniabackend.services.user.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addUser(NewUserDto newUserDto) {
        Optional<User> optionalUser = userRepository.findByEmail(newUserDto.getEmail());

        if(optionalUser.isPresent()) {
            throw new UserWithSuchEmailAlreadyExistsException();
        }

        String encodedPassword = passwordEncoder.encode(newUserDto.getPassword());
        User user = UserMapper.map(newUserDto, encodedPassword);
        userRepository.save(user);
    }

    @Override
    public GetUserDto getUser() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch(Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        return UserMapper.map(user);
    }

    @Override
    public void deleteUser() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch(Exception e) {
            throw new NoUserInSecurityContextHolderException();
        }
        userRepository.delete(user);
    }

    @Override
    public AuthenticationDto login(LoginDto loginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getEmail(),
                            loginDto.getPassword()
                    )
            );
        } catch(Exception e) {
            throw new NoUsersWithSuchEmailException();
        }
        User user = userRepository
                .findByEmail(loginDto.getEmail())
                .orElseThrow(NoUsersWithSuchEmailException::new);
        String jwtToken = jwtService.generateToken(user);
        tokenRepository.deleteAllByUser(user);
        saveUserToken(jwtToken, user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .paymentPlan(user.getPaymentPlan().toString())
                .role(user.getRole().toString())
                .build();
    }

    private void saveUserToken(String jwtToken, User user) {
        Token token = Token.builder()
                .token(jwtToken)
                .user(user)
                .build();
        tokenRepository.save(token);
    }
}
