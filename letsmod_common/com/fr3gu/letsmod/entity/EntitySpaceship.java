package com.fr3gu.letsmod.entity;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * Lets Mod-Mod
 * 
 * EntitySpaceship
 * 
 * @author fr3gu
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class EntitySpaceship extends Entity implements IEntityAdditionalSpawnData {
	
	private boolean charged;

	public EntitySpaceship(World world) {
		super(world);
		init();
	}

	public EntitySpaceship(World world, int x, int y, int z) {
		super(world);
		init();
		this.posX = x + 0.5F;
		this.posY = y + 1.5F;
		this.posZ = z + 0.5F;
	}

	private void init() {
		setSize(1.5F, 0.6F);
		
	}
	
	@Override
	public AxisAlignedBB getBoundingBox() {
		return boundingBox;
	}
	
	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		if(entity != riddenByEntity)
			return entity.boundingBox;
		
		return null;
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return !isDead;
	}
	
	@Override
	public boolean func_130002_c(EntityPlayer player) {
		if(!worldObj.isRemote && riddenByEntity == null) {
			player.mountEntity(this);
		}
		return true;
	}
	
	@Override
	public double getMountedYOffset() {
		return -0.15;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(!worldObj.isRemote) {
			if(riddenByEntity != null) {
				motionY = 0.2;				
			}
			else if(worldObj.isAirBlock((int)posX, (int)posY - 1, (int)posZ)) {
				motionY = -0.1;
			}
			else {
				motionY = 0;
			}
		}
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);
	}

	@Override
	protected void entityInit() {
		System.out.println("Init! Charged: " + charged);		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		charged = compound.getBoolean("Charged");		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		compound.setBoolean("Charged", charged);		
	}

	public boolean isCharged() {
		return charged;
	}
	
	public void setChargedState(boolean value) {
		charged = value;
	}

	@Override
	public void writeSpawnData(ByteArrayDataOutput data) {
		data.writeBoolean(charged);		
	}

	@Override
	public void readSpawnData(ByteArrayDataInput data) {
		charged = data.readBoolean();		
	}
}