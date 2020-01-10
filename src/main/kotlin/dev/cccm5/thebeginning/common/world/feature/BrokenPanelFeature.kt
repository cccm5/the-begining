package dev.cccm5.thebeginning.common.world.feature

import com.mojang.datafixers.Dynamic
import dev.cccm5.thebeginning.common.registry.BlockRegistry
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.IWorld
import net.minecraft.world.gen.chunk.ChunkGenerator
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig
import net.minecraft.world.gen.feature.DefaultFeatureConfig
import net.minecraft.world.gen.feature.Feature
import java.util.*
import java.util.function.Function
import kotlin.math.cos
import kotlin.math.sin
import kotlin.streams.toList

class BrokenPanelFeature(config: Function<Dynamic<*>, out DefaultFeatureConfig>): Feature<DefaultFeatureConfig>(config)  {
    override fun generate(
        world: IWorld,
        generator: ChunkGenerator<out ChunkGeneratorConfig>?,
        random: Random,
        pos: BlockPos,
        config: DefaultFeatureConfig?
    ): Boolean {
        val center = pos.up()
        val stack = Stack<BlockPos>()
        stack.add(center)
        val visited = mutableSetOf<BlockPos>()
        val valid = mutableListOf<BlockPos>()
        val x = random.nextInt(10) + 5
        val y = random.nextInt(3) + 2
        val z = 2*x
        val theta = random.nextDouble()*  2 * kotlin.math.PI
        val phi = random.nextDouble()*  2 * kotlin.math.PI
        val omega = random.nextDouble()*  2 * kotlin.math.PI
        while (stack.isNotEmpty()){
            val top = stack.pop()
            if(top in visited)
                continue
            visited.add(top)
            if(!inRectangle(top, center, x, y, z, theta, phi, omega)){
                continue
            }
            valid.add(top)
            for(neighbor in listOf(top.up(), top.down(), top.north(), top.south(), top.east(),top.west())){
                stack.add(neighbor)
            }
        }
        val filtered = mutableListOf<BlockPos>()
        for(torusPos in valid) {
            if(torusPos.y > 255 || torusPos.y < 1){
                continue
            }
            val state = world.getBlockState(torusPos)
            if (state.isAir || state.material.isLiquid || state.material.isReplaceable) {
                filtered.add(torusPos)
            }
        }
        if(filtered.isEmpty()){
            return false
        }
        for(torusPos in filtered){
            world.setBlockState(torusPos, BlockRegistry.SOUL_STEEL.defaultState, 3)
        }
        println("Generated panel at $center")
        return true
    }

    private fun rotate(pos: BlockPos, center: BlockPos, theta: Double, phi: Double, omega: Double): Vec3d {
        val shifted = pos.subtract(center)
        //y axis
        var (zPrime,xPrime) = rotate2d(shifted.z.toDouble(), shifted.x.toDouble(), theta)
        var yPrime: Double = shifted.y.toDouble()
        // z axis
        var temp = rotate2d(xPrime, yPrime, phi)
        xPrime = temp.first
        yPrime = temp.second
        // x axis
        temp = rotate2d(yPrime, zPrime, omega)
        yPrime = temp.first
        zPrime = temp.second
        return Vec3d(xPrime, yPrime, zPrime)
    }
    
    private fun rotate2d(x: Double, y: Double, theta: Double): Pair<Double, Double> {
        return Pair(x*cos(theta) - y*sin(theta), x*sin(theta) + y*cos(theta))
    }
    
    private fun inRectangle(pos: BlockPos, center: BlockPos, x: Int, y: Int, z: Int, theta: Double, phi: Double, omega: Double): Boolean{
        val rotated = rotate(pos, center, theta, phi, omega)
        return rotated.x < x && rotated.x > -x && rotated.y < y && rotated.y > -y && rotated.z < z && rotated.z > -z
    }
}