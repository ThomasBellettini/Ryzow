package fr.ricardo;

import fr.ricardo.utils.Scooter;
import fr.ricardo.utils.ScooterList;
import fr.ricardo.utils.storage.ScooterStorage;

import java.text.ParseException;
import java.util.Scanner;

public class ProgramExec {

    public static ProgramExec getInstance;
    public static ScooterStorage getStorage;
    public static ScooterList scooterList;

    public boolean waitCommand()
    {
        try ( Scanner scanner = new Scanner( System.in ) ) {
            String command = scanner.nextLine();
            if (command.contains(" ")) {
                String[] arg = command.split(" ");
                if (arg[0].equalsIgnoreCase("add")) {
                    if (arg.length == 5) {
                        try {
                            Scooter tmp = new Scooter(arg[1], Integer.parseInt(arg[2]), Integer.parseInt(arg[3]), Boolean.parseBoolean(arg[4]));
                            scooterList.addScooter(tmp);
                        } catch (Exception e) {
                            System.out.println("Error, Command: add <Model> <ID> <KM> <Located>");
                        }
                    } else {
                        System.out.println("Error, Command: add <Model> <ID> <KM> <Located>");
                    }
                }
            } else if (command.equalsIgnoreCase("finish"))
                return true;
        }
        return false;
    }

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
        waitCommand();
        getStorage.write(scooterList);
    }
}
