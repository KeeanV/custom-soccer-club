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

            //doGetListOfPlayers();

        }
        if ((e.getSource()) == button2) {
            //
        }
        if ((e.getSource()) == button3) {
            //
        }
        if ((e.getSource()) == button4) {
            //
        }
    }

    private static void doGetListOfPlayers() {
        if (club1.getPlayers().size() > 0) {
            System.out.println("The following players are in your club: ");
            //notes: use a new jpanel for each button, use text fields which have a get() method.

            for (Player player : club1.getPlayers()) {
                System.out.println(player.getPlayerName());
            }
        } else {
            System.out.println("There are no players in your club");
        }
    }
}
