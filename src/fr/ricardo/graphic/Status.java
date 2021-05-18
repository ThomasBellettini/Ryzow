package fr.ricardo.graphic;

import fr.ricardo.ProgramExec;
import fr.ricardo.utils.ScooterList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Status extends JPanel {
    Font font = new Font("Courier", Font.ITALIC, 40);

    JTextField textField = new JTextField(15);
    JFrame frame = ProgramExec.getFrame;
    JPanel panel = this;
    JLabel jLabel = new JLabel();

    JLabel model = new JLabel();
    JLabel ids = new JLabel();
    JLabel km = new JLabel();
    JLabel located = new JLabel();

    public boolean is_inside(int y, int mouse_y) {
        if (mouse_y >= y && mouse_y <= y + 100) {
            return true;
        }
        return false;
    }

    private JLabel make_font(String string, int x, int y)
    {
        JLabel tmp = new JLabel();
        tmp.setFont(font);
        tmp.setForeground(Color.orange);
        tmp.setBounds(x, y, 800, 100);
        tmp.setHorizontalAlignment(SwingConstants.LEFT);
        tmp.setText(string);
        return tmp;
    }

    public Status() {
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
                } else {
                    jLabel.setText("");
                    model.setText("Modèle: " + list.getScooterByID(id).getModel());
                    ids.setText("ID: " + list.getScooterByID(id).getId());
                    km.setText("Km: " + list.getScooterByID(id).getKm());
                    located.setText(list.getScooterByID(id).isAvailable() ? "Etat: Disponible" : "Etat: Indisponible");

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

        jLabel = make_font("", 1, 200);
        model = make_font("", 50, 240);
        ids = make_font("", 50, 280);
        km = make_font("", 50, 320);
        located = make_font("", 50, 360);

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

        jButton.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(jButton);
        this.add(jLabel);
        this.add(model);
        this.add(ids);
        this.add(km);
        this.add(located);

        this.add(textField);
        this.add(quit_button);
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }
}
