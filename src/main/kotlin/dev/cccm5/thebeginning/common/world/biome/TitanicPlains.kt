package dev.cccm5.thebeginning.common.world.biome

import net.minecraft.entity.EntityCategory
import net.minecraft.entity.EntityType
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.DefaultBiomeFeatures
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder


class TitanicPlains : Biome(
    Settings().configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
        .precipitation(Precipitation.RAIN)
        .category(Category.PLAINS)
        .depth(0.24f)
        .scale(0.2f)
        .temperature(0.6f)
        .downfall(0.7f)
        .waterColor(4159204)
        .waterFogColor(329011)
        .parent(null as String?)) {
    init {
        this.addStructureFeature(Feature.MINESHAFT.configure(MineshaftFeatureConfig(0.004, MineshaftFeature.Type.NORMAL)))
//        this.addStructureFeature(Feature.MINESHAFT, MineshaftFeatureConfig(0.004, MineshaftFeature.Type.NORMAL))
        this.addStructureFeature(Feature.STRONGHOLD.configure(FeatureConfig.DEFAULT))
        this.addStructureFeature(Feature.VILLAGE.configure(VillageFeatureConfig("village/plains/town_centers", 6)))
        DefaultBiomeFeatures.addLandCarvers(this)
        DefaultBiomeFeatures.addDefaultStructures(this)
        DefaultBiomeFeatures.addDefaultLakes(this)
        DefaultBiomeFeatures.addDungeons(this)
        DefaultBiomeFeatures.addExtraMountainTrees(this)
        DefaultBiomeFeatures.addDefaultFlowers(this)
        DefaultBiomeFeatures.addDefaultGrass(this)
        DefaultBiomeFeatures.addMineables(this)
        DefaultBiomeFeatures.addDefaultOres(this)
        DefaultBiomeFeatures.addDefaultDisks(this)
        DefaultBiomeFeatures.addDefaultVegetation(this)
        DefaultBiomeFeatures.addSprings(this)
        DefaultBiomeFeatures.addFrozenTopLayer(this)
        this.addSpawn(EntityCategory.CREATURE, SpawnEntry(EntityType.SHEEP, 12, 4, 4))
        this.addSpawn(EntityCategory.CREATURE, SpawnEntry(EntityType.PIG, 10, 4, 4))
        this.addSpawn(EntityCategory.CREATURE, SpawnEntry(EntityType.CHICKEN, 10, 4, 4))
        this.addSpawn(EntityCategory.CREATURE, SpawnEntry(EntityType.COW, 8, 4, 4))
        this.addSpawn(EntityCategory.AMBIENT,  SpawnEntry(EntityType.BAT, 10, 8, 8))
        this.addSpawn(EntityCategory.MONSTER,  SpawnEntry(EntityType.SPIDER, 100, 4, 4))
        this.addSpawn(EntityCategory.MONSTER,  SpawnEntry(EntityType.ZOMBIE, 95, 4, 4))
        this.addSpawn(EntityCategory.MONSTER,  SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
        this.addSpawn(EntityCategory.MONSTER,  SpawnEntry(EntityType.SKELETON, 100, 4, 4))
        this.addSpawn(EntityCategory.MONSTER,  SpawnEntry(EntityType.CREEPER, 100, 4, 4))
        this.addSpawn(EntityCategory.MONSTER,  SpawnEntry(EntityType.SLIME, 100, 4, 4))
        this.addSpawn(EntityCategory.MONSTER,  SpawnEntry(EntityType.ENDERMAN, 10, 1, 4))
        this.addSpawn(EntityCategory.MONSTER,  SpawnEntry(EntityType.WITCH, 5, 1, 1))
    }

}