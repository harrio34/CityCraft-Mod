package com.harrio34.citycraft1.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.harrio34.citycraft1.lib.BlockIds;
import com.harrio34.citycraft1.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	//Register block names for ease of use
    public static Block cementfoundation;

    public static void init() 
    {
    	//Block Names
        cementfoundation = new BlockCementFoundation(BlockIds.CEMENTFOUNDATION);
        //Block Registry
        GameRegistry.registerBlock(cementfoundation, Strings.CEMENTFOUNDATION_NAME);
        initBlockRecipes();
    }
    //Crafting Recipies
    private static void initBlockRecipes() 
    {
        GameRegistry.addRecipe(new ItemStack(cementfoundation), new Object[]{ "iii", "ioi", "iii", Character.valueOf('i'), Block.stone, Character.valueOf('o'), Block.brick});
    }
}
