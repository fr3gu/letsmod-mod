package com.fr3gu.letsmod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.fr3gu.letsmod.lib.BlockIds;

/**
 * Lets Mod-Mod
 * 
 * TileBomb
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class TileBomb extends TileEntity {
	private int timer;
	private int level;
	
	public TileBomb() {
		timer = 100;
		level = 0;
	}
	
	public boolean isIdle() {
		return timer < 0;
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote) {
			if(timer == 0) {
				spread(xCoord + 1, yCoord, zCoord);
				spread(xCoord - 1, yCoord, zCoord);
				spread(xCoord, yCoord, zCoord + 1);
				spread(xCoord, yCoord, zCoord - 1);
				//worldObj.addBlockEvent(xCoord, yCoord, zCoord, BlockIds.BOMB_ID, 1, 0);
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
			}
			timer--;
		}		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		compound.setShort("Timer", (short)timer);
		compound.setByte("Level", (byte)level);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		timer = compound.getShort("Timer");
		level = compound.getByte("Level");
	}
	
//	@Override
//	public boolean receiveClientEvent(int id, int value) {
//		if(worldObj.isRemote && id == 1) {
//			if(value == 0) {
//				timer = -1;
//			}
//			else {
//				timer = 100;
//			}
//			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
//		}
//		return true;
//	}
	
	private void spread(int x, int y, int z) {
		if(worldObj.isAirBlock(x, y, z)) {
			worldObj.setBlock(x, y, z, BlockIds.BOMB_ID);
			
			TileEntity tile = worldObj.getBlockTileEntity(x, y, z);
			
			if(tile != null && tile instanceof TileBomb) {
				TileBomb bomb = (TileBomb)worldObj.getBlockTileEntity(x, y, z);
				
				bomb.level = level + 1;
			}			
		}
	}
}
