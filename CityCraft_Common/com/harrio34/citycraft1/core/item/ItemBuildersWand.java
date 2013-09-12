package com.harrio34.citycraft1.core.item;

import com.harrio34.citycraft1.CityCraft;
import com.harrio34.citycraft1.lib.Strings;

import net.minecraft.item.Item;

public class ItemBuildersWand extends Item 
{
    public ItemBuildersWand(int id) {

        super(id);
        this.setUnlocalizedName(Strings.RESOURCE_PREFIX + Strings.BUILDERS_WAND_NAME);
        this.setCreativeTab(CityCraft.tabsCC1);
        maxStackSize = 64;
    }
}
