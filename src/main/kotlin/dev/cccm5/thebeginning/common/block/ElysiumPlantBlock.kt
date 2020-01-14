package dev.cccm5.thebeginning.common.block

import dev.cccm5.thebeginning.common.registry.BlockRegistry
import net.minecraft.block.BlockState
import net.minecraft.block.PlantBlock
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView


class ElysiumPlantBlock(settings: Settings) : PlantBlock(settings) {
    override fun canPlantOnTop(floor: BlockState, view: BlockView, pos: BlockPos): Boolean {
        val block = floor.block
        return block == BlockRegistry.ELYSIUM_GRASS_BLOCK
    }
}