package pl.piwowarski.fakturowniabackend.services.passwordReset;

import org.springframework.stereotype.Service;
import pl.piwowarski.fakturowniabackend.dtos.passwordReset.GenerateResetPasswordTokenDto;
import pl.piwowarski.fakturowniabackend.dtos.passwordReset.ResetPasswordDto;

@Service
public interface PasswordResetService {

    void generateResetPasswordToken(GenerateResetPasswordTokenDto generateResetPasswordTokenDto);
    void resetPassword(ResetPasswordDto resetPasswordDto);
}
