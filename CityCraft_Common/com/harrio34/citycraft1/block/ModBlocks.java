package com.harrio34.citycraft1.block;

import com.harrio34.citycraft1.lib.Strings;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	/* Mod block instances */
    public static Block newblock;

    public static void init() {

    	//Block Names
        NewBlock = new BlockNewBlock(BlockIds.NewBlock);
        //Block Registry
        GameRegistry.registerBlock(NewBlock, Strings.NEWBLOCK_NAME);

        initBlockRecipes();
    }
    //Crafting Recipies
    private static void initBlockRecipes() 
    {
        GameRegistry.addRecipe(new ItemStack(NewBlock), new Object[] { "iii", "i i", "i i", Character.valueOf('i'), Block.glass });
    }
}
