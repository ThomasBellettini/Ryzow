package fr.ricardo.graphic;

import fr.ricardo.ProgramExec;
import fr.ricardo.utils.Scooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ResumeScooter extends JPanel {

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

    private JLabel make_font(String s, int i)
    {
        JLabel tmp = new JLabel();
        Font font = new Font("Courier", Font.ITALIC, 20);
        tmp.setFont(font);
        tmp.setForeground(Color.orange);
        tmp.setBounds(1, i * 20, 800, 100);
        tmp.setHorizontalAlignment(SwingConstants.LEFT);
        tmp.setText(s);
        return tmp;
    }

    public ResumeScooter() {
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

        this.add(make_font("Nombre de Scooter: " + ProgramExec.scooterList.scooterList.size(), 0));

        int k = 0;
        int w = 0;
        int l = 0;
        ArrayList<JLabel> arrayList = new ArrayList<JLabel>();

        for (int i = 0; i < ProgramExec.scooterList.scooterList.size(); i++)
        {
            if (ProgramExec.scooterList.scooterList.get(i).isAvailable()) {
                k++;
            } else {
                w++;
            }
        }

        this.add(make_font("ID Des Scooters Disponible (" + k + "): ", 2));
        String str = "";

        if (k >= 24) k = 24;
        for (int i = 0, m = 0; m < k; i++) {
            if (ProgramExec.scooterList.scooterList.get(i).isAvailable()) {
                if (m == 0)
                    str += ProgramExec.scooterList.scooterList.get(i).getId() + "";
                else
                    str += ", " + ProgramExec.scooterList.scooterList.get(i).getId();
                m++;
            }
        }
        this.add(make_font("-> " + str + " " + (k == 24 ? "..." : ""), 3));

        this.add(make_font("ID Des Scooters Indisponible (" + w + "): ", 5));
        String strs = "";

        if (w >= 24) w = 24;
        for (int i = 0, m = 0; m < w; i++) {
            if (!ProgramExec.scooterList.scooterList.get(i).isAvailable()) {
                if (m == 0)
                    strs += ProgramExec.scooterList.scooterList.get(i).getId() + "";
                else
                    strs += ", " + ProgramExec.scooterList.scooterList.get(i).getId();
                m++;
            }
        }
        this.add(make_font("-> " + strs + " " + (w == 24 ? "..." : ""), 6));

        int km = 0;
        for (int i = 0; i < ProgramExec.scooterList.scooterList.size(); i++)
            km += ProgramExec.scooterList.scooterList.get(i).getKm();
        double d = (float) km / ProgramExec.scooterList.scooterList.size();
        this.add(make_font("Kilométrage Moyen: " + d + " Km", 8));

        this.add(quit_button);
    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
    }
}
