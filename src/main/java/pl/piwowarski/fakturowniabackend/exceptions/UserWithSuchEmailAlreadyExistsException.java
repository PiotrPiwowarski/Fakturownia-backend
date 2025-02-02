package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class UserWithSuchEmailAlreadyExistsException extends RuntimeException {

    private final String message;

    public UserWithSuchEmailAlreadyExistsException() {
        this.message = "Użytkownik o podanym emailu już istnieje";
    }
}
