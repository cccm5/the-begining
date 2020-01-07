package dev.cccm5.thebeginning.common.world

import net.minecraft.block.Blocks
import net.minecraft.world.gen.chunk.OverworldChunkGeneratorConfig

class ElysiumChunkGeneratorConfig : OverworldChunkGeneratorConfig() {
    init{
        defaultBlock = Blocks.SANDSTONE.defaultState
        defaultFluid = Blocks.LAVA.defaultState
    }
}