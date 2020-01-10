package dev.cccm5.thebeginning.common.world.feature

import com.mojang.datafixers.Dynamic
import dev.cccm5.thebeginning.common.registry.BlockRegistry
import net.fabricmc.loader.util.sat4j.core.Vec
import net.minecraft.block.Blocks
import net.minecraft.client.util.math.Vector3d
import net.minecraft.client.util.math.Vector3f
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i
import net.minecraft.world.Heightmap
import net.minecraft.world.IWorld
import net.minecraft.world.gen.chunk.ChunkGenerator
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig
import net.minecraft.world.gen.feature.DefaultFeatureConfig
import net.minecraft.world.gen.feature.Feature
import java.lang.Math.cos
import java.lang.Math.sin
import java.util.*
import java.util.function.Function
import kotlin.random.asKotlinRandom


class BrokenArchFeature(config: Function<Dynamic<*>, out DefaultFeatureConfig>): Feature<DefaultFeatureConfig>(config) {
    override fun generate(
        world: IWorld,
        generator: ChunkGenerator<out ChunkGeneratorConfig>,
        random: Random,
        pos: BlockPos,
        config: DefaultFeatureConfig
    ): Boolean {
        val center = pos.up(1)
        if(!world.getBlockState(center).isAir) {
            return false
        }
        val minorRadius = 2
        val radius = random.nextInt(10) + minorRadius+5
        val rotation = random.nextDouble()

        val stack = Stack<BlockPos>()
//        for(x in -1..1){
//            for(y in -1..1){
//                for(z in -1..1){
//                    if(x == 0 && y == 0 && z == 0){
//                        continue
//                    }
//                    stack.add(start.add(x,y,z))
//                }
//            }
//        }
        val start = BlockPos(rotate(center.up(radius), center, rotation)).add(center)
        for(neighbor in listOf(start.up(), start.down(), start.north(), start.south(), start.east(),start.west(), start)){
            stack.add(neighbor)
        }
        val visited = mutableSetOf<BlockPos>()
        val valid = mutableListOf<BlockPos>()
        while(!stack.isEmpty()){
            val top = stack.pop()
            if(top in visited)
                continue
            visited.add(top)
            if(!inTorus(top, center, radius, minorRadius, rotation * 2 * kotlin.math.PI)){
                continue
            }
            valid.add(top)
            for(neighbor in listOf(top.up(), top.down(), top.north(), top.south(), top.east(),top.west())){
                stack.add(neighbor)
            }
        }
        val filtered = mutableListOf<BlockPos>()
        var bottom = 0
        for(torusPos in valid) {
            if(torusPos.y > 255 || torusPos.y < 1){
                continue
            }
            val state = world.getBlockState(torusPos)
            if (state.isAir || state.material.isLiquid || state.material.isReplaceable) {
                filtered.add(torusPos)
                if(torusPos.y < center.y)
                    bottom++
            }
        }
        val ratio = filtered.size.toDouble() / valid.size
        if(ratio < .3 || ratio > .7 || bottom.toDouble()/filtered.size > .5){
            return false
        }
        // normal vector to plane at origin
        val normal = filtered.random(random = random.asKotlinRandom()).subtract(center)
        for(torusPos in filtered){
            //plane-side test
            if(torusPos.y > center.y && normal.dot(torusPos.subtract(center)) < 0)
                continue
            world.setBlockState(torusPos, BlockRegistry.SOUL_STEEL.defaultState, 3)
        }
        return true
    }
    
    private fun inTorus(pos: BlockPos, center: BlockPos, majorRadius: Int, minorRadius: Int, rotation: Double): Boolean{
        val shifted = rotate(pos, center, rotation)
        val zPrime = shifted.z
        val xPrime = shifted.x
        val temp = xPrime * xPrime + shifted.y*shifted.y + zPrime*zPrime + majorRadius * majorRadius - minorRadius * minorRadius
        return temp * temp < 4 * majorRadius * majorRadius * (xPrime*xPrime + shifted.y*shifted.y)
    }
    
    private fun rotate(pos: BlockPos, center: BlockPos, rotation: Double): Vec3d {
        val shifted = pos.subtract(center)
        val zPrime = (shifted.z* kotlin.math.cos(rotation) - shifted.x* kotlin.math.sin(rotation))
        val xPrime = (shifted.z* kotlin.math.sin(rotation) + shifted.x* kotlin.math.cos(rotation))
        return Vec3d(xPrime, shifted.y.toDouble(), zPrime)
    }
    
    private fun Vec3i.dot(other: Vec3i): Int{
        return this.x*other.x + this.y*other.y + this.z*other.z
    }
    
//    private fun BlockPos(vec: Vec3d): BlockPos{
//        return BlockPos(vec.x, vec.y, vec.z)
//    }

}