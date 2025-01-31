package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class CompanyWithSuchEmailAlreadyExistsException extends RuntimeException {

    private final String message;

    public CompanyWithSuchEmailAlreadyExistsException() {
        this.message = "Firma z tym emailem już istnieje";
    }
}
