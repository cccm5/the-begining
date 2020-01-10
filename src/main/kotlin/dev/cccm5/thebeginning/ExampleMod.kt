package dev.cccm5.thebeginning

import dev.cccm5.thebeginning.common.registry.BiomeRegistry
import dev.cccm5.thebeginning.common.registry.BlockRegistry
import dev.cccm5.thebeginning.common.registry.WorldRegistry
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
    BiomeRegistry
}

fun id(name: String): Identifier{
    return Identifier(MOD_ID, name)
}
