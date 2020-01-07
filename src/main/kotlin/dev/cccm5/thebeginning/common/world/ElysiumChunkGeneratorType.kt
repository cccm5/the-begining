package dev.cccm5.thebeginning.common.world

import dev.cccm5.thebeginning.id
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import net.minecraft.world.biome.source.BiomeSource
import net.minecraft.world.gen.chunk.ChunkGeneratorType
import java.util.function.Supplier

class ElysiumChunkGeneratorType(buffetScreen: Boolean, configSupplier: Supplier<ElysiumChunkGeneratorConfig>): ChunkGeneratorType<ElysiumChunkGeneratorConfig, ElysiumChunkGenerator>(null, buffetScreen, configSupplier) {
    companion object{
        var INSTANCE: ElysiumChunkGeneratorType = Registry.register(Registry.CHUNK_GENERATOR_TYPE, id("test"), ElysiumChunkGeneratorType(false, Supplier{ElysiumChunkGeneratorConfig()}))
    }

    override fun create(world: World, biomeSource: BiomeSource, config: ElysiumChunkGeneratorConfig): ElysiumChunkGenerator {
        return ElysiumChunkGenerator(world, biomeSource, config)
    }
}