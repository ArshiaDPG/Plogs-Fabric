package net.digitalpear.plogs.common.blocks;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LogCompatBlock extends AbstractPigLogBlock{
    private String mod;

    public LogCompatBlock(String requiredMod, Identifier pigId, Block logBlock, Settings settings) {
        super(pigId, logBlock, settings);
        mod = requiredMod;
    }
    public LogCompatBlock(String requiredMod, Identifier pigId, Identifier logBlock, Settings settings) {
        super(pigId, logBlock, settings);
        mod = requiredMod;
    }
    public boolean isModLoaded() {
        return FabricLoader.getInstance().getModContainer(mod).isPresent();
    }

    @Override
    public void spawnPig(ServerWorld world, BlockPos pos) {
        if (this.isModLoaded()){
            super.spawnPig(world, pos);
        }
        else{
            explode(world, pos, world.random.nextBetween(4, 10));
        }
    }
    private void explode(World world, BlockPos pos, float power) {
        world.createExplosion(null, pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, power, World.ExplosionSourceType.BLOCK);
    }
}
