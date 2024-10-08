package persistence;

import model.Club;
import model.Player;
//import model.WorkRoom;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Based on JsonSerializationDemo from GitHub
// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Club read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Club parseWorkRoom(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Club wr = new Club(name);
        addPlayers(wr, jsonObject);
        return wr;
    }

    // MODIFIES: wr
    // EFFECTS: parses players from JSON object and adds them to workroom
    private void addPlayers(Club wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("players");
        for (Object json : jsonArray) {
            JSONObject nextPlayer = (JSONObject) json;
            addPlayer(wr, nextPlayer);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses player from JSON object and adds it to workroom
    private void addPlayer(Club wr, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int goalsScored = jsonObject.getInt("goalsScored");
        int assistsMade = jsonObject.getInt("assistsMade");
        boolean cleanSheet = jsonObject.getBoolean("cleanSheet");
        Player player = new Player(name, goalsScored, assistsMade, cleanSheet);
        wr.addPlayer(player);
    }
}
