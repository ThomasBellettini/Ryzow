package fr.ricardo.utils.storage.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.ricardo.utils.Scooter;
import fr.ricardo.utils.ScooterList;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScooterStorageAdapter extends TypeAdapter<ScooterList> {

    private static Type seriTypes = new TypeToken<List<Scooter>>() {}.getType();


    @Override
    public void write(JsonWriter writer, ScooterList scooter) throws IOException {
        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        writer.beginObject();
        writer.name("scooterList").value(gson.toJson(scooter.scooterList));
        writer.endObject();
    }

    @Override
    public ScooterList read(JsonReader reader) throws IOException {
        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        reader.beginObject();
        List<Scooter> scooterList = new ArrayList<>();
        while (reader.hasNext()) {
            String read = reader.nextName();
            switch (read) {
                case "scooterList":
                    scooterList = gson.fromJson(reader.nextString(), seriTypes);
                    break;
            }
        }
        reader.endObject();
        return new ScooterList(scooterList);
    }
}
