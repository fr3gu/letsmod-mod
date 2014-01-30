package com.fr3gu.letsmod.core.proxy;

import com.fr3gu.letsmod.client.RenderSpaceship;
import com.fr3gu.letsmod.entity.EntitySpaceship;

import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Lets Mod-Mod
 * 
 * ClientProxy
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ClientProxy extends CommonProxy {
	@Override
	public void initSounds() {
		// init all the sounds
		
	}
	
	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
	}
}
