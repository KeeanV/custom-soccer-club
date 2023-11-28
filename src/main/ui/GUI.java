package ui;

import model.Club;
import model.Player;
import model.WorkRoom;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.util.List;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Represents the graphical user interface
public class GUI extends JFrame implements ActionListener {
    private static final String JSON_STORE = "./data/workroom.json";
    private WorkRoom workRoom;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static Club club1;
    private List<Player> myList;
    JButton button1 = new JButton("View the list of players in your club");
    JButton button2 = new JButton("Add a player to your club");
    JButton button3 = new JButton("Save your club");
    JButton button4 = new JButton("Load your club");
    JButton button5 = new JButton("Sort your players by total points");

    // EFFECTS: creates the gui and a Club object when the app is run
    public GUI() {
        createGUI();
        club1 = new Club("Vancouver City");
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        myList = new ArrayList<>();
    }

    // CITATION: GUI frame and panel setup based on code shown in: https://www.youtube.com/watch?v=dvzAuq-YDpM
    // EFFECTS: adds panels to JFrame and shows menu with buttons
    public void createGUI() {
        JLabel label = new JLabel();
        label.setText("HELLO");
        ImageIcon icon = new ImageIcon("./data/image/ball.png");
        label.setIcon(icon);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.cyan);
        panel1.setBounds(0, 0, 250, 800);
        createButton1(panel1, button1);
        panel1.add(button2);
        button2.setVisible(true);
        button2.addActionListener(this);
        panel1.add(button3);
        button3.setVisible(true);
        button3.addActionListener(this);
        panel1.add(button4);
        button4.setVisible(true);
        button4.addActionListener(this);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setBounds(250, 0, 550, 800);
        panel2.setLayout(new BorderLayout());

        createJFrame(label, panel1, panel2);
    }

    // REQUIRES: a label and two panel objects
    // EFFECTS: creates a JFrame and adds labels and panels
    private static void createJFrame(JLabel label, JPanel panel1, JPanel panel2) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(800, 800);
        frame.setVisible(true);
        panel2.add(label);
        frame.add(panel1);
        frame.add(panel2);
    }

    // REQUIRES: panel and button objects
    // EFFECTS: adds panel and button objects to the JFrame
    private void createButton1(JPanel panel1, JButton button1) {
        panel1.add(button1);
        button1.setVisible(true);
        button1.addActionListener(this);
    }

    // EFFECTS: assigns actions to different buttons when clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource()) == button1) {
            button1();
        }
        if ((e.getSource()) == button2) {
            button2();
        }
        if ((e.getSource()) == button3) {
            try {
                jsonWriter.open();
                jsonWriter.write(club1);
                jsonWriter.close();
            } catch (FileNotFoundException exception) {
                //
            }
        }
        if ((e.getSource()) == button4) {
            try {
                club1 = jsonReader.read();
                updatePlayers();
            } catch (IOException exception) {
                //
            }
        }
    }

    // EFFECTS: creates a new JFrame that lists players in the club
    public static void button1() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(800, 800);
        frame.setVisible(true);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.cyan);
        panel1.setBounds(0, 0, 800, 800);
        frame.add(panel1);
        JLabel label = new JLabel();
        label.setText("Players in your club:");
        panel1.add(label);
        panel1.add(doGetListOfPlayers());
    }

    // EFFECTS: creates a new JFrame that prompts user input and stores that value in a string
    public static void button2() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(800, 800);
        frame.setVisible(true);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.cyan);
        panel1.setBounds(0, 0, 800, 800);
        frame.add(panel1);
        String response;
        response = JOptionPane.showInputDialog("Enter player name: ");
        JLabel label = new JLabel();
        label.setText(response + "was added to your club");
        panel1.add(label);
        Player p1 = new Player(response, (int) (Math.random() * 3), (int) (Math.random() * 3), getRandomBoolean());
        club1.addPlayer(p1);
    }

    // EFFECTS: returns a string of the list of players currently added to the club
    private static JLabel doGetListOfPlayers() {
        JLabel label = new JLabel();
        String names = "";
        for (Player player : club1.getPlayers()) {
            names += player.getPlayerName() + "   ";
        }
        label.setText(names);
        return label;
    }

    // EFFECTS: loads the list of players that was saved in the club
    private void updatePlayers() {
        myList.clear();
        for (Player p : club1.getPlayers()) {
            myList.add(p);
        }
    }

    //EFFECTS: helper method to return a random boolean value for a clean sheet
    private static boolean getRandomBoolean() {
        if (Math.random() > 0.5) {
            return true;
        } else {
            return false;
        }
    }
}
