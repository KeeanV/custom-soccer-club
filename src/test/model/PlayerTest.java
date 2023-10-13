package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    private Player p5;

    @BeforeEach
    void runBefore() {
        p1 = new Player("Bob", 2, 4, false);
    }

    @Test
    void testConstructor() {
        assertEquals("Bob" , p1.getPlayerName());
        assertEquals(2, p1.getGoalsScored());
        assertEquals(4, p1.getAssistsMade());
        assertEquals(false, p1.getCleanSheet());
    }

    @Test
    void testCalculateTotalPoints() {
        assertEquals(36 , p1.calculateTotalPoints());
    }
}
