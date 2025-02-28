package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class SendingEmailFailureException extends RuntimeException {

    private final String message;

    public SendingEmailFailureException() {
        message = "Błąd podczas wysyłania maila";
    }
}
