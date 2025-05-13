package ru.cherkasov;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * The class represented bencode elements like String, Integer, List and Dictionary.
 * This class need for using in Map's.
 * The string from where element geted is remembered, it used for equel and hashcode.
 */
@Getter
@Builder()
public class BenCodeElement {
    private String elementString;
    private int digit;
    private String string;
    private List<BenCodeElement> list;
    private Map<BenCodeElement, BenCodeElement> dictionary;
    private ElementType type;

    public int getElementLength() {
        return elementString.length();
    }

    @Override
    public int hashCode() {
        return elementString.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof BenCodeElement another){
            return another.getElementString().equals(elementString);
        }
        return false;
    }


}
