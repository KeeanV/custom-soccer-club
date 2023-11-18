package ui;

import model.Club;
import model.Player;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
        JFrame frame = new JFrame("Soccer Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel(" ");
        emptyLabel.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);


        JPanel panel = new JPanel();


        panel.add(button1);
        button1.setVisible(true);
        button1.addActionListener(this);

        panel.add(button2);
        button2.setVisible(true);
        button2.addActionListener(this);

        panel.add(button3);
        button3.setVisible(true);
        button3.addActionListener(this);

        panel.add(button4);
        button4.setVisible(true);
        button4.addActionListener(this);

        frame.getContentPane().add(panel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource()) == button1) {
            doGetListOfPlayers();
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
            for (Player player : club1.getPlayers()) {
                System.out.println(player.getPlayerName());
            }
        } else {
            System.out.println("There are no players in your club");
        }
    }
}
