package ru.cherkasov.bencode.element;

import ru.cherkasov.ElementType;

public class StringBenCodeElement extends AbstractBenCodeElement<String>{
    public StringBenCodeElement(String value, ElementType type) {
        super(value, type);
    }
}
