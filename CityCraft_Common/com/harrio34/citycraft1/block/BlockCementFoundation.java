package com.harrio34.citycraft1.block;

import com.harrio34.citycraft1.CityCraft;
import com.harrio34.citycraft1.lib.Reference;
import com.harrio34.citycraft1.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;

public class BlockCementFoundation extends BlockCityCraft1 
{
	public BlockCementFoundation(int ID) {
		super(ID, Material.iron); //The ID and material (The material defines what tools are better on it)
		setTextureFile(Reference.BLOCKTEXTURES); //The texture file
		setBlockName(Strings.CEMENTFOUNDATION_NAME); //The incode name of the block
		setHardness(5.0F); //How hard the block is to break
		setResistance(10.0F); //How well the block resists explosions
		setStepSound(super.soundMetalFootstep); //The sound the block makes when you walk on it as well as place or break it
		setCreativeTab(CityCraft.tabsCC1); //The tab it appears in
		}
	
		@SideOnly(Side.CLIENT)
		public Icon getBlockTextureFromSide(int i)
		{
			//What texture it uses
			return 1;
		}
}
