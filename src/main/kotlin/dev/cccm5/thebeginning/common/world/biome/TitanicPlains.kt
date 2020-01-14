package dev.cccm5.thebeginning.common.world.biome

import dev.cccm5.thebeginning.common.registry.BlockRegistry
import dev.cccm5.thebeginning.common.registry.FeatureRegistry
import dev.cccm5.thebeginning.common.registry.configureFeature
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.util.math.MathHelper
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.DefaultBiomeFeatures
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig
import net.minecraft.world.gen.decorator.ChanceRangeDecoratorConfig
import net.minecraft.world.gen.decorator.CountDecoratorConfig
import net.minecraft.world.gen.decorator.Decorator
import net.minecraft.world.gen.feature.DefaultFeatureConfig
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig
import net.minecraft.world.gen.placer.SimpleBlockPlacer
import net.minecraft.world.gen.stateprovider.WeightedStateProvider
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig


class TitanicPlains : Biome(
    Settings().configureSurfaceBuilder(
        SurfaceBuilder.DEFAULT,
        TernarySurfaceConfig(
            BlockRegistry.ELYSIUM_GRASS_BLOCK.defaultState,
            BlockRegistry.ELYSIUM_STONE_BLOCK.defaultState,
            BlockRegistry.ELYSIUM_STONE_BLOCK.defaultState
        )
    )
        .precipitation(Precipitation.NONE)
        .category(Category.PLAINS)
        .depth(1.5f)
        .scale(0.25f)
        .temperature(2.0f)
        .downfall(0.0f)
        .waterColor(4159204)
        .waterFogColor(329011)
        .parent(null as String?)
) {
    init {
//        addCarver(
//            GenerationStep.Carver.AIR,
//            configureCarver(
//                Carver.HELL_CAVE,
//                ProbabilityConfig(0.2f)
//            )
//        )
        DefaultBiomeFeatures.addLandCarvers(this)
        DefaultBiomeFeatures.addMossyRocks(this)
        DefaultBiomeFeatures.addBadlandsVegetation(this)
        addFeature(
            GenerationStep.Feature.SURFACE_STRUCTURES,
            configureFeature(
                FeatureRegistry.BROKEN_ARCH,
                DefaultFeatureConfig(),
                Decorator.CHANCE_RANGE,
                ChanceRangeDecoratorConfig(.30f, 4, 8, 128)
            )
        )
        addFeature(
            GenerationStep.Feature.SURFACE_STRUCTURES,
            configureFeature(
                FeatureRegistry.BROKEN_PANEL,
                DefaultFeatureConfig(),
                Decorator.CHANCE_TOP_SOLID_HEIGHTMAP,
                ChanceDecoratorConfig(60)
            )
        )

        addFeature(
            GenerationStep.Feature.VEGETAL_DECORATION,
            configureFeature(
                Feature.RANDOM_PATCH,
                RandomPatchFeatureConfig.Builder(
                    WeightedStateProvider().addState(
                        BlockRegistry.SOUL_FLOWER_BLOCK.defaultState,
                        1
                    ).addState(BlockRegistry.GRASS_BLOCK.defaultState, 3), SimpleBlockPlacer()
                ).tries(32).build(),
                Decorator.COUNT_HEIGHTMAP_DOUBLE,
                CountDecoratorConfig(1)
            )
        )
    }

    @Environment(EnvType.CLIENT)
    override fun getSkyColor(): Int {
        return MathHelper.packRgb(162, 229, 213)
    }

}