package dev.cccm5.thebeginning.common.world

import dev.cccm5.thebeginning.common.registry.WorldRegistry
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.ChunkPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import net.minecraft.world.biome.source.BiomeSourceType
import net.minecraft.world.dimension.Dimension
import net.minecraft.world.dimension.DimensionType
import net.minecraft.world.gen.chunk.ChunkGenerator
import net.minecraft.world.gen.chunk.ChunkGeneratorType
import net.minecraft.world.gen.chunk.OverworldChunkGeneratorConfig


class Elysium(world: World?, type: DimensionType?) : Dimension(world, type, 0f) {
    override fun isFogThick(x: Int, z: Int): Boolean {
        return false
    }

    override fun getSpawningBlockInChunk(chunkPos: ChunkPos?, checkMobSpawnValidity: Boolean): BlockPos? {
        return null
    }

    override fun getSkyAngle(timeOfDay: Long, tickDelta: Float): Float {
        return 0f
    }

    override fun createChunkGenerator(): ChunkGenerator<*> {
        return ChunkGeneratorType.SURFACE.create(
            world,
            BiomeSourceType.FIXED.applyConfig(BiomeSourceType.FIXED.getConfig(null)),
            OverworldChunkGeneratorConfig()
        )
    }

    override fun getTopSpawningBlockPosition(x: Int, z: Int, checkMobSpawnValidity: Boolean): BlockPos? {
        return null
    }

    override fun getType(): DimensionType {
        return WorldRegistry.ELYSIUM
    }

    override fun hasVisibleSky(): Boolean {
        return true
    }

    override fun canPlayersSleep(): Boolean {
        return false
    }

    override fun getFogColor(skyAngle: Float, tickDelta: Float): Vec3d {
        return Vec3d(0.0,0.0,0.0)
    }
}