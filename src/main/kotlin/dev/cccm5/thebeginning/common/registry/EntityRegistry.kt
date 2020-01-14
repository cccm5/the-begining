package dev.cccm5.thebeginning.common.registry

import dev.cccm5.thebeginning.common.entity.StoneTitanEntity
import dev.cccm5.thebeginning.id
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityCategory
import net.minecraft.util.registry.Registry

object EntityRegistry {
    val STONE_TITAN = Registry.register(
        Registry.ENTITY_TYPE,
        id("stone-titan"),
        FabricEntityTypeBuilder.create(EntityCategory.MONSTER, ::StoneTitanEntity).build()
    )
}