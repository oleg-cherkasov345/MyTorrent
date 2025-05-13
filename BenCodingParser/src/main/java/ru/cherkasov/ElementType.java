package ru.cherkasov;

import lombok.Getter;

@Getter
public enum ElementType{
    DIGIT('i'),
    STRING('-'),
    LIST('l'),
    DICTIONARY('d');

    private final char elementChar;

    ElementType(char elementChar) {
        this.elementChar = elementChar;
    }
}