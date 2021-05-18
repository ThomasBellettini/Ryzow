package fr.ricardo;

import fr.ricardo.graphic.MainGraphix;
import fr.ricardo.graphic.MainMenu;
import fr.ricardo.utils.Scooter;
import fr.ricardo.utils.ScooterList;
import fr.ricardo.utils.storage.ScooterStorage;

import java.text.ParseException;
import java.util.Scanner;

public class ProgramExec {

    public static ProgramExec getInstance;
    public static ScooterStorage getStorage;
    public static ScooterList scooterList;
    public static MainGraphix getFrame;

    public ProgramExec()
    {
        boolean close = false;

        getInstance = this;
        getStorage = new ScooterStorage();
        scooterList = new ScooterList();

        getStorage.setupScooter();
        for (Scooter scooter : scooterList.getScooterList()) {
            System.out.println("[Scooter] Model: " + scooter.getModel() + " | ID: " + scooter.getId() + " | KM: " + scooter.getKm() + " | Located: " + (scooter.isAvailable() ? "Disponible" : "Indisponible"));
        }

        getFrame = new MainGraphix();
        getStorage.write(scooterList);
    }
}
