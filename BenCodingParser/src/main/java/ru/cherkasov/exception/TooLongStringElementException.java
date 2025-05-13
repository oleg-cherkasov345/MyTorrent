package ru.cherkasov.exception;

public class TooLongStringElementException extends RuntimeException{
    public TooLongStringElementException(String element, int expected, int turnedOut) {
        super("Too long element string - %s. expected - %d symbols, turned out - %d"
                .formatted(element, expected, turnedOut));
    }
}
