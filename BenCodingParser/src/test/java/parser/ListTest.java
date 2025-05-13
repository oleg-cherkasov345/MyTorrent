package parser;

import org.junit.jupiter.api.Test;
import ru.cherkasov.BenCodeElement;
import ru.cherkasov.BitTorrentParserImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTest {
    private final BitTorrentParserImpl parser = new BitTorrentParserImpl();

    @Test
    public void rightListTest() {
        List<BenCodeElement> expected = List.of(prepareStringElement("spam"), prepareStringElement("eggs"));
        var exampleList = "l4:spam4:eggse";
        assertEquals(expected, parser.processElement(exampleList, 0).getList());
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
