package dev.cccm5.thebeginning.common.world

import net.minecraft.world.IWorld
import net.minecraft.world.biome.source.BiomeSource
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator

class ElysiumChunkGenerator(world: IWorld, biomeSource: BiomeSource, config: ElysiumChunkGeneratorConfig) : SurfaceChunkGenerator<ElysiumChunkGeneratorConfig>(world, biomeSource, 5, 8, 256, config, true) {
    override fun computeNoiseFalloff(depth: Double, scale: Double, y: Int): Double {
        return 0.0
    }

    override fun computeNoiseRange(x: Int, z: Int): DoubleArray {
        return doubleArrayOf(0.0)
    }

    override fun sampleNoiseColumn(buffer: DoubleArray?, x: Int, z: Int) {
        // no-op
    }

    override fun getSpawnHeight(): Int {
        return 0
    }

}