
package dev.ryanccn.damage_control.config;

import org.quiltmc.config.api.WrappedConfig;
import org.quiltmc.config.api.annotations.Comment;

@SuppressWarnings("unused")
public class DamageControlConfig extends WrappedConfig {
    @Comment("Toggle damage from in fire")
    public final boolean in_fire_damage = true;

    @Comment("Toggle damage from lightning bolt")
    public final boolean lightning_bolt_damage = true;

    @Comment("Toggle damage from on fire")
    public final boolean on_fire_damage = true;

    @Comment("Toggle damage from lava")
    public final boolean lava_damage = true;

    @Comment("Toggle damage from hot floor")
    public final boolean hot_floor_damage = true;

    @Comment("Toggle damage from in wall")
    public final boolean in_wall_damage = true;

    @Comment("Toggle damage from cramming")
    public final boolean cramming_damage = true;

    @Comment("Toggle damage from drown")
    public final boolean drown_damage = true;

    @Comment("Toggle damage from starve")
    public final boolean starve_damage = true;

    @Comment("Toggle damage from cactus")
    public final boolean cactus_damage = true;

    @Comment("Toggle damage from fall")
    public final boolean fall_damage = true;

    @Comment("Toggle damage from fly into wall")
    public final boolean fly_into_wall_damage = true;

    @Comment("Toggle damage from magic")
    public final boolean magic_damage = true;

    @Comment("Toggle damage from anvil")
    public final boolean anvil_damage = true;

    @Comment("Toggle damage from falling block")
    public final boolean falling_block_damage = true;

    @Comment("Toggle damage from dragon breath")
    public final boolean dragon_breath_damage = true;

    @Comment("Toggle damage from dryout")
    public final boolean dryout_damage = true;

    @Comment("Toggle damage from sweet berry bush")
    public final boolean sweet_berry_bush_damage = true;

    @Comment("Toggle damage from freeze")
    public final boolean freeze_damage = true;

    @Comment("Toggle damage from falling stalactite")
    public final boolean falling_stalactite_damage = true;

    @Comment("Toggle damage from stalagmite")
    public final boolean stalagmite_damage = true;

    @Comment("Mobs to disable damage")
    public final String mobs_no_damage = "";
}
