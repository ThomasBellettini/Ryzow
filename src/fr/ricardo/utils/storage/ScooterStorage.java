package fr.ricardo.utils.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.ricardo.ProgramExec;
import fr.ricardo.utils.ScooterList;
import fr.ricardo.utils.storage.adapter.ScooterStorageAdapter;

import java.io.*;
import java.util.Objects;

public class ScooterStorage {

    public static File storageFile;
    private Gson gson;

    public ScooterStorage() {
        gson = new GsonBuilder()
            .registerTypeAdapter(ScooterStorage.class, new ScooterStorageAdapter())
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .serializeNulls().create();
        storageFile = new File(System.getProperty("user.home") + "/Scooter/");
        if (!storageFile.exists()) storageFile.mkdir();
    }

    public void setupScooter()
    {
        for (File f : Objects.requireNonNull(storageFile.listFiles())) {
            if (f.getName().endsWith(".json")) {
                ScooterList scooterList = deserialize(f);
                if (scooterList == null)
                    continue;
                ProgramExec.scooterList = scooterList;
            }
        }
    }

    public String read(File f)
    {
        if(f.exists()) {
            try {
                final BufferedReader r = new BufferedReader(new FileReader(f));
                final StringBuilder t = new StringBuilder();
                String l;
                while((l = r.readLine()) != null)
                    t.append(l);
                r.close();
                return t.toString();
            }
            catch (IOException e) {}
        }
        return " ";
    }

    public ScooterList deserialize(File file)
    {
        return gson.fromJson(read(file), ScooterList.class);
    }

    public String serialize(ScooterList scooterList)
    {
        return gson.toJson(scooterList);
    }

    public void write(ScooterList scooterList)
    {
        final FileWriter fileWriter;
        File file = new File(storageFile, "scooter.json");
        try {
            if (!file.exists()) file.createNewFile();
            fileWriter = new FileWriter(file);
            fileWriter.write(serialize(scooterList));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
