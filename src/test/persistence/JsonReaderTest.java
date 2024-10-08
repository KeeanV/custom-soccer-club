package persistence;

import model.Club;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Club wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            Club wr = reader.read();
            assertEquals("My club", wr.getClubName());
            assertEquals(0, wr.getPlayers().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

//    @Test
//    void testReaderGeneralWorkRoom() {
//        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
//        try {
//            Club wr = reader.read();
//            assertEquals("My club", wr.getClubName());
//            List<Player> players = wr.getPlayers();
//            assertEquals(2, players.size());
//            checkPlayer("bob",  players.get(0));
//        } catch (IOException e) {
//            fail("Couldn't read from file");
//        }
//    }
}