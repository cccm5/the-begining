package dev.cccm5.thebeginning.common.registry

import dev.cccm5.thebeginning.common.block.ElysiumStoneBlock
import dev.cccm5.thebeginning.id
import net.fabricmc.fabric.api.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.registry.Registry


object BlockRegistry {
    val ELYSIUM_STONE: ElysiumStoneBlock = Registry.register(Registry.BLOCK, id("elysium_stone"), ElysiumStoneBlock())
    val EGGSHELL: Block = Registry.register(Registry.BLOCK, id("eggshell"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val SHALE: Block = Registry.register(Registry.BLOCK, id("shale"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val SHALE_GRASS: Block = Registry.register(Registry.BLOCK, id("shale_grass"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val WEIRED_LEAVES: LeavesBlock = Registry.register(Registry.BLOCK, id("weired_leaves"), LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F, 0.0F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().build()))
    val WEIRED_LOG: LogBlock = Registry.register(Registry.BLOCK, id("weired_log"), LogBlock(MaterialColor.WOOD, FabricBlockSettings.of(Material.WOOD).strength(2.0F, 0.0F).sounds(BlockSoundGroup.WOOD).build()))
    val ELYSIUM_GRASS: Block = Registry.register(Registry.BLOCK, id("elysium_grass"), Block(FabricBlockSettings.of(Material.STONE).build()))
    val SOUL_STEEL: Block = Registry.register(Registry.BLOCK, id("soul_steel"), Block(FabricBlockSettings.of(Material.METAL).build()))
    init {
        Registry.register(Registry.ITEM, id("elysium_stone"), BlockItem(ELYSIUM_STONE, Item.Settings().group(ItemGroup.MISC)))
        Registry.register(Registry.ITEM, id("weired_log"), BlockItem(WEIRED_LOG, Item.Settings().group(ItemGroup.MISC)))
        Registry.register(Registry.ITEM, id("weired_leaves"), BlockItem(WEIRED_LEAVES, Item.Settings().group(ItemGroup.MISC)))
        Registry.register(Registry.ITEM, id("eggshell"), BlockItem(EGGSHELL, Item.Settings().group(ItemGroup.MISC)))
        Registry.register(Registry.ITEM, id("shale"), BlockItem(SHALE, Item.Settings().group(ItemGroup.MISC)))
        Registry.register(Registry.ITEM, id("shale_grass"), BlockItem(SHALE_GRASS, Item.Settings().group(ItemGroup.MISC)))
        Registry.register(Registry.ITEM, id("elysium_grass"), BlockItem(ELYSIUM_GRASS, Item.Settings().group(ItemGroup.MISC)))
        Registry.register(Registry.ITEM, id("soul_steel"), BlockItem(SOUL_STEEL, Item.Settings().group(ItemGroup.MISC)))
    }
}