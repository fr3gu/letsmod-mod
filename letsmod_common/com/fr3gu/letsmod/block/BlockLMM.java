package com.fr3gu.letsmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.fr3gu.letsmod.core.util.helpers.Helpers;
import com.fr3gu.letsmod.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Lets Mod-Mod
 * 
 * BlockLMM
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockLMM extends Block {
	
	public BlockLMM(int id, Material material) {
		super(id, Material.iron);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        blockIcon = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), Helpers.getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }
}
