package com.fr3gu.letsmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.fr3gu.letsmod.lib.Reference;
import com.fr3gu.letsmod.lib.Strings;
import com.fr3gu.letsmod.tileentity.TileBomb;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Lets Mod-Mod
 * 
 * BlockBomb
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockBomb extends BlockLMM {

	public BlockBomb(int id) {
		super(id, Material.wood);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setStepSound(Block.soundPowderFootstep);
		setUnlocalizedName(Strings.BOMB_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon idleIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.BOMB_TEXTURE);
		idleIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.BOMB_IDLE_TEXTURE);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return meta == 0 ? blockIcon : idleIcon;
	}

	@Override
    public TileEntity createNewTileEntity(World world) {
        return new TileBomb();
    }
	
}
