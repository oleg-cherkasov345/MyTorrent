package ru.cherkasov;

import ru.cherkasov.exception.EmptyBenCodeElementException;
import ru.cherkasov.exception.ParsingBenCodeElementException;
import ru.cherkasov.exception.TooLongStringElementException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitTorrentParserImpl {

    public BenCodeElement processElement(String line, int index) {
        if (Character.isDigit(line.charAt(index))) {
            return getStringBenCodeElement(line, index);
        }

        return switch (line.charAt(index)) {
            case 'i' -> getDigitBenCodeElement(line, index);
            case 'l' -> getListBenCodeElement(line, index);
            case 'd' -> getDictionaryBenCodeElement(line, index);
            default -> throw new RuntimeException();
        };
    }

    private BenCodeElement getListBenCodeElement(String line, int index) {
        checkForEmptyElement(line, index, ElementType.LIST);

        List<BenCodeElement> benCodeElementList = new ArrayList<>();
        int startIndex = index;

        while (line.charAt(++index) != 'e') {
            var newElement = processElement(line, index);
            benCodeElementList.add(newElement);
            index += newElement.getElementLength() - 1;
        }

        return BenCodeElement.builder()
                .list(benCodeElementList)
                .elementString(line.substring(startIndex, index + 1))
                .type(ElementType.LIST)
                .build();
    }

    private BenCodeElement getDictionaryBenCodeElement(String line, int index) {
        checkForEmptyElement(line, index, ElementType.DICTIONARY);

        Map<BenCodeElement, BenCodeElement> benCodeElementMap = new HashMap<>();
        int startIndex = index;

        while (line.charAt(++index) != 'e') {
            var keyElement = processElement(line, index);
            if (keyElement.getString().equals("piece length")) {
                System.out.println("chucha");
            }
            index += keyElement.getElementLength();
            var valueElement = processElement(line, index);
            index += valueElement.getElementLength() - 1;
            benCodeElementMap.put(keyElement, valueElement);
        }

        return BenCodeElement.builder()
                .dictionary(benCodeElementMap)
                .elementString(line.substring(startIndex, index + 1))
                .type(ElementType.LIST)
                .build();
    }

    private BenCodeElement getDigitBenCodeElement(String line, int index) {
        checkForEmptyElement(line, index, ElementType.DIGIT);
        var digitFromString = getDigitFromStringForDigitElement(line, index + 1);
        var elementString = "i" + digitFromString + "e";
        BenCodeElement digitElement;
        try {
            digitElement = BenCodeElement.builder()
                    .digit(Integer.parseInt(digitFromString.toString()))
                    .elementString(elementString)
                    .type(ElementType.DIGIT)
                    .build();
        } catch (NumberFormatException ex) {
            throw new ParsingBenCodeElementException(ElementType.DIGIT, elementString, ex);
        }
        return digitElement;
    }

    private BenCodeElement getStringBenCodeElement(String line, int index) {
        var digitFromString = getDigitFromStringForStringElement(line, index);
        var stringElementLength = Integer.parseInt(digitFromString.toString());
        var startStringIndex = index + digitFromString.length() + 1;
        var endStringIndex = startStringIndex + stringElementLength;

        if (endStringIndex > line.length()) {
            throw new TooLongStringElementException(
                    line.substring(index),
                    stringElementLength,
                    line.length() - startStringIndex
            );
        }

        return BenCodeElement.builder()
                .string(line.substring(startStringIndex, endStringIndex))
                .elementString(line.substring(index, endStringIndex))
                .type(ElementType.STRING)
                .build();
    }

    private StringBuilder getDigitFromStringForStringElement(String line, int index) {
        StringBuilder intBuilder = new StringBuilder();
        do {
            intBuilder.append(line.charAt(index++));
        } while (Character.isDigit(line.charAt(index)));
        return intBuilder;
    }

    private StringBuilder getDigitFromStringForDigitElement(String line, int index) {
        StringBuilder intBuilder = new StringBuilder();
        do {
            intBuilder.append(line.charAt(index++));
        } while (line.charAt(index) != 'e');
        return intBuilder;
    }

    private void checkForEmptyElement(String line, int index, ElementType elementType) {
        if (line.charAt(index + 1) == 'e') {
            throw new EmptyBenCodeElementException(elementType);
        }
    }
}
