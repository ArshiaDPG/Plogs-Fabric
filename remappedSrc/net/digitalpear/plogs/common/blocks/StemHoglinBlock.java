package net.digitalpear.plogs.common.blocks;

import net.digitalpear.plogs.init.PlogsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class StemHoglinBlock extends AbstractPigLogBlock {
    public StemHoglinBlock(EntityType<?> pig, Block logBlock, Settings settings) {
        super(pig, logBlock, settings);
    }

    //Rusting
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient) {
            if (world.getDimension().isBedWorking()) {
                double d = random.nextGaussian() * 0.02D;
                double e = random.nextGaussian() * 0.02D;
                double f = random.nextGaussian() * 0.02D;
                world.addParticle(ParticleTypes.EFFECT, pos.getX(), pos.getY(), pos.getZ(), d, e, f);
                world.setBlockState(pos, PlogsBlocks.STEM_ZOGLIN.getStateWithProperties(state));
            }
        }
    }
}
