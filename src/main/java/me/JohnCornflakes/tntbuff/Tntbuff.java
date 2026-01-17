package me.JohnCornflakes.tntbuff;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tntbuff implements ModInitializer {

    public static final String MOD_ID = "tntbuff";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static ModConfig CONFIG;

    @Override
    public void onInitialize() {
        CONFIG = ModConfig.load();
    }
}
