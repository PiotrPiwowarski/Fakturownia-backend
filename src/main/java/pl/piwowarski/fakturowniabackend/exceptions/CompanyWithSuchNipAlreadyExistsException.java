package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class CompanyWithSuchNipAlreadyExistsException extends RuntimeException {

    private final String message;

    public CompanyWithSuchNipAlreadyExistsException() {
        this.message = "Firma z podanym numerem NIP już istnieje";
    }
}
