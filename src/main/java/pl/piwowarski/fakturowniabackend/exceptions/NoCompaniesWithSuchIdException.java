package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class NoCompaniesWithSuchIdException extends RuntimeException {

    private final String message;

    public NoCompaniesWithSuchIdException() {
        this.message = "Brak firm o podanych danych do logowania";
    }
}
