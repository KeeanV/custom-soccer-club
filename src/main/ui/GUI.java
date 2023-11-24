package ui;

import model.Club;
import model.Player;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {
    private static Club club1;
    JButton button1 = new JButton("View the list of players in your club");
    JButton button2 = new JButton("Save your club");
    JButton button3 = new JButton("Add players");
    JButton button4 = new JButton("View players");


    public GUI() {
        createGUI();
        club1 = new Club("Vancouver City");
    }

    public void createGUI() {

        JLabel label = new JLabel();
        label.setText("HELLO");
        ImageIcon icon = new ImageIcon("ball.png");
        label.setIcon(icon);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        //label.setBounds(100, 100, 75, 75);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.cyan);
        panel1.setBounds(0, 0, 250, 800);
        //panel1.setLayout(new BorderLayout());
        panel1.add(button1);
        button1.setVisible(true);
        button1.addActionListener(this);
        panel1.add(button2);
        button2.setVisible(true);
        button2.addActionListener(this);
        panel1.add(button3);
        button3.setVisible(true);
        button3.addActionListener(this);
        JButton button4 = new JButton("View players");
        panel1.add(button4);
        button4.setVisible(true);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setBounds(250, 0, 550, 800);
        panel2.setLayout(new BorderLayout());



        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(800, 800);
        frame.setVisible(true);
        panel2.add(label);
        frame.add(panel1);
        frame.add(panel2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource()) == button1) {
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
        if ((e.getSource()) == button2) {
            //
        }
        if ((e.getSource()) == button3) {
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
        if ((e.getSource()) == button4) {
            //
        }
    }

    private static JLabel doGetListOfPlayers() {
        JLabel label = new JLabel();
        String names = "";
        for (Player player : club1.getPlayers()) {
            names += player.getPlayerName();
        }
        label.setText(names);
        return label;
    }

    private void doAddPlayer() {
        String name = "";
        if (name.length() > 0) {
            Player p1 = new Player(name, (int) (Math.random() * 3), (int) (Math.random() * 3), getRandomBoolean());
            club1.addPlayer(p1);
        } else {
            System.out.println("Please input a player name\n");
        }
    }

    private boolean getRandomBoolean() {
        if (Math.random() > 0.5) {
            return true;
        } else {
            return false;
        }
    }
}
