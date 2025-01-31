package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class NoCompaniesWithSuchNipException extends RuntimeException {

    private final String message;

    public NoCompaniesWithSuchNipException() {
        this.message = "Brak firm o podanym nipie";
    }
}
