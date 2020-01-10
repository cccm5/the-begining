package dev.cccm5.thebeginning.common.registry

import com.mojang.datafixers.Dynamic
import dev.cccm5.thebeginning.common.world.feature.BrokenArchFeature
import dev.cccm5.thebeginning.common.world.feature.BrokenPanelFeature
import dev.cccm5.thebeginning.id
import net.minecraft.util.registry.Registry
import net.minecraft.world.gen.decorator.Decorator
import net.minecraft.world.gen.decorator.DecoratorConfig
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.feature.Feature.DECORATED
import net.minecraft.world.gen.feature.Feature.DECORATED_FLOWER
import java.util.function.Function


object FeatureRegistry {
    // TODO: Replace this function creation
    private val DESERIALIZE: Function<Dynamic<*>, out DefaultFeatureConfig> = Function{ dynamic: Dynamic<*>? -> DefaultFeatureConfig.deserialize(dynamic) }
    val BROKEN_ARCH: BrokenArchFeature = Registry.register(Registry.FEATURE, id("broken_arch"), BrokenArchFeature(DESERIALIZE))
    val BROKEN_PANEL: BrokenPanelFeature = Registry.register(Registry.FEATURE, id("broken_panel"), BrokenPanelFeature(DESERIALIZE))
}

fun <F : FeatureConfig?, D : DecoratorConfig?> configureFeature(
    feature: Feature<F>,
    featureConfig: F,
    decorator: Decorator<D>,
    decoratorConfig: D
): ConfiguredFeature<*, *>? {
    val feature2: Feature<FeatureConfig?> = if (feature is FlowerFeature<*>) DECORATED_FLOWER as Feature<FeatureConfig?> else DECORATED as Feature<FeatureConfig?>
    return ConfiguredFeature<FeatureConfig?, Feature<FeatureConfig?>>(feature2, DecoratedFeatureConfig(feature.configure(featureConfig), decorator.configure(decoratorConfig))
    )
}