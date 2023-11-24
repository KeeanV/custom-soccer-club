//package ui;
//
//import model.Club;
//import model.Player;
//import model.WorkRoom;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//
//// Represents the Fantasy Soccer game
//public class Game {
//    private static final String JSON_STORE = "./data/workroom.json";
//    private Club club1;
//    private WorkRoom workRoom;
//    private Scanner input;
//    private JsonWriter jsonWriter;
//    private JsonReader jsonReader;
//
//    // EFFECTS: runs the Fantasy Soccer game
//    public Game() {
//        input = new Scanner(System.in);
//        workRoom = new WorkRoom("Keean's workroom");
//        jsonWriter = new JsonWriter(JSON_STORE);
//        jsonReader = new JsonReader(JSON_STORE);
//        runGame();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user input
//    private void runGame() {
//        boolean keepGoing = true;
//        String command = null;
//
//        init();
//
//        while (keepGoing) {
//            displayMenu();
//            command = input.nextLine();
//            command = command.toLowerCase();
//
//            if (command.equals("8")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//
//        System.out.println("\nGoodbye!");
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user command
//    private void processCommand(String command) {
//        if (command.equals("1")) {
//            doAddPlayer();
//        } else if (command.equals("2")) {
//            doRemovePlayer();
//        } else if (command.equals("3")) {
//            doGetListOfPlayers();
//        } else if (command.equals("4")) {
//            doCalculateTotalPoints();
//        } else if (command.equals("5")) {
//            doCalculatePlayerTotal();
//        } else if (command.equals("6")) {
//            doSaveWorkRoom();
//        } else if (command.equals("7")) {
//            doLoadWorkRoom();
//        } else {
//            System.out.println("Selection not valid...");
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: initializes clubs
//    private void init() {
//        club1 = new Club("Vancouver City");
//        input = new Scanner(System.in);
//        input.useDelimiter("\n");
//    }
//
//    // EFFECTS: displays menu of options to user
//    private void displayMenu() {
//        System.out.println("\nSelect from:");
//        System.out.println("\t1 -> Add a player to your club");
//        System.out.println("\t2 -> Remove a player from your club");
//        System.out.println("\t3 -> View the players in your club");
//        System.out.println("\t4 -> Calculate your club's total points");
//        System.out.println("\t5 -> View a player's statistics");
//        System.out.println("\t6 -> Save players to your club");
//        System.out.println("\t7 -> Load players from your club");
//        System.out.println("\t8 -> Quit");
//    }
//
//    // MODIFIES: this
//    // EFFECTS: adds a player to the club
//    private void doAddPlayer() {
//        System.out.print("Enter player name: ");
//        String name = input.nextLine();
//
//        if (name.length() > 0) {
//            Player p1 = new Player(name, (int) (Math.random() * 3), (int) (Math.random() * 3), getRandomBoolean());
//            club1.addPlayer(p1);
//        } else {
//            System.out.println("Please input a player name\n");
//        }
//    }
//
//    //EFFECTS: returns a random boolean value for a clean sheet
//    private boolean getRandomBoolean() {
//        if (Math.random() > 0.5) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: removes a player from a club
//    private void doRemovePlayer() {
//        System.out.print("Enter player name to remove: ");
//        String remove = input.nextLine();
//
//        for (Player player : club1.getPlayers()) {
//            if (player.getPlayerName().equals(remove)) {
//                club1.removePlayer(player);
//                System.out.println(player.getPlayerName() + " was removed from your club.");
//            } else {
//                System.out.println("Player is not in your club\n");
//            }
//        }
//    }
//
//    // EFFECTS: returns the list of players in the club
//    private void doGetListOfPlayers() {
//        if (club1.getPlayers().size() > 0) {
//            System.out.println("The following players are in your club: ");
//            for (Player player : club1.getPlayers()) {
//                System.out.println(player.getPlayerName());
//            }
//        } else {
//            System.out.println("There are no players in your club");
//        }
//    }
//
//    // EFFECTS: calculates the total points for the club and displays that value
//    private void doCalculateTotalPoints() {
//        int totalPoints = club1.calculateTotalPoints();
//        if (club1.getPlayers().size() == 0) {
//            System.out.println("Add players to get your club's total points");
//        }
//        String message = "Total points for " + club1.getClubName() + ": " + totalPoints;
//        System.out.println(message);
//    }
//
//    // EFFECTS: calculates the total points for a player and displays that value
//    private void doCalculatePlayerTotal() {
//        int playerTotalPoints = 0;
//        String message;
//        System.out.println("Enter player name to get their total points: ");
//        String name = input.nextLine();
//        for (Player player : club1.getPlayers()) {
//            if (player.getPlayerName().equals(name)) {
//                playerTotalPoints = player.calculateTotalPoints();
//            }
//        }
//        message = "Total points for " + name + ": " + playerTotalPoints;
//        System.out.println(message);
//    }
//
//    // EFFECTS: saves the workroom to file
//    private void doSaveWorkRoom() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(club1);
//            jsonWriter.close();
//            System.out.println("Saved " + workRoom.getName() + " to " + JSON_STORE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE);
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads workroom from file
//    private void doLoadWorkRoom() {
//        try {
//            club1 = jsonReader.read();
//            System.out.println("Loaded " + workRoom.getName() + " from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//    }
//}
