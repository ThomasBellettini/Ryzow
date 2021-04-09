package fr.ricardo.utils;

import java.util.ArrayList;
import java.util.List;

public class ScooterList {

    public List<Scooter> scooterList = new ArrayList<>();

    public ScooterList(List<Scooter> scooterList) {
        this.scooterList = scooterList;
    }

    public ScooterList() {}

    public List<Scooter> getScooterList() {
        return scooterList;
    }

    public boolean addScooter(Scooter scooter)
    {
        for (Scooter s : scooterList) {
            if (s.getId() == scooter.getId())
                return false;
        }
        scooterList.add(scooter);
        return true;
    }

    public Scooter getScooterByID(int scooterID)
    {
        for (Scooter s : scooterList) {
            if (s.getId() == scooterID)
                return s;
        }
        return null;
    }
}
