package ru.cherkasov.exception;

import ru.cherkasov.BenCodeElement;
import ru.cherkasov.ElementType;

public class EmptyBenCodeElementException extends RuntimeException{
    public EmptyBenCodeElementException(ElementType elementType) {
        super("Empty bencode element - " + elementType.getElementChar() + "e");
    }

}
