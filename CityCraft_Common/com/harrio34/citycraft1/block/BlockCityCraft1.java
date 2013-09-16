package com.harrio34.citycraft1.block;

import com.harrio34.citycraft1.lib.Reference;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCityCraft1 extends BlockContainer
{
	 public BlockCityCraft1(int id, Material material) {

	        super(id, material);
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister iconRegister) {

	        blockIcon = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	    }

	    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {

	        return unlocalizedName.substring(unlocalizedName.indexOf(":") + 1);
	    }

	    /**
	     * Sets the direction of the block when placed
	     */
	    @Override
	    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) 
	    {

	        int direction = 0;
	        int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

	        if (facing == 0) 
	        {
	            direction = ForgeDirection.NORTH.ordinal();
	        }
	        else if (facing == 1) 
	        {
	            direction = ForgeDirection.EAST.ordinal();
	        }
	        else if (facing == 2) 
	        {
	            direction = ForgeDirection.SOUTH.ordinal();
	        }
	        else if (facing == 3) 
	        {
	            direction = ForgeDirection.WEST.ordinal();
	        }

	        world.setBlockMetadataWithNotify(x, y, z, direction, 3);
	    }

		@Override
		public TileEntity createNewTileEntity(World world) {
			// TODO Auto-generated method stub
			return null;
		}
}
