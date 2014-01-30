package com.fr3gu.letsmod.entity;

import com.fr3gu.letsmod.LetsMod;

import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * Lets Mod-Mod
 * 
 * ModEntities
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ModEntities {
	
	public static void init() {
		EntityRegistry.registerModEntity(EntitySpaceship.class, "EntitySpaceship", 0, LetsMod.instance, 80, 3, true);
	}

}
