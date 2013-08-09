package com.fr3gu.letsmod.item;

import com.fr3gu.letsmod.lib.Strings;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Lets Mod-Mod
 * 
 * ItemMachine
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ItemMachine extends ItemBlock {
	
	public ItemMachine(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg) {
		return dmg; 
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		int meta = itemStack.getItemDamage() / 2;
		return super.getUnlocalizedName() + Strings.MACHINE_SIDES[meta];
	}
}
