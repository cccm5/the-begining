package dev.cccm5.thebeginning.common.world

import dev.cccm5.thebeginning.common.registry.BiomeRegistry
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.source.BiomeSource

class ElysiumBiomeSource: BiomeSource(setOf(BiomeRegistry.TITANIC_PLAINS)) {
    override fun getBiomeForNoiseGen(biomeX: Int, biomeY: Int, biomeZ: Int): Biome {
        return BiomeRegistry.TITANIC_PLAINS
    }

}