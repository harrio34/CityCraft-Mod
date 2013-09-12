package com.harrio34.citycraft1.command;

import com.harrio34.citycraft1.command.CommandCityCraft;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandHandler 
{


	public static void initCommands(FMLServerStartingEvent event) 
	{
        event.registerServerCommand(new CommandCityCraft());
		
	}
}
