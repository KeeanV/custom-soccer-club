package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a workroom having a collection of players
// Based on JsonSerializationDemo from GitHub
public class WorkRoom implements Writable {
    private String name;
    private List<Player> players;

    // EFFECTS: constructs workroom with a name and empty list of players
    public WorkRoom(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds player to this workroom
    public void addPlayer(Player player) {
        players.add(player);
    }

    // EFFECTS: returns an unmodifiable list of players in this workroom
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    // EFFECTS: returns number of players in this workroom
    public int numPlayers() {
        return players.size();
    }

    // creates a Json object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("players", playersToJson());
        return json;
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

