package dev.cccm5.thebeginning.common.world.feature

import com.mojang.datafixers.Dynamic
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IWorld
import net.minecraft.world.gen.chunk.ChunkGenerator
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig
import net.minecraft.world.gen.feature.DefaultFeatureConfig
import net.minecraft.world.gen.feature.Feature
import java.util.*
import java.util.function.Function

class ElysiumRockFeature(config: Function<Dynamic<*>, out DefaultFeatureConfig>): Feature<DefaultFeatureConfig>(config){
    override fun generate(
        world: IWorld?,
        generator: ChunkGenerator<out ChunkGeneratorConfig>?,
        random: Random?,
        pos: BlockPos?,
        config: DefaultFeatureConfig?
    ): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}