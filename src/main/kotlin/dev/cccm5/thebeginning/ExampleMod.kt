package dev.cccm5.thebeginning

import dev.cccm5.thebeginning.common.block.ElysiumStoneBlock
import dev.cccm5.thebeginning.common.registry.WorldRegistry
import net.fabricmc.fabric.api.block.FabricBlockSettings
import net.minecraft.block.Material
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


const val MOD_ID = "thebeginning"

@Suppress("unused")
fun init() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.
    Registry.register(Registry.BLOCK, id("eleysiumstone"), ElysiumStoneBlock(FabricBlockSettings.of(
        Material.STONE).build()))
    WorldRegistry.ELYSIUM
}

fun id(name: String): Identifier{
    return Identifier(MOD_ID, name)
}
