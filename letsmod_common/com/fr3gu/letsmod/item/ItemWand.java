package com.fr3gu.letsmod.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import com.fr3gu.letsmod.lib.Reference;
import com.fr3gu.letsmod.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWand extends ItemLMM {
	
	@SideOnly(Side.CLIENT)
	private Icon chargedIcon;

	public ItemWand(int id) {
		super(id);
		this.setUnlocalizedName(Strings.WAND_NAME);
        this.setCreativeTab(CreativeTabs.tabCombat);
        maxStackSize = 1;
	}
	
	@Override
	public boolean func_111207_a(ItemStack itemStack, EntityPlayer player, EntityLivingBase target) {
		if(!target.worldObj.isRemote) {
			target.motionY = 2;
			if(isCharged(itemStack.getItemDamage())) {
				target.motionX = (target.posX - player.posX) * 2;
				target.motionZ = (target.posZ - player.posZ) * 2;
				
				itemStack.setItemDamage(0);				
			}
			else {
				itemStack.setItemDamage(itemStack.getItemDamage() + 1);
			}
			
		}
		
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
		chargedIcon = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.WAND_CHARGED_ICON);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useExtraInformation) {
		info.add("This fun thing has been used " + itemStack.getItemDamage() + "times");
		
		if(isCharged(itemStack.getItemDamage())) {
			info.add("This item is charged");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		if(isCharged(dmg))
			return chargedIcon;
		return itemIcon;
	}
	
	private boolean isCharged(int dmg) {
		return dmg >= 10;
	}
}
