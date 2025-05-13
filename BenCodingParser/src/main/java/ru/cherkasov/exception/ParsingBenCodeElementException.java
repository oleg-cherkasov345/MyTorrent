package ru.cherkasov.exception;

import ru.cherkasov.ElementType;

public class ParsingBenCodeElementException extends RuntimeException {
    public ParsingBenCodeElementException(
            ElementType elementType,
            String errorElement,
            Throwable cause)
    {
        super(String.format("Error occurred while parsing %s. element = %s.", elementType, errorElement), cause);
    }
}
