package me.JohnCornflakes.tntbuff.mixin;


import me.JohnCornflakes.tntbuff.ModConfig;
import me.JohnCornflakes.tntbuff.Tntbuff;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Ownable;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.TntMinecartEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(TntMinecartEntity.class)
abstract class TNTMinecartMixin extends AbstractMinecartEntity {

//    @Shadow private boolean teleported;
//    @Shadow @Final private static ExplosionBehavior TELEPORTED_EXPLOSION_BEHAVIOR;


    public TNTMinecartMixin(EntityType<?> type, World world) {
        super(type, world);
    }


//    @Overwrite
//    public void explode(double power) {
//        power *= (double) 2.5f;
//        this.explode(null, power);
//    }

    @Overwrite
    public void explode(@Nullable DamageSource damageSource, double power) {
        if (!this.getWorld().isClient) {
            double d = Math.sqrt(power);
            if (d > (double)5.0F) {
                d = (double)5.0F;
            }

            double pow = (double) 4.0F;
            pow *= (double) Tntbuff.CONFIG.TNTMinecartMultiplier;



            this.getWorld().createExplosion(this, damageSource, (ExplosionBehavior)null, this.getX(), this.getY(), this.getZ(), (float)(pow + this.random.nextDouble() * (double)1.5F * d), false, World.ExplosionSourceType.TNT);
//            this.getWorld().createExplosion(this, damageSource, (ExplosionBehavior)null, this.getX(), this.getY(), this.getZ(), (20.0F), false, World.ExplosionSourceType.TNT);
            this.discard();
        }

    }






}
