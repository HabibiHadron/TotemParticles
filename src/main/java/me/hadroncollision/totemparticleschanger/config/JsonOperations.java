package me.hadroncollision.totemparticleschanger.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import me.hadroncollision.totemparticleschanger.TotemParticlesChangerClient;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonOperations
{
    public static Config config;
    private final static Path configPath = FabricLoader.getInstance().getConfigDir().resolve("totem-particle-colors.json");
    private final static Gson gson = new GsonBuilder().registerTypeAdapter(Config.class, new ConfigTypeAdapter()).setPrettyPrinting().create();

    public static Config loadConfigFromFile() {
        if (Files.notExists(configPath)) writeConfig();

        try (JsonReader reader = new JsonReader(Files.newBufferedReader(configPath))) {
            config = gson.fromJson(reader, Config.class);

        } catch (Exception e) {
            TotemParticlesChangerClient.LOGGER.info("Error while loading config, maybe you should check the mod's config file to see if it has any syntax errors.");
            e.printStackTrace();
            throw new RuntimeException("(Totem Particles Color Changer) Error while loading config, maybe you should check the mod's config file to see if it has any syntax errors.");
        }

        return config;
    }

    public static void writeConfig() {

        try {
            Files.deleteIfExists(configPath);
            Files.write(configPath, gson.toJson(new Config()).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            TotemParticlesChangerClient.LOGGER.info("Error while writing config"); //TODO ask users to report on gh or discord
            e.printStackTrace();
        }
        
    }
}
