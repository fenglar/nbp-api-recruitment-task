package pl.marcin.nbpapiprojectrt.exception;

public class InvalidCurrencyCodeException extends RuntimeException {
    public InvalidCurrencyCodeException(String message) {
        super(message);
    }
}
