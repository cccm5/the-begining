package dev.cccm5.thebeginning.common.registry

import dev.cccm5.thebeginning.common.world.biome.TitanicPlains
import dev.cccm5.thebeginning.id
import net.minecraft.util.registry.Registry

object BiomeRegistry {
    val TITANIC_PLAINS: TitanicPlains = Registry.register(Registry.BIOME, id("titanic_plains"), TitanicPlains())
}