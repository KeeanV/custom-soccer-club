package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player p1;
//    private Player p2;
//    private Player p3;
//    private Player p4;
//    private Player p5;

    @BeforeEach
    void runBefore() {
        p1 = new Player("Bob", 2, 4, false);
    }

    @Test
    void testConstructor() {
        assertEquals("Bob" , p1.getPlayerName());
        assertEquals(2, p1.getGoalsScored());
        assertEquals(4, p1.getAssistsMade());
        assertFalse(p1.getCleanSheet());
    }

    @Test
    void testCalculateTotalPoints() {
        assertEquals(36 , p1.calculateTotalPoints());
    }

    @Test
    void testScoreGoal() {
        p1.scoreGoal(3);
        assertEquals(5, p1.getGoalsScored());
    }

    @Test
    void testMakeAssist() {
        p1.makeAssist(3);
        assertEquals(7, p1.getAssistsMade());
    }

    @Test
    void testSetCleanSheet() {
        assertFalse(p1.getCleanSheet());
        p1.setCleanSheet(true);
        assertTrue(p1.getCleanSheet());
    }

    // based on toString() method in TellerApp from GitHub
    @Test
    void testToString() {
        assertTrue( p1.toString().contains("Name: Bob  Goals: 2  Assists: 4  Clean sheet?: false"));
    }
}
