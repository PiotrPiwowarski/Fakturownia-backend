package pl.piwowarski.fakturowniabackend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.piwowarski.fakturowniabackend.exceptions.*;

@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(CompanyWithSuchEmailAlreadyExistsException.class)
    public ResponseEntity<String> handle(CompanyWithSuchEmailAlreadyExistsException exception) {
        logger.error("Logowanie błędu: ", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(CompanyWithSuchNipAlreadyExistsException.class)
    public ResponseEntity<String> handle(CompanyWithSuchNipAlreadyExistsException exception) {
        logger.error("Logowanie błędu: ", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(LoginFailureException.class)
    public ResponseEntity<String> handle(LoginFailureException exception) {
        logger.error("Logowanie błędu: ", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(NoCompaniesWithSuchNipException.class)
    public ResponseEntity<String> handle(NoCompaniesWithSuchNipException exception) {
        logger.error("Logowanie błędu: ", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(NoUsersWithSuchEmailException.class)
    public ResponseEntity<String> handle(NoUsersWithSuchEmailException exception) {
        logger.error("Logowanie błędu: ", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(NoUsersWithSuchIdException.class)
    public ResponseEntity<String> handle(NoUsersWithSuchIdException exception) {
        logger.error("Logowanie błędu: ", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(ThisTokenIsNotActiveException.class)
    public ResponseEntity<String> handle(ThisTokenIsNotActiveException exception) {
        logger.error("Logowanie błędu: ", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(UserWithSuchEmailAlreadyExistsException.class)
    public ResponseEntity<String> handle(UserWithSuchEmailAlreadyExistsException exception) {
        logger.error("Logowanie błędu: ", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception exception) {
        logger.error("Logowanie błędu: ", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
