package fr.ricardo.graphic;

import fr.ricardo.ProgramExec;
import sun.awt.windows.WPrinterJob;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JPanel {

    public int is_hover = 0;

    private void draw_string(String string, Graphics g, int x, int y)
    {
        Font font = new Font("Courier", Font.BOLD, 40);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString(string, x, y);
    }

    public void paintComponent(Graphics g){
        JFrame frame = ProgramExec.getFrame;

        Font font = new Font("Courier", Font.ITALIC, 40);

        JButton locate = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new LocateScooter());
                frame.repaint();
                frame.revalidate();
            }
        });
        locate.setBounds(125, 0, 500, 100);
        locate.setText("Location Scooter !");
        locate.setHorizontalAlignment(SwingConstants.CENTER);
        locate.setForeground(Color.RED);
        locate.setFont(font);

        JButton back = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new BackScooter());
                frame.repaint();
                frame.revalidate();
            }
        });
        back.setBounds(125, 150, 500, 100);
        back.setText("Retour Scooter !");
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.setForeground(Color.RED);
        back.setFont(font);

        JButton state = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Status());
                frame.repaint();
                frame.revalidate();
            }
        });
        state.setBounds(125, 300, 500, 100);
        state.setText("Etat d'un Scooter !");
        state.setHorizontalAlignment(SwingConstants.CENTER);
        state.setForeground(Color.RED);
        state.setFont(font);


        JButton saisie = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new ResumeScooter());
                frame.repaint();
                frame.revalidate();
            }
        });
        saisie.setBounds(125, 600, 500, 100);
        saisie.setText("Saisie du Parc !");
        saisie.setHorizontalAlignment(SwingConstants.CENTER);
        saisie.setForeground(Color.RED);
        saisie.setFont(font);

        JButton park = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new ParcStatus());
                frame.repaint();
                frame.revalidate();
            }
        });
        park.setBounds(125, 450, 500, 100);
        park.setText("Etat du Parc !");
        park.setHorizontalAlignment(SwingConstants.CENTER);
        park.setForeground(Color.RED);
        park.setFont(font);

        JButton quit_button = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProgramExec.getStorage.write(ProgramExec.scooterList);
                System.exit(0);
            }
        });
        quit_button.setBounds(125, 730, 500, 100);
        quit_button.setText("Quitter !");
        quit_button.setHorizontalAlignment(SwingConstants.CENTER);
        quit_button.setForeground(Color.GRAY);
        quit_button.setFont(font);

        this.add(quit_button);
        this.add(park);
        this.add(back);
        this.add(locate);
        this.add(saisie);
        this.add(state);

    }
}
