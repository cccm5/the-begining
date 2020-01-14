package dev.cccm5.thebeginning.common.registry

import dev.cccm5.thebeginning.common.block.ElysiumPlantBlock
import dev.cccm5.thebeginning.common.block.ElysiumStoneBlock
import dev.cccm5.thebeginning.id
import net.fabricmc.fabric.api.block.FabricBlockSettings
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.block.*
import net.minecraft.client.render.RenderLayer
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.registry.Registry


object BlockRegistry {
    val ELYSIUM_STONE_BLOCK: ElysiumStoneBlock = Registry.register(Registry.BLOCK, id("elysium_stone"), ElysiumStoneBlock())
    val EGGSHELL_BLOCK: Block = Registry.register(Registry.BLOCK, id("eggshell"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val SHALE_BLOCK: Block = Registry.register(Registry.BLOCK, id("shale"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val SHALE_GRASS_BLOCK: Block = Registry.register(Registry.BLOCK, id("shale_grass"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val WEIRED_LEAVES_BLOCK: LeavesBlock = Registry.register(Registry.BLOCK, id("weired_leaves"), LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F, 0.0F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().build()))
    val WEIRED_LOG_BLOCK: LogBlock = Registry.register(Registry.BLOCK, id("weired_log"), LogBlock(MaterialColor.WOOD, FabricBlockSettings.of(Material.WOOD).strength(2.0F, 0.0F).sounds(BlockSoundGroup.WOOD).build()))
    val ELYSIUM_GRASS_BLOCK: Block = Registry.register(Registry.BLOCK, id("elysium_grass"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val SOUL_STEEL_BLOCK: Block = Registry.register(Registry.BLOCK, id("soul_steel"), Block(FabricBlockSettings.of(Material.METAL).build()))
    val SOUL_FLOWER_BLOCK: Block = Registry.register(Registry.BLOCK, id("soul_flower"), ElysiumPlantBlock(FabricBlockSettings.of(Material.PLANT).noCollision().nonOpaque().breakInstantly().build()))
    val MUD_BLOCK: Block = Registry.register(Registry.BLOCK, id("mud"), Block(FabricBlockSettings.of(Material.CLAY).build()))
    val MUD_BRICK_BLOCK: Block = Registry.register(Registry.BLOCK, id("mud_brick"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val SKY_SHARD_BLOCK: Block = Registry.register(Registry.BLOCK, id("sky_shard"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val SKY_BRICK_BLOCK: Block = Registry.register(Registry.BLOCK, id("sky_brick"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val SOUL_SKIN_BLOCK: Block = Registry.register(Registry.BLOCK, id("soul_skin"), Block(FabricBlockSettings.of(Material.WOOL).build()))
    val GRASS_BLOCK: ElysiumPlantBlock = Registry.register(Registry.BLOCK, id("grass"), ElysiumPlantBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).build()))
}