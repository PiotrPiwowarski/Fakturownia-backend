package pl.piwowarski.fakturowniabackend.services.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.authentication.AuthenticationDto;
import pl.piwowarski.fakturowniabackend.dtos.authentication.LoginDto;
import pl.piwowarski.fakturowniabackend.dtos.user.GetUserDto;
import pl.piwowarski.fakturowniabackend.dtos.user.NewUserDto;
import pl.piwowarski.fakturowniabackend.entites.Token;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.exceptions.LoginFailureException;
import pl.piwowarski.fakturowniabackend.exceptions.NoUsersWithSuchEmailException;
import pl.piwowarski.fakturowniabackend.exceptions.NoUsersWithSuchIdException;
import pl.piwowarski.fakturowniabackend.exceptions.UserWithSuchEmailAlreadyExistsException;
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

        User user = UserMapper.map(newUserDto, passwordEncoder);
        userRepository.save(user);
    }

    @Override
    public GetUserDto getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()) {
            throw new NoUsersWithSuchIdException();
        }

        return UserMapper.map(optionalUser.get());
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
            throw new LoginFailureException();
        }
        User user = userRepository
                .findByEmail(loginDto.getEmail())
                .orElseThrow(NoUsersWithSuchEmailException::new);
        String jwtToken = jwtService.generateToken(user);
        tokenRepository.deleteAllByUser(user);
        saveUserToken(jwtToken, user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .userId(user.getId())
                .role(user.getRole())
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
