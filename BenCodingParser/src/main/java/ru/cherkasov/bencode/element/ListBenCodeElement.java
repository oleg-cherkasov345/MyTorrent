package ru.cherkasov.bencode.element;

import ru.cherkasov.ElementType;

import java.util.List;

public class ListBenCodeElement extends AbstractBenCodeElement<List<AbstractBenCodeElement<?>>> {

    public ListBenCodeElement(List<AbstractBenCodeElement<?>> value, ElementType type) {
        super(value, type);
    }
}
