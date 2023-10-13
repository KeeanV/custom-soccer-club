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
        players.add(p1);
        assertEquals(1 , players.size());
        assertEquals(p1 , players.get(0));
    }








}