package dev.cccm5.thebeginning.common.world

import dev.cccm5.thebeginning.common.registry.BlockRegistry
import net.minecraft.world.gen.chunk.OverworldChunkGeneratorConfig

class ElysiumChunkGeneratorConfig : OverworldChunkGeneratorConfig() {
    init{
        defaultBlock = BlockRegistry.ELYSIUM_STONE_BLOCK.defaultState
        defaultFluid = BlockRegistry.ELYSIUM_STONE_BLOCK.defaultState
    }
}