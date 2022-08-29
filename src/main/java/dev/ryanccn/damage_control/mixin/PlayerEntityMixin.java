
package dev.ryanccn.damage_control.mixin;

import dev.ryanccn.damage_control.config.DamageControlConfigManager;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.registry.Registry;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.Calendar;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void beforeDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.MONTH) == 4 && cal.get(Calendar.DAY_OF_MONTH) == 1) {
            // mod doesn't work on april fools, not my problem ¯_(ツ)_/¯
            return;
        }

        if (source.equals(DamageSource.IN_FIRE) && !DamageControlConfigManager.IN_FIRE_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.LIGHTNING_BOLT) && !DamageControlConfigManager.LIGHTNING_BOLT_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.ON_FIRE) && !DamageControlConfigManager.ON_FIRE_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.LAVA) && !DamageControlConfigManager.LAVA_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.HOT_FLOOR) && !DamageControlConfigManager.HOT_FLOOR_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.IN_WALL) && !DamageControlConfigManager.IN_WALL_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.CRAMMING) && !DamageControlConfigManager.CRAMMING_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.DROWN) && !DamageControlConfigManager.DROWN_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.STARVE) && !DamageControlConfigManager.STARVE_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.CACTUS) && !DamageControlConfigManager.CACTUS_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.FALL) && !DamageControlConfigManager.FALL_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.FLY_INTO_WALL) && !DamageControlConfigManager.FLY_INTO_WALL_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.MAGIC) && !DamageControlConfigManager.MAGIC_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.ANVIL) && !DamageControlConfigManager.ANVIL_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.FALLING_BLOCK) && !DamageControlConfigManager.FALLING_BLOCK_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.DRAGON_BREATH) && !DamageControlConfigManager.DRAGON_BREATH_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.DRYOUT) && !DamageControlConfigManager.DRYOUT_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.SWEET_BERRY_BUSH) && !DamageControlConfigManager.SWEET_BERRY_BUSH_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.FREEZE) && !DamageControlConfigManager.FREEZE_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.FALLING_STALACTITE) && !DamageControlConfigManager.FALLING_STALACTITE_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.equals(DamageSource.STALAGMITE) && !DamageControlConfigManager.STALAGMITE_DAMAGE.value()) {
            cir.setReturnValue(false);
            cir.cancel();
        } else if (source.getAttacker() != null) {
            String[] noDamageMobs = DamageControlConfigManager.MOBS_NO_DAMAGE.value().split(",");
            String attackerId = Registry.ENTITY_TYPE.getId(source.getAttacker().getType()).toString();

            if (Arrays.stream(noDamageMobs).anyMatch(attackerId::equals)) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }
}
