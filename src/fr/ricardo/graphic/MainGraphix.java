package fr.ricardo.graphic;

import fr.ricardo.ProgramExec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGraphix extends JFrame {

    JFrame frame;
    int scene = 0;

    public MainGraphix() {
        this.frame = this;
        this.setTitle("Scooter");
        this.setSize(800, 860);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new MainMenu());

        this.setVisible(true);
    }
}
