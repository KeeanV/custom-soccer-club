package model;

import java.util.ArrayList;
import java.util.List;

// represents a club containing a list of players, and having a name.
public class Club {
    private String clubName;
    private List<Player> players;

    // REQUIRES: string with length > 0
    // EFFECTS: creates a club with a name and empty list of players.
    public Club(String clubName) {
        this.clubName = clubName;
        this.players = new ArrayList<>(11);
    }

    // REQUIRES: player object
    // MODIFIES: this
    // EFFECTS: adds a player object to the club's list of players, returns true if player was successfully added
    public boolean addPlayer(Player player) {
        if (this.players.size() < 11) {
            this.players.add(player);
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: player object
    // MODIFIES: this
    // EFFECTS: removes a player object from the club's list of players, returns true if player was successfully removed
    public boolean removePlayer(Player player) {
        this.players.remove(player);
        return true;
    }

    // REQUIRES: club object
    // EFFECTS: returns a list of players added to the club
    public List<Player> getPlayers(Club club) {
        List<Player> players = new ArrayList<>();
        for (Player player : this.players) {
            players.add(player);
        }
        return players;
    }

    // REQUIRES: club object
    // EFFECTS: adds the individual points of each player in the club and returns the total points for the club
    public int calculateTotalPoints(Club club) {
        int totalPoints = 0;
        List<Player> players = club.getPlayers(club);
        for (Player player : players) {
            totalPoints += player.getTotalPoints();
        }
        return totalPoints;
    }

    public String getClubName() {
        return this.clubName;
    }







}
