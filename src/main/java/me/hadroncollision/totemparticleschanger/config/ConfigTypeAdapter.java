package me.hadroncollision.totemparticleschanger.config;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class ConfigTypeAdapter extends TypeAdapter<Config> {

    @Override
    public Config read(JsonReader in) throws IOException {
        Config config = new Config();
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "doubleColor":
                    config.doubleColor = in.nextBoolean();
                    break;
                case "red1":
                    config.red1 = in.nextInt();
                    break;
                case "green1":
                    config.green1 = in.nextInt();
                    break;
                case "blue1":
                    config.blue1 = in.nextInt();
                    break;
                case "red2":
                    config.red2 = in.nextInt();
                    break;
                case "green2":
                    config.green2 = in.nextInt();
                    break;
                case "blue2":
                    config.blue2 = in.nextInt();
                    break;
            }
          }
          in.endObject();
          return config;
    }

    @Override
    public void write(final JsonWriter out, Config config) throws IOException {
        out.beginObject();
        out.name("doubleColor").value(config.doubleColor);
        out.name("red1").value(config.red1);
        out.name("green1").value(config.green1);
        out.name("blue1").value(config.blue1);
        out.name("red2").value(config.red2);
        out.name("green2").value(config.green2);
        out.name("blue2").value(config.blue2);
        out.endObject();
    }
    
}
