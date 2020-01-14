package dev.cccm5.thebeginning.common.registry

import dev.cccm5.thebeginning.id
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.client.render.RenderLayer
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.registry.Registry


object ItemRegistry {
    private val GROUP = FabricItemGroupBuilder.build(id("the_beginning")) {
        ItemStack(BlockRegistry.SOUL_FLOWER_BLOCK)
    }
    val ELYSIUM_STONE: BlockItem = Registry.register(
        Registry.ITEM, id("elysium_stone"), BlockItem(
            BlockRegistry.ELYSIUM_STONE_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val WEIRED_LOG: BlockItem = Registry.register(
        Registry.ITEM, id("weired_log"), BlockItem(
            BlockRegistry.WEIRED_LOG_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val WEIRED_LEAVES: BlockItem = Registry.register(
        Registry.ITEM, id("weired_leaves"), BlockItem(
            BlockRegistry.WEIRED_LEAVES_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val EGGSHELL: BlockItem = Registry.register(
        Registry.ITEM, id("eggshell"), BlockItem(
            BlockRegistry.EGGSHELL_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val SHALE: BlockItem = Registry.register(
        Registry.ITEM,
        id("shale"),
        BlockItem(BlockRegistry.SHALE_BLOCK, Item.Settings().group(GROUP))
    )

    val SHALE_GRASS: BlockItem = Registry.register(
        Registry.ITEM, id("shale_grass"), BlockItem(
            BlockRegistry.SHALE_GRASS_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val ELYSIUM_GRASS: BlockItem = Registry.register(
        Registry.ITEM, id("elysium_grass"), BlockItem(
            BlockRegistry.ELYSIUM_GRASS_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val SOUL_STEEL: BlockItem = Registry.register(
        Registry.ITEM, id("soul_steel"), BlockItem(
            BlockRegistry.SOUL_STEEL_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val SOUL_FLOWER: BlockItem = Registry.register(
        Registry.ITEM, id("soul_flower"), BlockItem(
            BlockRegistry.SOUL_FLOWER_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val MUD: BlockItem =
        Registry.register(Registry.ITEM, id("mud"), BlockItem(BlockRegistry.MUD_BLOCK, Item.Settings().group(GROUP)))

    val MUD_BRICK: BlockItem = Registry.register(
        Registry.ITEM, id("mud_brick"), BlockItem(
            BlockRegistry.MUD_BRICK_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val SKY_SHARD: BlockItem =
        Registry.register(Registry.ITEM, id("sky_shard"), BlockItem(BlockRegistry.SKY_SHARD_BLOCK, Item.Settings()))
    val SKY_BRICK: BlockItem = Registry.register(
        Registry.ITEM, id("sky_brick"), BlockItem(
            BlockRegistry.SKY_BRICK_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )
    val SOUL_SHARD: BlockItem = Registry.register(
        Registry.ITEM, id("soul_skin"), BlockItem(
            BlockRegistry.SOUL_SKIN_BLOCK, Item.Settings().group(
                GROUP
            )
        )
    )

    val GRASS = Registry.register(
        Registry.ITEM,
        id("grass"),
        BlockItem(BlockRegistry.GRASS_BLOCK, Item.Settings().group(GROUP))
    )


    init {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.SOUL_FLOWER_BLOCK, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.GRASS_BLOCK, RenderLayer.getCutout())
    }
}