package com.song.nuclear_craft.items;

import com.song.nuclear_craft.NuclearCraft;
import com.song.nuclear_craft.items.Ammo.AmmoSize;
import com.song.nuclear_craft.misc.Config;
import com.song.nuclear_craft.misc.SoundEventList;

import javax.annotation.Nonnull;

public class DesertEagle extends AbstractGunItem{

    public DesertEagle() {
        super(new Properties().maxStackSize(1).group(NuclearCraft.ITEM_GROUP));
    }

    @Override
    public int getCoolDown() {
        return 10;
    }

    @Override
    public int maxAmmo() {
        return 7;
    }

    @Override
    public int getLoadTime() {
        return 40;
    }

    @Override
    public String getShootActionString() {
        return "desert_eagle";
    }

    @Override
    public float getSpeedModifier() {
        return Config.DESERT_EAGLE_CONFIG.getSpeedModify().get().floatValue();
    }

    @Override
    public double getDamageModifier() {
        return Config.DESERT_EAGLE_CONFIG.getDamageModify().get();
    }

    @Override
    public String getReloadSound() {
        return "de_reload_empty";
    }

    @Nonnull
    @Override
    public AmmoSize compatibleSize() {
        return AmmoSize.SIZE_9MM;
    }

    @Override
    protected double getGunSoundDist() {
        return 45;
    }
}
