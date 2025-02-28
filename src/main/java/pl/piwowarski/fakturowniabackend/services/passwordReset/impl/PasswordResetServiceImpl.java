package pl.piwowarski.fakturowniabackend.services.passwordReset.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.passwordReset.GenerateResetPasswordTokenDto;
import pl.piwowarski.fakturowniabackend.entites.PasswordResetToken;
import pl.piwowarski.fakturowniabackend.entites.User;
import pl.piwowarski.fakturowniabackend.exceptions.NoUsersWithSuchEmailException;
import pl.piwowarski.fakturowniabackend.repository.PasswordResetTokenRepository;
import pl.piwowarski.fakturowniabackend.repository.UserRepository;
import pl.piwowarski.fakturowniabackend.services.email.EmailService;
import pl.piwowarski.fakturowniabackend.services.passwordReset.PasswordResetService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PasswordResetServiceImpl implements PasswordResetService {

    private final UserRepository userRepository;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final EmailService emailService;
    private static final String SUBJECT = "Reset hasła U.nietly";


    @Override
    public void generateResetPasswordToken(GenerateResetPasswordTokenDto generateResetPasswordTokenDto) {
        Optional<User> optionalUser = userRepository.findByEmail(generateResetPasswordTokenDto.getEmail());
        if (optionalUser.isEmpty()) {
            throw new NoUsersWithSuchEmailException();
        }
        User user = optionalUser.get();
        PasswordResetToken token = generateToken(user);
        passwordResetTokenRepository.save(token);
        String message = "Zresetuj hasło za pomocą tego tokenu: " + token.getToken();
        emailService.sendEmail(user.getEmail(), SUBJECT, message);
    }

    private PasswordResetToken generateToken(User user) {
        LocalDateTime now = LocalDateTime.now();
        String token = UUID.randomUUID().toString();;
        return PasswordResetToken.builder()
                .user(user)
                .expirationDateTime(now.plusHours(1))
                .token(token)
                .build();
    }
}
