package fr.ricardo.graphic;

import fr.ricardo.ProgramExec;
import fr.ricardo.utils.Scooter;
import fr.ricardo.utils.ScooterList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BackScooter extends JPanel {

    JTextField textField = new JTextField(15);
    JTextField km = new JTextField(15);
    JFrame frame = ProgramExec.getFrame;
    JPanel panel = this;
    JLabel jLabel = new JLabel();


    public BackScooter() {
        setLayout(null);

        JButton jButton = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScooterList list = ProgramExec.scooterList;

                if (!textField.isEnabled()) {
                    int kms = 0;
                    try {
                        kms = Integer.parseInt(km.getText());
                    } catch (NumberFormatException exception) {
                        jLabel.setText("Vous devez donner un nombre !");
                        panel.repaint();
                        return;
                    }
                    list.getScooterByID(Integer.parseInt(textField.getText())).setKm(list.getScooterByID(Integer.parseInt(textField.getText())).getKm() + kms);
                    list.getScooterByID(Integer.parseInt(textField.getText())).setAvailable(true);
                    textField.setEnabled(true);
                    km.setVisible(false);
                    jLabel.setText("Vous Venez de rendre un scooter ! ");
                    ProgramExec.getStorage.write(ProgramExec.scooterList);
                    repaint();
                    return;
                }
                int id = -1;
                try {
                    id = Integer.parseInt(textField.getText());
                } catch (NumberFormatException exception) {
                    jLabel.setText("Vous devez donner un nombre !");
                    panel.repaint();
                    return;
                }
                if (list.getScooterByID(id) == null) {
                    jLabel.setText("Aucun scooter avec cette ID !");
                    panel.repaint();
                } else if (!list.getScooterByID(id).isAvailable()) {
                    km.setVisible(true);
                    textField.setEnabled(false);
                    panel.repaint();
                } else if (list.getScooterByID(id).isAvailable()) {
                    jLabel.setText("Le Scooter n'est pas en location !");
                    panel.repaint();
                }
            }
        });

        JButton quit_button = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new MainMenu());
                frame.repaint();
                frame.revalidate();
            }
        });


        setBackground(Color.BLACK);

        textField.setLocation(800 / 2 - (350 / 2), 100);
        textField.setSize(350, 50);
        textField.setFont(new Font("Ubuntu", Font.PLAIN, 40));

        km.setLocation(800 / 2 - (350 / 2), 280);
        km.setSize(350, 50);
        km.setFont(new Font("Ubuntu", Font.PLAIN, 40));

        Font font = new Font("Courier", Font.ITALIC, 40);
        jLabel.setFont(font);
        jLabel.setForeground(Color.orange);
        jLabel.setBounds(1, 350, 800, 100);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        quit_button.setBounds(125, 750, 500, 50);
        quit_button.setText("Retour au menu !");
        quit_button.setHorizontalAlignment(SwingConstants.CENTER);
        quit_button.setForeground(Color.GRAY);
        quit_button.setFont(font);

        jButton.setBounds(125, 600, 500, 80);
        jButton.setText("Rendre un Scooter !");
        jButton.setHorizontalAlignment(SwingConstants.CENTER);
        jButton.setForeground(Color.orange);
        jButton.setFont(font);

        km.setVisible(false);
        this.add(km);
        this.add(jButton);
        this.add(jLabel);
        this.add(textField);
        this.add(quit_button);
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }
}