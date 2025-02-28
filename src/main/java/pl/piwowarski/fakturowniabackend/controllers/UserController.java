package pl.piwowarski.fakturowniabackend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.fakturowniabackend.dtos.authentication.AuthenticationDto;
import pl.piwowarski.fakturowniabackend.dtos.authentication.LoginDto;
import pl.piwowarski.fakturowniabackend.dtos.passwordReset.GenerateResetPasswordTokenDto;
import pl.piwowarski.fakturowniabackend.dtos.passwordReset.ResetPasswordDto;
import pl.piwowarski.fakturowniabackend.dtos.user.GetUserDto;
import pl.piwowarski.fakturowniabackend.dtos.user.NewUserDto;
import pl.piwowarski.fakturowniabackend.services.passwordReset.PasswordResetService;
import pl.piwowarski.fakturowniabackend.services.user.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "Users API")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;
    private final PasswordResetService passwordResetService;

    @Operation(summary = "Stworzenie konta")
    @PostMapping("/register")
    public ResponseEntity<Void> addUser(@RequestBody NewUserDto newUserDto) {
        userService.addUser(newUserDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Pobieranie danych użytkownika")
    @GetMapping
    public ResponseEntity<GetUserDto> getUser() {
        GetUserDto getUserDto = userService.getUser();
        return ResponseEntity.ok(getUserDto);
    }

    @Operation(summary = "Zalogowanie")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationDto> login(@RequestBody LoginDto loginDto) {
        AuthenticationDto authenticationDto = userService.login(loginDto);
        return ResponseEntity.ok(authenticationDto);
    }

    @Operation(summary = "Wylogowanie")
    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Usuwanie konta")
    @DeleteMapping
    public ResponseEntity<Void> deleteUser() {
        userService.deleteUser();
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Generowanie tokenu resetu hasła")
    @PostMapping("/sendResetPasswordToken")
    public ResponseEntity<Void> generateResetPasswordToken(@RequestBody GenerateResetPasswordTokenDto generateResetPasswordTokenDto) {
        passwordResetService.generateResetPasswordToken(generateResetPasswordTokenDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Resetowanie hasła")
    @PutMapping("/resetPassword")
    public ResponseEntity<Void> resetPassword(@RequestBody ResetPasswordDto resetPasswordDto) {
        passwordResetService.resetPassword(resetPasswordDto);
        return ResponseEntity.ok().build();
    }
}
