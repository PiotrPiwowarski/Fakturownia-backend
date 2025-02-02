package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class NoUsersWithSuchEmailException extends RuntimeException {

    private final String message;

    public NoUsersWithSuchEmailException() {
        this.message = "Brak użytkowników o podanym emailu";
    }
}
