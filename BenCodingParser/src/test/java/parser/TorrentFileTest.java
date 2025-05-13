package parser;

import org.junit.jupiter.api.Test;
import ru.cherkasov.BitTorrentParserImpl;

public class TorrentFileTest {
    private final BitTorrentParserImpl parser = new BitTorrentParserImpl();

    @Test
    public void debianFileTest() {

        String str = "d8:announce41:http://bttracker.debian.org:6969/announce7:comment33:Debian CD from cdimage.debian.org10:created by13:mktorrent 1.113:creation datei1742039925e4:infod6:lengthi663748608e4:name32:debian-12.10.0-amd64-netinst.iso12:piece lengthi262144eee";
        var torrent = parser.processElement(str, 0);
        System.out.println("chucha");
    }
}
