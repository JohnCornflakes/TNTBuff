package me.JohnCornflakes.tntbuff.mixin;


import me.JohnCornflakes.tntbuff.Tntbuff;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Ownable;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(TntEntity.class)
abstract class TNTMixin extends Entity implements Ownable {

    @Shadow private boolean teleported;
    @Shadow @Final private static ExplosionBehavior TELEPORTED_EXPLOSION_BEHAVIOR;


    public TNTMixin(EntityType<?> type, World world) {
        super(type, world);
    }


    @Overwrite
    private void explode() {
        Tntbuff.LOGGER.info("Hello world");
//        float f = 4.0F;
        float pow = 4.0F;
        pow *= Tntbuff.CONFIG.TNTMultiplier;
//        this.getWorld().createExplosion(this, Explosion.createDamageSource(this.getWorld(), this), this.teleported ? TELEPORTED_EXPLOSION_BEHAVIOR : null, this.getX(), this.getBodyY((double)0.0625F), this.getZ(), pow, false, World.ExplosionSourceType.TNT);
        this.getWorld().createExplosion(this, Explosion.createDamageSource(this.getWorld(), this), this.teleported ? TELEPORTED_EXPLOSION_BEHAVIOR : null, this.getX(), this.getBodyY((double)0.0625F), this.getZ(), pow, false, World.ExplosionSourceType.TNT);
    }

}
