package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a workroom having a collection of thingies
// Based on JsonSerializationDemo from GitHub
public class WorkRoom implements Writable {
    private String name;
    private List<Player> players;

    // EFFECTS: constructs workroom with a name and empty list of thingies
    public WorkRoom(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds thingy to this workroom
    public void addPlayer(Player player) {
        players.add(player);
    }

    // EFFECTS: returns an unmodifiable list of thingies in this workroom
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    // EFFECTS: returns number of thingies in this workroom
    public int numPlayers() {
        return players.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("players", playersToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray playersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Player player : players) {
            jsonArray.put(player.toJson());
        }

        return jsonArray;
    }
}

