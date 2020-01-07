package dev.cccm5.thebeginning.common.registry

import com.github.draylar.worldtraveler.api.dimension.DimensionBuilder
import dev.cccm5.thebeginning.common.world.ElysiumBiomeSource
import dev.cccm5.thebeginning.common.world.ElysiumChunkGeneratorConfig
import dev.cccm5.thebeginning.common.world.ElysiumChunkGeneratorType
import dev.cccm5.thebeginning.id
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType
import net.minecraft.block.pattern.BlockPattern
import net.minecraft.util.math.Vec3d

object WorldRegistry {
//    val ELEYSIUM = FabricDimensionType.builder()
//        .defaultPlacer { oldEntity, _, _, _, _ ->
//            BlockPattern.TeleportTarget(Vec3d(0.0, 100.0, 0.0), oldEntity.velocity, 0)
//        }.factory(::Eleysium).skyLight(true).buildAndRegister(id("eleysium`"))
    val ELYSIUM: FabricDimensionType = FabricDimensionType.builder().skyLight(true).factory { world, type ->
        DimensionBuilder()
            .hasThickFog(false)
            .fogColor{ _, _ -> Vec3d(255.0/255, 248.0/255, 199.0/255)}
            .setChunkGenerator(ElysiumChunkGeneratorType.INSTANCE.create(world, ElysiumBiomeSource(), ElysiumChunkGeneratorConfig()))
            .visibleSky(false)
            .doesWaterVaporize(false)
            .setLightLevelsToBrightness(getLightLevels())
            .backgroundColor{_, _ -> FloatArray(10)}
            .build(world, type)
    }.defaultPlacer{ oldEntity, _, _, _, _ ->
        BlockPattern.TeleportTarget(Vec3d(0.0, 100.0, 0.0), oldEntity.velocity, 0)
    }.buildAndRegister(id("eleysium"))

    private fun getLightLevels(): FloatArray {
        val lightLevels = FloatArray(16)
        for (i in 0..15) {
            val lightLevel = 1.0f - i.toFloat() / 15.0f
            lightLevels[i] = (1.0f - lightLevel) / (lightLevel * 3.0f + 1.0f) * 1.0f + 0.0f
        }
        return lightLevels
    }
}

