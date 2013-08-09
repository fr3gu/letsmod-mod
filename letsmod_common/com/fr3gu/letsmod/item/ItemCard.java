package com.fr3gu.letsmod.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.fr3gu.letsmod.lib.Reference;
import com.fr3gu.letsmod.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCard extends ItemLMM {
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemCard(int id) {		
		super(id);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(Strings.CARD_NAME);
		this.setCreativeTab(CreativeTabs.tabMisc);
		maxStackSize = 64;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 5);
		return super.getUnlocalizedName() + Strings.CARD_NAMES[meta];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		int numberOfCards = Strings.CARD_NAMES.length;
		
		icons = new Icon[numberOfCards];
		
		for (int i = 0; i < numberOfCards; i++) {
			icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.CARD_NAME + Strings.CARD_NAMES[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
     * Gets an icon index based on an item's damage value
     */
	public Icon getIconFromDamage(int meta) {
		int j = MathHelper.clamp_int(meta, 0, 5);
		return icons[j];
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for(int meta = 0; meta < Strings.CARD_NAMES.length; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	}

}
