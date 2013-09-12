package com.harrio34.citycraft1.creativetab;

import com.harrio34.citycraft1.lib.ItemIds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabCityCraft1 extends CreativeTabs
{

    public CreativeTabCityCraft1(int tabID, String tabLabel) 
    {
        super(tabID, tabLabel);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() 
    {
        return ItemIds.MINIUM_SHARD;
    }
}