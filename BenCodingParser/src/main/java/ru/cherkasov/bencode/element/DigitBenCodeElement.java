package ru.cherkasov.bencode.element;

import ru.cherkasov.ElementType;

public class DigitBenCodeElement extends AbstractBenCodeElement<Integer>{
    DigitBenCodeElement(Integer value, ElementType type) {
        super(value, type);
    }
}
