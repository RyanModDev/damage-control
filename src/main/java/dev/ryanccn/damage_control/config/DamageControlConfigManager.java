
package dev.ryanccn.damage_control.config;

import org.quiltmc.config.api.values.TrackedValue;
import org.quiltmc.loader.api.config.QuiltConfig;

import java.util.List;

@SuppressWarnings("unchecked")
public class DamageControlConfigManager {
    public static final DamageControlConfig CONFIG = QuiltConfig.create("damage_control", "config", DamageControlConfig.class);

    public static final TrackedValue<Boolean> IN_FIRE_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("in_fire_damage"));
    public static final TrackedValue<Boolean> LIGHTNING_BOLT_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("lightning_bolt_damage"));
    public static final TrackedValue<Boolean> ON_FIRE_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("on_fire_damage"));
    public static final TrackedValue<Boolean> LAVA_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("lava_damage"));
    public static final TrackedValue<Boolean> HOT_FLOOR_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("hot_floor_damage"));
    public static final TrackedValue<Boolean> IN_WALL_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("in_wall_damage"));
    public static final TrackedValue<Boolean> CRAMMING_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("cramming_damage"));
    public static final TrackedValue<Boolean> DROWN_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("drown_damage"));
    public static final TrackedValue<Boolean> STARVE_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("starve_damage"));
    public static final TrackedValue<Boolean> CACTUS_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("cactus_damage"));
    public static final TrackedValue<Boolean> FALL_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("fall_damage"));
    public static final TrackedValue<Boolean> FLY_INTO_WALL_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("fly_into_wall_damage"));
    public static final TrackedValue<Boolean> MAGIC_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("magic_damage"));
    public static final TrackedValue<Boolean> ANVIL_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("anvil_damage"));
    public static final TrackedValue<Boolean> FALLING_BLOCK_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("falling_block_damage"));
    public static final TrackedValue<Boolean> DRAGON_BREATH_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("dragon_breath_damage"));
    public static final TrackedValue<Boolean> DRYOUT_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("dryout_damage"));
    public static final TrackedValue<Boolean> SWEET_BERRY_BUSH_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("sweet_berry_bush_damage"));
    public static final TrackedValue<Boolean> FREEZE_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("freeze_damage"));
    public static final TrackedValue<Boolean> FALLING_STALACTITE_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("falling_stalactite_damage"));
    public static final TrackedValue<Boolean> STALAGMITE_DAMAGE = (TrackedValue<Boolean>) CONFIG.getValue(List.of("stalagmite_damage"));

    public static final TrackedValue<String> MOBS_NO_DAMAGE = (TrackedValue<String>) CONFIG.getValue(List.of("mobs_no_damage"));
}

