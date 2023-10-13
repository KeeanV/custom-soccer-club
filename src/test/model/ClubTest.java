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
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    private Player p5;
    private Player p6;
    private Player p7;
    private Player p8;
    private Player p9;
    private Player p10;
    private Player p11;
    private Player p12;
    private Player p13;


    @BeforeEach
    void runBefore() {
        testClub = new Club("Vancouver City");
        this.players = new ArrayList<>();
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

    @Test
    void testAddTooManyPlayers() {
       players.add(p1);
       players.add(p2);
       players.add(p3);
       players.add(p4);
       players.add(p5);
       players.add(p6);
       players.add(p7);
       players.add(p8);
       players.add(p9);
       players.add(p10);
       players.add(p11);
       players.add(p12);
       players.add(p13);
       assertEquals(11, players.size());


    }




}