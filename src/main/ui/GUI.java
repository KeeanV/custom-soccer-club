package ui;

import model.Club;
import model.Player;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
    private static Club club1;
    JButton button = new JButton("View the list of players in your club");

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


        panel.add(button);
        button.setVisible(true);

        button.addActionListener(this);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                doGetListOfPlayers();
//            }
//        });

        JButton button2 = new JButton("Save your club");
        panel.add(button2);
        button2.setVisible(true);

        JButton button3 = new JButton("Add players");
        panel.add(button3);
        button3.setVisible(true);

        JButton button4 = new JButton("View players");
        panel.add(button4);
        button4.setVisible(true);


        frame.getContentPane().add(panel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource()) == button) {
            doGetListOfPlayers();
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
