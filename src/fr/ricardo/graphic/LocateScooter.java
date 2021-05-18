package fr.ricardo.graphic;

import fr.ricardo.ProgramExec;
import fr.ricardo.utils.ScooterList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LocateScooter extends JPanel {

    JTextField textField = new JTextField(15);
    JFrame frame = ProgramExec.getFrame;
    JPanel panel = this;
    JLabel jLabel = new JLabel();

    public boolean is_inside(int y, int mouse_y) {
        if (mouse_y >= y && mouse_y <= y + 100) {
            return true;
        }
        return false;
    }

    private void draw_string(String string, Graphics g, int x, int y)
    {
        Font font = new Font("Courier", Font.ITALIC, 40);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString(string, x, y);
    }

    public LocateScooter() {
        setLayout(null);

        JButton jButton = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScooterList list = ProgramExec.scooterList;
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
                } else if (list.getScooterByID(id).isAvailable()) {
                    jLabel.setText("Vous venez de louer un scooter !");
                    list.getScooterByID(id).setAvailable(false);
                    ProgramExec.getStorage.write(ProgramExec.scooterList);
                    panel.repaint();
                } else if (!list.getScooterByID(id).isAvailable()) {
                    jLabel.setText("Le Scooter est déjà louer !");
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

        Font font = new Font("Courier", Font.ITALIC, 40);
        jLabel.setFont(font);
        jLabel.setForeground(Color.orange);
        jLabel.setBounds(1, 220, 800, 100);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        quit_button.setBounds(125, 750, 500, 50);
        quit_button.setText("Retour au menu !");
        quit_button.setHorizontalAlignment(SwingConstants.CENTER);
        quit_button.setForeground(Color.GRAY);
        quit_button.setFont(font);

        jButton.setBounds(125, 600, 500, 80);
        jButton.setText("Louer un Scooter !");
        jButton.setHorizontalAlignment(SwingConstants.CENTER);
        jButton.setForeground(Color.orange);
        jButton.setFont(font);

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
