package com.harrio34.citycraft1.lib;

import com.harrio34.citycraft1.lib.Reference;

public class Strings 
{
    /* General keys */
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String TOKEN_DELIMITER = ",";

    /* Localization Prefixes */
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    /* Fingerprint check related constants */
    public static final String NO_FINGERPRINT_MESSAGE = "The copy of Equivalent Exchange 3 that you are running is a development version of the mod, and as such may be unstable and/or incomplete.";
    public static final String INVALID_FINGERPRINT_MESSAGE = "The copy of Equivalent Exchange 3 that you are running has been modified from the original, and unpredictable things may happen. Please consider re-downloading the original version of the mod.";

    /* Version check related constants */
    public static final String VERSION_CHECK_INIT_LOG_MESSAGE = "version.ee3:init_log_message";
    public static final String UNINITIALIZED_MESSAGE = "version.ee3:uninitialized";
    public static final String CURRENT_MESSAGE = "version.ee3:current";
    public static final String OUTDATED_MESSAGE = "version.ee3:outdated";
    public static final String GENERAL_ERROR_MESSAGE = "version.ee3:general_error";
    public static final String FINAL_ERROR_MESSAGE = "version.ee3:final_error";
    public static final String MC_VERSION_NOT_FOUND = "version.ee3:mc_version_not_found";

    /* NBT related constants */
    public static final String NBT_ITEM_CHARGE_LEVEL_KEY = "itemChargeLevel";
    public static final String NBT_ITEM_MODE_KEY = "itemMode";
    public static final String NBT_ITEM_CRAFTING_GUI_OPEN = "itemCraftingGuiOpen";
    public static final String NBT_ITEM_DISPLAY = "display";
    public static final String NBT_ITEM_COLOR = "color";
    public static final String NBT_TE_STATE_KEY = "teState";
    public static final String NBT_TE_CUSTOM_NAME = "CustomName";
    public static final String NBT_TE_DIRECTION_KEY = "teDirection";
    public static final String NBT_ENCODED_RECIPE_OUTPUT = "recipeOutput";
    public static final String NBT_ENCODED_RECIPE_INPUTS = "recipeInputs";
    public static final String NBT_ENCODED_RECIPE_INPUT_PREFIX = "recipeInput_";
    public static final String NBT_ENCODED_ATTR_TYPE = "type";
    public static final String NBT_ENCODED_ATTR_TYPE_ITEM = "ItemStack";
    public static final String NBT_ENCODED_ATTR_TYPE_ORE = "OreStack";
    public static final String NBT_ENCODED_ATTR_TYPE_ENERGY = "EnergyStack";
    public static final String NBT_ENCODED_ATTR_SIZE = "Count";
    public static final String NBT_ENCODED_ATTR_ITEM_ID = "id";
    public static final String NBT_ENCODED_ATTR_ITEM_META = "Damage";
    public static final String NBT_ENCODED_ATTR_ITEM_TAG_COMPOUND = "tag";
    public static final String NBT_ENCODED_ATTR_ORE_NAME = "oreName";
    public static final String NBT_ENCODED_ATTR_ENERGY_NAME = "energyName";

    /* Block name constants */
	public static final String CEMENTFOUNDATION_NAME = "cementFoundation";;

    /* Item name constants */
	public static final String BUILDERS_WAND_NAME = "buildersWand";

    /* TileEntity name constants */
    public static final String TE_CALCINATOR_NAME = "tileCalcinator";
    public static final String TE_ALUDEL_NAME = "tileAludel";
    public static final String TE_ALCHEMICAL_CHEST_NAME = "tileAlchemicalChest";
    public static final String TE_GLASS_BELL_NAME = "tileGlassBell";
    public static final String TE_ALCHEMY_TABLE_NAME = "tileAlchemyTable";
    public static final String TE_RENDERING_TANK_NAME = "tileRenderingTank";

    /* Container related constants */
    /* public static final String CONTAINER_CALCINATOR_NAME = "container.ee3:" + CALCINATOR_NAME; */
}

