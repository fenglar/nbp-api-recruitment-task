package pl.marcin.nbpapiprojectrt.exception;

public class ExchangeRatesNotFoundException extends RuntimeException {
    public ExchangeRatesNotFoundException(String message) {
        super(message);
    }
}
