package parser;

import org.junit.jupiter.api.Test;
import ru.cherkasov.BitTorrentParserImpl;
import ru.cherkasov.exception.EmptyBenCodeElementException;
import ru.cherkasov.exception.ParsingBenCodeElementException;

import static org.junit.jupiter.api.Assertions.*;


public class DigitTest {

    private final BitTorrentParserImpl parser = new BitTorrentParserImpl();

    @Test
    public void oneSymbolDigitTest() {
        var digit = 3;
        var elementDigit = "i" + digit + "e";
        var benCodeElement = parser.processElement(elementDigit, 0);
        assertEquals(benCodeElement.getDigit(), digit);
    }

    @Test
    public void severalSymbolsDigitTest() {
        var digit = 312312;
        var elementDigit = "i" + digit + "e";
        var benCodeElement = parser.processElement(elementDigit, 0);
        assertEquals(benCodeElement.getDigit(), digit);
    }

    @Test
    public void wrongDigitTest() {
        var digit = "312312p";
        var elementDigit = "i" + digit + "e";
        assertThrows(ParsingBenCodeElementException.class, () -> parser.processElement(elementDigit, 0));
    }

    @Test
    public void emptyDigitTest() {
        var digit = "";
        var elementDigit = "i" + digit + "e";
        assertThrows(EmptyBenCodeElementException.class, () -> parser.processElement(elementDigit, 0));
    }
}
