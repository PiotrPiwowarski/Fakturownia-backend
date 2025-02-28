package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class NoPasswordResetTokenWithSuchUserAndTokenException extends RuntimeException {

    private final String message;

    public NoPasswordResetTokenWithSuchUserAndTokenException() {
        this.message = "Brak tokenu w bazie danych";
    }
}
