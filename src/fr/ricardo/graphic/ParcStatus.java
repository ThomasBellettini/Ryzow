package fr.ricardo.graphic;

import fr.ricardo.ProgramExec;
import fr.ricardo.utils.Scooter;
import fr.ricardo.utils.ScooterList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class ParcStatus extends JPanel {

    JTextField textField = new JTextField(15);
    JFrame frame = ProgramExec.getFrame;
    JPanel panel = this;
    JLabel jLabel = new JLabel();

    private JLabel make_font(Scooter scooter, int i)
    {
        String ss = "ID: " + scooter.getId() + " | Modèle: " + scooter.getModel() + " | KM: " + scooter.getKm() + " | Etat: " + (scooter.isAvailable() ? "Disponible" : "Indisponible");
        JLabel tmp = new JLabel();
        Font font = new Font("Courier", Font.ITALIC, 20);
        tmp.setFont(font);
        tmp.setForeground(Color.orange);
        tmp.setBounds(1, i * 20, 800, 100);
        tmp.setHorizontalAlignment(SwingConstants.LEFT);
        tmp.setText(ss);
        return tmp;
    }

    public ParcStatus() {
        setLayout(null);

        JButton quit_button = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new MainMenu());
                frame.repaint();
                frame.revalidate();
            }
        });

        setBackground(Color.BLACK);

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


        int l = ProgramExec.scooterList.scooterList.size();
        if (l > 35) l = 35;
        ArrayList<JLabel> arrayList = new ArrayList<JLabel>();

        for (int i = 0; i < l; i++)
        {
            arrayList.add(make_font(ProgramExec.scooterList.getScooterList().get(i), i));
            this.add(arrayList.get(i));
        }

        this.add(textField);
        this.add(quit_button);
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }
}
