package com.fr3gu.letsmod.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.fr3gu.letsmod.lib.Reference;
import com.fr3gu.letsmod.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Lets Mod-Mod
 * 
 * BlockMachine
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockMachine extends BlockLMM {
	
	public BlockMachine(int id) {
		super(id, Material.iron);
		
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.setHardness(2F);
        this.setStepSound(Block.soundMetalFootstep);
		this.setUnlocalizedName(Strings.MACHINE_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;	
	@SideOnly(Side.CLIENT)
	private Icon bottomIcon;	
	@SideOnly(Side.CLIENT)
	private Icon[] sideIcons;
	@SideOnly(Side.CLIENT)
	private Icon disabledIcon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		topIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.MACHINE_TOP);
		bottomIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.MACHINE_BOTTOM);
		sideIcons = new Icon[Strings.MACHINE_SIDES.length];
		for(int i = 0; i < Strings.MACHINE_SIDES.length; i++) {
			sideIcons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.MACHINE_SIDE + Strings.MACHINE_SIDES[i]);
		}
		disabledIcon = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), Strings.MACHINE_DISABLED));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		
		if(side == 0)
			return bottomIcon;
		
		if(side == 1)
			return isDisabled(meta) ? disabledIcon : topIcon;
		
		int type = meta / 2;
		return sideIcons[type];
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		// If we are on the server side...
		if(!world.isRemote && !isDisabled(world.getBlockMetadata(x, y, z))) {
			spawnAnvil(world, x, y + 20, z);
		}
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
		int meta = world.getBlockMetadata(x, y, z);
		if(!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && !isDisabled(meta)) {
			switch (meta / 2) {
				case 1:
					for(int i = 0; i < 5; i++) {
						spawnAnvil(world, x, y + 20 + i, z);
					}
					break;
					
				case 2:
					for(int i = -1; i <= 1; i++) {
						spawnAnvil(world, x + i, y + 20, z - 2);
						spawnAnvil(world, x + i, y + 20, z + 2);
						spawnAnvil(world, x - 2, y + 20, z + i);
						spawnAnvil(world, x + 2, y + 20, z + i);
					}
					break;
				
				case 3:
					for(int i = 1; i <= 3; i++) {
						spawnAnvil(world, x + i, y + 20, z);
						spawnAnvil(world, x - i, y + 20, z);
						spawnAnvil(world, x, y + 20, z + i);
						spawnAnvil(world, x, y + 20, z - i);
					}
					break;
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			int meta = world.getBlockMetadata(x, y, z);
			
			int type = meta / 2;
			
			int disabled = meta % 2 == 0 ? 1 : 0;
			
			int newMeta = type * 2 + disabled;
			
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
		}
		return true;
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < Strings.MACHINE_SIDES.length; i++) {
			list.add(new ItemStack(id, 1, i * 2));
		}
	}
	
	private boolean isDisabled(int meta) {
		return meta % 2 == 1;
	}
	
	private void spawnAnvil(World world, int x, int y, int z) {
		if(world.isAirBlock(x,  y, z)) {
			world.setBlock(x, y, z, Block.anvil.blockID);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
}
