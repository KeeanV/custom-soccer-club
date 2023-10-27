package model;

import org.json.JSONObject;
import persistence.Writable;

//import java.lang.reflect.WildcardType;

//Represents a player added to a club having a name, # of goals, assists, and clean sheets.
public class Player implements Writable {
    private final String playerName;
    private int goalsScored;
    private int assistsMade;
    private boolean cleanSheet;
    private int totalPoints;
    public static final int POINTS_AWARDED_FOR_GOAL = 8;
    public static final int POINTS_AWARDED_FOR_ASSIST = 5;
    public static final int POINTS_AWARDED_FOR_CLEAN_SHEET = 2;

    // REQUIRES: playerName with length > 0, goalsScored and assistsMade >= 0
    // EFFECTS: creates a player with a name, goalsScored and assistsMade = 0 by default, cleanSheet false by default
    public Player(String playerName, int goalsScored, int assistsMade, boolean cleanSheet) {
        this.playerName = playerName;
        this.goalsScored = goalsScored;
        this.assistsMade = assistsMade;
        this.cleanSheet = cleanSheet;
    }

    // EFFECTS: calculates the total points of a player and returns that value
    public int calculateTotalPoints() {
        this.totalPoints = (this.goalsScored * POINTS_AWARDED_FOR_GOAL)
                                              + (this.assistsMade * POINTS_AWARDED_FOR_ASSIST);
        if (this.cleanSheet) {
            this.totalPoints += POINTS_AWARDED_FOR_CLEAN_SHEET;
        } else {
            return this.totalPoints;
        }
        return this.totalPoints;
    }

    // REQUIRES: integer > 0
    // MODIFIES: this
    //EFFECTS: adds a # of goals scored to a total # of goals scored
    void scoreGoal(int goals) {
        this.goalsScored += goals;
    }

    // REQUIRES: integer > 0
    // MODIFIES: this
    //EFFECTS: adds a # of assists made to a total # of assist made
    void makeAssist(int assists) {
        this.assistsMade += assists;
    }

    // REQUIRES: cleanSheet != null
    // MODIFIES: this
    // EFFECTS: sets whether a player achieved a clean sheet
    void setCleanSheet(boolean cleanSheet) {
        this.cleanSheet = cleanSheet;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getGoalsScored() {
        return this.goalsScored;
    }

    public int getAssistsMade() {
        return this.assistsMade;
    }

    public boolean getCleanSheet() {
        return this.cleanSheet;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    // EFFECTS: returns a string representation of a player and their statistics
    // based on toString() method in TellerApp from GitHub
    public String toString() {
        return "Name: " + this.playerName + "  Goals: " + this.goalsScored + "  Assists: " + this.assistsMade
                + "  Clean sheet?: " + cleanSheet;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", playerName);
        return json;
    }
}
