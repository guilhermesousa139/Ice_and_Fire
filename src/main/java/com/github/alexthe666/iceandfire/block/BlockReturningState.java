package com.github.alexthe666.iceandfire.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;

public class BlockReturningState extends Block {
    public static final BooleanProperty REVERTS = BooleanProperty.create("revert");
    public Item itemBlock;
    private final BlockState returnState;

/*    public BlockReturningState(float hardness, float resistance, SoundType sound, BlockState returnToState) {
        super(
            BlockBehaviour.Properties
                .of()
                .sound(sound)
                .strength(hardness, resistance)
                .randomTicks()
        );

        this.returnState = returnToState;
        this.registerDefaultState(this.stateDefinition.any().setValue(REVERTS, Boolean.FALSE));
    }*/

    public static BlockReturningState builder(float hardness, float resistance, SoundType sound, boolean slippery, Material material, BlockState returnToState) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of(material).sound(sound).strength(hardness, resistance).friction(0.98F).randomTicks();
        return new BlockReturningState(props, returnToState);
    }
    public static BlockReturningState builder(float hardness, float resistance, SoundType sound, Material material, BlockState returnToState) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of(material).sound(sound).strength(hardness, resistance).randomTicks();
        return new BlockReturningState(props, returnToState);
    }


    public BlockReturningState(BlockBehaviour.Properties props, BlockState returnToState) {
        super(props);
        this.returnState = returnToState;
        this.registerDefaultState(this.stateDefinition.any().setValue(REVERTS, Boolean.FALSE));
    }

    @Override
    public void tick(@NotNull BlockState state, ServerLevel worldIn, @NotNull BlockPos pos, @NotNull RandomSource rand) {
        if (!worldIn.isClientSide) {
            if (!worldIn.isAreaLoaded(pos, 3))
                return;
            if (state.getValue(REVERTS) && rand.nextInt(3) == 0) {
                worldIn.setBlockAndUpdate(pos, returnState);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(REVERTS);
    }
}
