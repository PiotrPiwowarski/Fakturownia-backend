package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class NoUsersWithSuchIdException extends RuntimeException {

    private final String message;

    public NoUsersWithSuchIdException() {
        this.message = "Brak użytkowników o podanym id";
    }
}
