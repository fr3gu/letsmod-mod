package com.fr3gu.letsmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.fr3gu.letsmod.lib.ItemIds;
import com.fr3gu.letsmod.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Lets Mod-Mod
 * 
 * ModItems
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@SuppressWarnings("unused")
public class ModItems {
	public static Item wand;
	public static Item card;
	
	public static void init() {
		wand = new ItemWand(ItemIds.WAND_ID);
		card = new ItemCard(ItemIds.CARD_ID);
		
	}
	
//	public static void addNames() {
//		LanguageRegistry.addName(wand, Strings.WAND_NAME);
//	}
	
	public static void registerRecipes() {
		GameRegistry.addRecipe(new ItemStack(wand),
				new Object[] { "  X"," / ","/  ", Character.valueOf('X'), Item.goldenCarrot,Character.valueOf('/'),Item.stick});
	}

}
