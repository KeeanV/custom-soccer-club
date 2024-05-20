package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// represents a club containing a list of players, and having a name.
public class Club implements Writable {
    private final String clubName;
    private final List<Player> players;
    private static final int CLUB_CAPACITY = 11;

    // REQUIRES: string with length > 0
    // EFFECTS: creates a club with a name and empty list of players.
    public Club(String clubName) {
        this.clubName = clubName;
        this.players = new ArrayList<>(CLUB_CAPACITY);
    }

    // REQUIRES: player object
    // MODIFIES: this
    // EFFECTS: adds a player object to the club's list of players if there are less than 11 players in the club
    public void addPlayer(Player player) {
        if (this.players.size() < CLUB_CAPACITY) {
            this.players.add(player);
            EventLog.getInstance().logEvent(new Event(player.getPlayerName() + " was added to club."));
        }
    }

    // REQUIRES: player object
    // MODIFIES: this
    // EFFECTS: removes a player object from the club's list of players
    public void removePlayer(Player player) {
        this.players.remove(player);
        EventLog.getInstance().logEvent(new Event(player + " was removed from club"));
    }

    // REQUIRES: club object
    // EFFECTS: returns a list of players added to the club
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>(this.players);
        EventLog.getInstance().logEvent(new Event("List of players in club was accessed"));
        return players;
    }

    // REQUIRES: club object
    // EFFECTS: adds the individual points of each player in the club and returns the total points for the club
    public int calculateTotalPoints() {
        int totalPoints = 0;
        List<Player> players = this.getPlayers();
        for (Player player : players) {
            totalPoints += player.calculateTotalPoints();
        }
        return totalPoints;
    }

    public String getClubName() {
        return this.clubName;
    }

    // EFFECTS: creates a club as a Json object
    @Override
    public JSONObject toJson() {
        JSONObject clubAsJson = new JSONObject();
        clubAsJson.put("name", clubName);
        clubAsJson.put("players", playersToJson());
        return clubAsJson;
    }

    // EFFECTS: returns players in this workroom as a JSON array
    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player player : players) {
            jsonArray.put(player.toJson());
        }

        return jsonArray;
    }
}
