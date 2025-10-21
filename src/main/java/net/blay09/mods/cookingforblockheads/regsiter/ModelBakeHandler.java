package net.blay09.mods.cookingforblockheads.regsiter;

import net.blay09.mods.cookingforblockheads.block.BlockCabinet;
import net.blay09.mods.cookingforblockheads.block.BlockCounter;
import net.blay09.mods.cookingforblockheads.block.ModBlocks;
import net.blay09.mods.cookingforblockheads.block.vanilla.*;
import net.blay09.mods.cookingforblockheads.client.render.CabinetRenderer;
import net.blay09.mods.cookingforblockheads.client.render.CounterRenderer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBakeHandler {

    private final DefaultStateMapper dummyStateMapper = new DefaultStateMapper();

    @SubscribeEvent
    public void onModelBake(ModelBakeEvent event) {
        CounterRenderer.models = new IBakedModel[4];
        CounterRenderer.modelsFlipped = new IBakedModel[4];
        CabinetRenderer.models = new IBakedModel[4];
        CabinetRenderer.modelsFlipped = new IBakedModel[4];
        IBlockState defaultState = ModBlocks.counter.getDefaultState();
        IBlockState state = defaultState.withProperty(BlockCounter.PASS, BlockCounter.ModelPass.DOOR);
        IBlockState flippedState = defaultState.withProperty(BlockCounter.PASS, BlockCounter.ModelPass.DOOR_FLIPPED);
        for (int i = 0; i < 4; i++) {
            EnumFacing facing = EnumFacing.byHorizontalIndex(i);
            CounterRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounter.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounter.FACING, facing).getProperties())));
            CounterRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounter.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounter.FACING, facing).getProperties())));

            CabinetRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinet.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounter.FACING, facing).getProperties())));
            CabinetRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinet.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounter.FACING, facing).getProperties())));
        }

        CounterRenderer.models = new IBakedModel[4];
        CounterRenderer.modelsFlipped = new IBakedModel[4];
        CabinetRenderer.models = new IBakedModel[4];
        CabinetRenderer.modelsFlipped = new IBakedModel[4];
        defaultState = ModBlocks.counterOak.getDefaultState();
        state = defaultState.withProperty(BlockCounterOak.PASS, BlockCounterOak.ModelPass.DOOR);
        flippedState = defaultState.withProperty(BlockCounterOak.PASS, BlockCounterOak.ModelPass.DOOR_FLIPPED);
        for (int i = 0; i < 4; i++) {
            EnumFacing facing = EnumFacing.byHorizontalIndex(i);
            CounterRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterOak.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterOak.FACING, facing).getProperties())));
            CounterRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterOak.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterOak.FACING, facing).getProperties())));

            CabinetRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetOak.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterOak.FACING, facing).getProperties())));
            CabinetRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetOak.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterOak.FACING, facing).getProperties())));
        }

        CounterRenderer.models = new IBakedModel[4];
        CounterRenderer.modelsFlipped = new IBakedModel[4];
        CabinetRenderer.models = new IBakedModel[4];
        CabinetRenderer.modelsFlipped = new IBakedModel[4];
        defaultState = ModBlocks.counterSpruce.getDefaultState();
        state = defaultState.withProperty(BlockCounterSpruce.PASS, BlockCounterSpruce.ModelPass.DOOR);
        flippedState = defaultState.withProperty(BlockCounterSpruce.PASS, BlockCounterSpruce.ModelPass.DOOR_FLIPPED);
        for (int i = 0; i < 4; i++) {
            EnumFacing facing = EnumFacing.byHorizontalIndex(i);
            CounterRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterSpruce.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterSpruce.FACING, facing).getProperties())));
            CounterRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterSpruce.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterSpruce.FACING, facing).getProperties())));

            CabinetRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetSpruce.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterSpruce.FACING, facing).getProperties())));
            CabinetRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetSpruce.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterSpruce.FACING, facing).getProperties())));
        }

        CounterRenderer.models = new IBakedModel[4];
        CounterRenderer.modelsFlipped = new IBakedModel[4];
        CabinetRenderer.models = new IBakedModel[4];
        CabinetRenderer.modelsFlipped = new IBakedModel[4];
        defaultState = ModBlocks.counterBirch.getDefaultState();
        state = defaultState.withProperty(BlockCounterBirch.PASS, BlockCounterBirch.ModelPass.DOOR);
        flippedState = defaultState.withProperty(BlockCounterBirch.PASS, BlockCounterBirch.ModelPass.DOOR_FLIPPED);
        for (int i = 0; i < 4; i++) {
            EnumFacing facing = EnumFacing.byHorizontalIndex(i);
            CounterRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterBirch.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterBirch.FACING, facing).getProperties())));
            CounterRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterBirch.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterBirch.FACING, facing).getProperties())));

            CabinetRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetBirch.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterBirch.FACING, facing).getProperties())));
            CabinetRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetBirch.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterBirch.FACING, facing).getProperties())));
        }

        CounterRenderer.models = new IBakedModel[4];
        CounterRenderer.modelsFlipped = new IBakedModel[4];
        CabinetRenderer.models = new IBakedModel[4];
        CabinetRenderer.modelsFlipped = new IBakedModel[4];
        defaultState = ModBlocks.counterJungle.getDefaultState();
        state = defaultState.withProperty(BlockCounterJungle.PASS, BlockCounterJungle.ModelPass.DOOR);
        flippedState = defaultState.withProperty(BlockCounterJungle.PASS, BlockCounterJungle.ModelPass.DOOR_FLIPPED);
        for (int i = 0; i < 4; i++) {
            EnumFacing facing = EnumFacing.byHorizontalIndex(i);
            CounterRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterJungle.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterJungle.FACING, facing).getProperties())));
            CounterRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterJungle.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterJungle.FACING, facing).getProperties())));

            CabinetRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetJungle.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterJungle.FACING, facing).getProperties())));
            CabinetRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetJungle.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterJungle.FACING, facing).getProperties())));
        }

        CounterRenderer.models = new IBakedModel[4];
        CounterRenderer.modelsFlipped = new IBakedModel[4];
        CabinetRenderer.models = new IBakedModel[4];
        CabinetRenderer.modelsFlipped = new IBakedModel[4];
        defaultState = ModBlocks.counterAcacia.getDefaultState();
        state = defaultState.withProperty(BlockCounterAcacia.PASS, BlockCounterAcacia.ModelPass.DOOR);
        flippedState = defaultState.withProperty(BlockCounterAcacia.PASS, BlockCounterAcacia.ModelPass.DOOR_FLIPPED);
        for (int i = 0; i < 4; i++) {
            EnumFacing facing = EnumFacing.byHorizontalIndex(i);
            CounterRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterAcacia.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterAcacia.FACING, facing).getProperties())));
            CounterRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterAcacia.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterAcacia.FACING, facing).getProperties())));

            CabinetRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetAcacia.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterAcacia.FACING, facing).getProperties())));
            CabinetRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetAcacia.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterAcacia.FACING, facing).getProperties())));
        }

        CounterRenderer.models = new IBakedModel[4];
        CounterRenderer.modelsFlipped = new IBakedModel[4];
        CabinetRenderer.models = new IBakedModel[4];
        CabinetRenderer.modelsFlipped = new IBakedModel[4];
        defaultState = ModBlocks.counterDarkOak.getDefaultState();
        state = defaultState.withProperty(BlockCounterDarkOak.PASS, BlockCounterDarkOak.ModelPass.DOOR);
        flippedState = defaultState.withProperty(BlockCounterDarkOak.PASS, BlockCounterDarkOak.ModelPass.DOOR_FLIPPED);
        for (int i = 0; i < 4; i++) {
            EnumFacing facing = EnumFacing.byHorizontalIndex(i);
            CounterRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterDarkOak.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterDarkOak.FACING, facing).getProperties())));
            CounterRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCounterDarkOak.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterDarkOak.FACING, facing).getProperties())));

            CabinetRenderer.models[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetDarkOak.registryName, dummyStateMapper.getPropertyString(state.withProperty(BlockCounterDarkOak.FACING, facing).getProperties())));
            CabinetRenderer.modelsFlipped[i] = event.getModelRegistry().getObject(new ModelResourceLocation(BlockCabinetDarkOak.registryName, dummyStateMapper.getPropertyString(flippedState.withProperty(BlockCounterDarkOak.FACING, facing).getProperties())));
        }
    }
}