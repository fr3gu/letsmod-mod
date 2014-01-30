package com.fr3gu.letsmod;

import java.io.File;

import com.fr3gu.letsmod.block.ModBlocks;
import com.fr3gu.letsmod.configuration.ConfigurationHandler;
import com.fr3gu.letsmod.core.handlers.LocalizationHandler;
import com.fr3gu.letsmod.core.proxy.CommonProxy;
import com.fr3gu.letsmod.entity.ModEntities;
import com.fr3gu.letsmod.item.ModItems;
import com.fr3gu.letsmod.lib.Reference;
import com.fr3gu.letsmod.network.PacketHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * Lets Mod-Mod
 * 
 * LetsMod
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)
public class LetsMod {
	
	
	@Instance(Reference.MOD_ID)
	public static LetsMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory()
				.getAbsolutePath()
				+ File.separator
				+ Reference.CHANNEL_NAME
				+ File.separator + Reference.MOD_ID + ".cfg"));
		
		ModItems.init();
		
		ModBlocks.init();
		
		ModEntities.init();
		
		proxy.initSounds();
        proxy.initRenderers();
    }
    
	@EventHandler
    public void init(FMLInitializationEvent event) {
        LocalizationHandler.loadLanguages();
    }
    
	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
