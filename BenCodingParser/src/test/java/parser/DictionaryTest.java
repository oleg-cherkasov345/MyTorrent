package parser;

import org.junit.jupiter.api.Test;
import ru.cherkasov.BenCodeElement;
import ru.cherkasov.BitTorrentParserImpl;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DictionaryTest {
    private final BitTorrentParserImpl parser = new BitTorrentParserImpl();

    @Test
    public void rightDictionaryTest() {
        var exampleDictionary = "d3:cow3:moo4:spam4:eggsee";
        Map<BenCodeElement, BenCodeElement> map = Map.of(
                prepareStringElement("cow"),
                prepareStringElement("moo"),
                prepareStringElement("spam"),
                prepareStringElement("eggs")
        );
        assertEquals(map, parser.processElement(exampleDictionary, 0).getDictionary());
    }

    private BenCodeElement prepareStringElement(String str) {
        var element = str.length() + ":" + str;
        return parser.processElement(element, 0);
    }

    private BenCodeElement prepareDigitElement(int digit) {
        var element = "i" + digit + "e";
        return parser.processElement(element, 0);
    }
}
