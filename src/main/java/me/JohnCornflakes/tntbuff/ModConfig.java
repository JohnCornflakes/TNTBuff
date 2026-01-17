package me.JohnCornflakes.tntbuff;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModConfig {
    public float TNTMultiplier = 2.5F;
    public float TNTMinecartMultiplier = 2.5F;


    public static ModConfig load() {
        Path path = FabricLoader.getInstance().getConfigDir().resolve("TNTBuff.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            if (Files.notExists(path)) {
                ModConfig cfg = new ModConfig();
                Files.writeString(path, gson.toJson(cfg));
                return cfg;
            }
            return gson.fromJson(Files.readString(path), ModConfig.class);
        } catch (IOException e) {
            return new ModConfig();
        }
    }


}
