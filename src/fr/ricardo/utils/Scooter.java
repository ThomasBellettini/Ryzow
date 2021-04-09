package fr.ricardo.utils;

public class Scooter {

    private String model;
    private int id;
    private int km;
    private boolean isAvailable;

    public Scooter(String model, int id, int km, boolean isAvailable) {
        this.model = model;
        this.id = id;
        this.km = km;
        this.isAvailable = isAvailable;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
