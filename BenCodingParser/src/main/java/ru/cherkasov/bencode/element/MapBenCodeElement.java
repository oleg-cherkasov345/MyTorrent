package ru.cherkasov.bencode.element;

import ru.cherkasov.ElementType;

import java.util.Map;

public class MapBenCodeElement extends AbstractBenCodeElement<Map<StringBenCodeElement, AbstractBenCodeElement<?>>> {
    MapBenCodeElement(Map<StringBenCodeElement, AbstractBenCodeElement<?>> value, ElementType type) {
        super(value, type);
    }
}
