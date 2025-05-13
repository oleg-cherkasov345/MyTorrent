package parser;

import org.junit.jupiter.api.Test;
import ru.cherkasov.BitTorrentParserImpl;
import ru.cherkasov.exception.TooLongStringElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    private final BitTorrentParserImpl parser = new BitTorrentParserImpl();

    @Test
    public void rightStringLessThenTenSymbolsTest() {
        var str = "asdfasdf";
        var elementString = str.length() + ":" + str;
        var benCodeElement = parser.processElement(elementString, 0);
        assertEquals(benCodeElement.getString(), str);
    }

    @Test
    public void rightStringMoreThenTenSymbolsTest() {
        var str = "asdfasdfasdfasdf";
        var elementString = str.length() + ":" + str;
        var benCodeElement = parser.processElement(elementString, 0);
        assertEquals(benCodeElement.getString(), str);
    }

    @Test
    public void emptyStringTest() {
        var str = "asdfasdfasdfasdf";
        var elementString = str.length() * 2 + ":" + str;
        assertThrows(TooLongStringElementException.class, () -> parser.processElement(elementString, 0));
    }
}
