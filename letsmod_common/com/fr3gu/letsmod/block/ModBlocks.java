package com.fr3gu.letsmod.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.fr3gu.letsmod.item.ItemMachine;
import com.fr3gu.letsmod.lib.BlockIds;
import com.fr3gu.letsmod.lib.Strings;
import com.fr3gu.letsmod.tileentity.TileBomb;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Lets Mod-Mod
 * 
 * ModBlocks
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ModBlocks {
	
	public static Block machine;
	public static Block bomb;
	
	public static void init() {
		
		machine = new BlockMachine(BlockIds.MACHINE_ID);
		bomb = new BlockBomb(BlockIds.BOMB_ID);
		
		GameRegistry.registerBlock(machine, ItemMachine.class, Strings.MACHINE_KEY);
		GameRegistry.registerBlock(bomb, Strings.BOMB_KEY);
		
		initBlockRecipes();
		
		registerTileEntities();
	}

	private static void initBlockRecipes() {
		GameRegistry.addRecipe(new ItemStack(machine), new Object[] { "ccc", "cic", "ccc", Character.valueOf('c'), Block.cobblestone, Character.valueOf('i'), Item.ingotIron });		
	}
	
	private static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileBomb.class, Strings.BOMB_TE_KEY);
	}
}
