package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class NoPermissionToPerformTheOperation extends RuntimeException {

    private final String message;

    public NoPermissionToPerformTheOperation() {
        this.message = "Nie posiadasz uprawnień do wykonania tej operacji";
    }
}
