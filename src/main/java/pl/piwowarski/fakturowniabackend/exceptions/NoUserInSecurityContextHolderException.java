package pl.piwowarski.fakturowniabackend.exceptions;

import lombok.Getter;

@Getter
public class NoUserInSecurityContextHolderException extends RuntimeException {

    private final String message;

    public NoUserInSecurityContextHolderException() {
        message = "Nie można podjąć id użytkownika z Security Context Holder";
    }
}
