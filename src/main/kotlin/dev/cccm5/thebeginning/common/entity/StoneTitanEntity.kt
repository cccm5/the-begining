package dev.cccm5.thebeginning.common.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.mob.MobEntity
import net.minecraft.entity.mob.Monster
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.Packet
import net.minecraft.world.World

class StoneTitanEntity(type: EntityType<out StoneTitanEntity>, world: World) : MobEntity(type, world),  Monster {

}