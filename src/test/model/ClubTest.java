package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClubTest {
    private Club testClub;
    private List<Player> players;
    public Player p1;
    public Player p2;
    public Player p3;
    public Player p4;
    public Player p5;
    public Player p6;
    public Player p7;
    public Player p8;
    public Player p9;
    public Player p10;
    public Player p11;
    public Player p12;
    public Player p13;


    @BeforeEach
    void runBefore() {
        testClub = new Club("Vancouver City");
        this.players = new ArrayList<>();
        p1 = new Player("Bob" , 1, 1, true);
        p2 = new Player("Joe" , 2, 0, true);
    }

    @Test
    void testConstructor() {
        assertEquals("Vancouver City" , testClub.getClubName());
        assertEquals(0, players.size());
    }

    @Test
    void testAddPlayer() {
        testClub.addPlayer(p1);
        testClub.addPlayer(p2);
        assertEquals(2,testClub.getPlayers().size() );
    }

    @Test
    void testRemovePlayer() {
        testClub.addPlayer(p1);
        testClub.addPlayer(p2);
        assertEquals(2,testClub.getPlayers().size() );
        testClub.removePlayer(p1);
        assertEquals(1, testClub.getPlayers().size());
    }

    @Test
    void testAddTooManyPlayers() {
        testClub.addPlayer(p1);
        testClub.addPlayer(p2);
        testClub.addPlayer(p3);
        testClub.addPlayer(p4);
        testClub.addPlayer(p5);
        testClub.addPlayer(p6);
        testClub.addPlayer(p7);
        testClub.addPlayer(p8);
        testClub.addPlayer(p9);
        testClub.addPlayer(p10);
        testClub.addPlayer(p11);
        testClub.addPlayer(p12);
        assertEquals(11, testClub.getPlayers().size());

    }

    @Test
    void testCalculateTotalPoints() {
       testClub.addPlayer(p1);
       testClub.addPlayer(p2);
       assertEquals(15, p1.calculateTotalPoints());
       assertEquals(18, p2.calculateTotalPoints());
       assertEquals(33,testClub.calculateTotalPoints());
    }

    @Test
    void testCalculateTotalPointsZeroPlayers() {
        assertEquals(0 ,testClub.calculateTotalPoints());
        assertEquals(0,testClub.getPlayers().size());
    }







}