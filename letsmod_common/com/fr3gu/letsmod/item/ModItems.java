package com.fr3gu.letsmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.fr3gu.letsmod.lib.ItemIds;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Lets Mod-Mod
 * 
 * ModItems
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ModItems {
	public static Item wand;
	public static Item card;
	
	
	public static void init() {
		wand = new ItemWand(ItemIds.WAND_ID);
		card = new ItemCard(ItemIds.CARD_ID);
		
		initItemRecipes();
	}
	
	public static void initItemRecipes() {
		GameRegistry.addRecipe(new ItemStack(wand),
				new Object[] { "  c"," s ","s  ", Character.valueOf('c'), Item.goldenCarrot, Character.valueOf('s'), Item.stick});
	}

}
