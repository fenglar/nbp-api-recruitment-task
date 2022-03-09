package pl.marcin.nbpapiprojectrt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.marcin.nbpapiprojectrt.exception.ErrorResponse;
import pl.marcin.nbpapiprojectrt.exception.ExchangeRatesNotFoundException;
import pl.marcin.nbpapiprojectrt.exception.InvalidCurrencyCodeException;
import pl.marcin.nbpapiprojectrt.exception.UnknownException;


@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(InvalidCurrencyCodeException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCurrencyCodeExceptions(Exception e) {
        HttpStatus status = HttpStatus.NOT_FOUND;


        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
    }

    @ExceptionHandler(UnknownException.class)
    public ResponseEntity<ErrorResponse> handleUnknownExceptions(Exception e) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
    }

    @ExceptionHandler(ExchangeRatesNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleExchangeRatesNotFoundExceptions(Exception e) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptions(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);

    }
}
