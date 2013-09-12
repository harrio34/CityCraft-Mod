package com.harrio34.citycraft1.core.item;

import com.harrio34.citycraft1.lib.ItemIds;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems 
{
	 /* Mod item instances */
    public static Item BuildersWand;

    public static void init() 
    {

        /* Initialize each mod item individually */
        BuildersWand = new ItemBuildersWand(ItemIds.BUILDERS_WAND);

        BuildersWand.setContainerItem(BuildersWand);
        // TODO Register items with the GameRegistry
        //Crafting Recipies
        GameRegistry.addRecipe(new ItemStack(BuildersWand), new Object[] { "isi", "i", "sis", Character.valueOf('s'), Block.wood, Character.valueOf('i'), Item.stick });

    }
}
