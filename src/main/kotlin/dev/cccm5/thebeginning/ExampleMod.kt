package dev.cccm5.thebeginning

import dev.cccm5.thebeginning.common.registry.*
import net.minecraft.util.Identifier


const val MOD_ID = "thebeginning"

@Suppress("unused")
fun init() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.
//    Registry.register(Registry.BLOCK, id("elysium_stone"), ElysiumStoneBlock())
    WorldRegistry.ELYSIUM
    BlockRegistry
    ItemRegistry
    BiomeRegistry
    FeatureRegistry
//    EntityRegistry
}

fun id(name: String): Identifier{
    return Identifier(MOD_ID, name)
}
