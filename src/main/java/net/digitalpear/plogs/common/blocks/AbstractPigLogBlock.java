package net.digitalpear.plogs.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class AbstractPigLogBlock extends HorizontalFacingBlock {

    private final EntityType<?> pigType;
    private final Block log;


    public AbstractPigLogBlock(Identifier pigId, Block logBlock, Settings settings) {
        super(settings);
        this.pigType = getPig(pigId);
        this.log = logBlock;
    }
    public AbstractPigLogBlock(EntityType<?> pig, Block logBlock, Settings settings) {
        super(settings);
        this.pigType = pig;
        this.log = logBlock;
    }



    public EntityType<?> getPigType(){
        return this.pigType;
    }

    public Block getLog() {
        return log;
    }

    private static EntityType<?> getPig(Identifier id){
        for (EntityType<?> entityType : Registries.ENTITY_TYPE) {
            if (Registries.ENTITY_TYPE.getId(entityType) == id) {
                return Registries.ENTITY_TYPE.get(id);
            }
        }
        return EntityType.PIG;
    }

    private void spawnPig(ServerWorld world, BlockPos pos){
        Entity pigEntity = getPigType().create(world);
        assert pigEntity != null;
        pigEntity.refreshPositionAndAngles((double)pos.getX() + 0.5, pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
        world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1.0f, 1.0f);
        world.spawnEntity(pigEntity);
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        getLog().onStacksDropped(state, world, pos, tool, dropExperience);
        if (world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool) == 0) {
            this.spawnPig(world, pos);
        }

    }
    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (world instanceof ServerWorld) {
            this.spawnPig((ServerWorld)world, pos);
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
