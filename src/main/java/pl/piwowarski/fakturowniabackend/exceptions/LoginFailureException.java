package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class LoginFailureException extends RuntimeException {

    private final String message;

    public LoginFailureException() {
        this.message = "Błąd logowania";
    }
}
