package com.song.nuclear_craft.items.Ammo9mm;

import com.song.nuclear_craft.NuclearCraft;
import com.song.nuclear_craft.items.AbstractAmmo;

import javax.annotation.Nonnull;

public class Ammo9mmTungsten extends AbstractAmmo {

    public Ammo9mmTungsten() {
        super(new Properties().group(NuclearCraft.ITEM_GROUP));
    }
    @Override
    public String getSize() {
        return "9mm";
    }

    @Nonnull
    @Override
    public String getType() {
        return "tungsten";
    }

    @Override
    public double getBaseDamage() {
        return 50;
    }
}