package net.blay09.mods.cookingforblockheads.client;

import net.blay09.mods.cookingforblockheads.CommonProxy;
import net.blay09.mods.cookingforblockheads.CookingForBlockheads;
import net.blay09.mods.cookingforblockheads.block.*;
import net.blay09.mods.cookingforblockheads.block.vanilla.*;
import net.blay09.mods.cookingforblockheads.client.render.*;
import net.blay09.mods.cookingforblockheads.tile.*;
import net.blay09.mods.cookingforblockheads.tile.vanila.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.function.Function;

public class ClientProxy extends CommonProxy {

    public static final TextureAtlasSprite[] ovenToolIcons = new TextureAtlasSprite[4];
    public static final TextureAtlasSprite[] ovenToolTextures = new TextureAtlasSprite[8];
    private final DefaultStateMapper dummyStateMapper = new DefaultStateMapper();

    public ClientProxy() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void registerModels() {
        // Fridge state mapper
        ModelLoader.setCustomStateMapper(ModBlocks.fridge, new DefaultStateMapper() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                if (state.getValue(BlockFridge.TYPE) == BlockFridge.FridgeType.LARGE) {
                    return new ModelResourceLocation(CookingForBlockheads.MOD_ID + ":fridge_large", getPropertyString(state.getProperties()));
                } else if (state.getValue(BlockFridge.TYPE) == BlockFridge.FridgeType.INVISIBLE) {
                    return new ModelResourceLocation(CookingForBlockheads.MOD_ID + ":fridge_invisible", getPropertyString(state.getProperties()));
                }
                return super.getModelResourceLocation(state);
            }
        });

        // Tile entity renderers
        registerTileEntityRenderers();
    }

    private void registerTileEntityRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileToolRack.class, new ToolRackRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCookingTable.class, new CookingTableRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileOven.class, new OvenRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileFridge.class, new FridgeRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMilkJar.class, new MilkJarRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCowJar.class, new CowJarRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileToaster.class, new ToasterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSpiceRack.class, new SpiceRackRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounter.class, new CounterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSink.class, new SinkRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileFruitBasket.class, new FruitBasketRenderer());

        // Wood-type specific renderers
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterOak.class, new CounterRendererOak());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetOak.class, new CabinetRendererOak());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterSpruce.class, new CounterRendererSpruce());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetSpruce.class, new CabinetRendererSpruce());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterBirch.class, new CounterRendererBirch());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetBirch.class, new CabinetRendererBirch());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterJungle.class, new CounterRendererJungle());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetJungle.class, new CabinetRendererJungle());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterAcacia.class, new CounterRendererAcacia());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetAcacia.class, new CabinetRendererAcacia());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterDarkOak.class, new CounterRendererDarkOak());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetDarkOak.class, new CabinetRendererDarkOak());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        registerBlockColorHandlers();
    }

    private void registerBlockColorHandlers() {
        registerBlockColorHandler(ModBlocks.fridge, (tileEntity) -> {
            if (tileEntity instanceof TileFridge) {
                return ((TileFridge) tileEntity).getBaseFridge().getFridgeColor().getColorValue();
            }
            return 0xFFFFFFFF;
        });

        registerBlockColorHandler(ModBlocks.cookingTable, (tileEntity) -> {
            if (tileEntity instanceof TileCookingTable) {
                return ((TileCookingTable) tileEntity).getBaseTile().getDyedColor().getColorValue();
            }
            return 0xFFFFFFFF;
        });

        registerBlockColorHandler(ModBlocks.counter, (tileEntity) -> {
            if (tileEntity instanceof TileCounter) {
                return ((TileCounter) tileEntity).getBaseTile().getDyedColor().getColorValue();
            }
            return 0xFFFFFFFF;
        });

        registerBlockColorHandler(ModBlocks.cabinet, (tileEntity) -> {
            if (tileEntity instanceof TileCabinet) {
                return ((TileCabinet) tileEntity).getBaseTile().getDyedColor().getColorValue();
            }
            return 0xFFFFFFFF;
        });

        registerBlockColorHandler(ModBlocks.corner, (tileEntity) -> {
            if (tileEntity instanceof TileCorner) {
                return ((TileCorner) tileEntity).getBaseTile().getDyedColor().getColorValue();
            }
            return 0xFFFFFFFF;
        });

        registerBlockColorHandler(ModBlocks.sink, (tileEntity) -> {
            if (tileEntity instanceof TileSink) {
                return ((TileSink) tileEntity).getBaseTile().getDyedColor().getColorValue();
            }
            return 0xFFFFFFFF;
        });
    }

    private void registerBlockColorHandler(Block block, Function<TileEntity, Integer> colorProvider) {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                TileEntity tileEntity = world.getTileEntity(pos);
                if (tileEntity != null) {
                    return colorProvider.apply(tileEntity);
                }
            }
            return 0xFFFFFFFF;
        }, block);
    }

    @Override
    public List<String> getItemTooltip(ItemStack itemStack, EntityPlayer player) {
        return itemStack.getTooltip(player, ITooltipFlag.TooltipFlags.NORMAL);
    }

    @SubscribeEvent
    public void registerIcons(TextureStitchEvent.Pre event) {
        // Oven tool icons
        ovenToolIcons[0] = registerSprite(event, "items/slot_bakeware");
        ovenToolIcons[1] = registerSprite(event, "items/slot_pot");
        ovenToolIcons[2] = registerSprite(event, "items/slot_saucepan");
        ovenToolIcons[3] = registerSprite(event, "items/slot_skillet");

        // Oven tool textures
        ovenToolTextures[0] = registerSprite(event, "blocks/cooking_pot_bottom");
        ovenToolTextures[1] = registerSprite(event, "blocks/cooking_pot_parts");
        ovenToolTextures[2] = registerSprite(event, "blocks/cooking_pot_side");
        ovenToolTextures[3] = registerSprite(event, "blocks/cooking_pot_top");
        ovenToolTextures[4] = registerSprite(event, "blocks/skillet_top");
        ovenToolTextures[5] = registerSprite(event, "blocks/skillet_side");
        ovenToolTextures[6] = registerSprite(event, "blocks/skillet_bottom");
        ovenToolTextures[7] = registerSprite(event, "blocks/bakeware");
    }

    private TextureAtlasSprite registerSprite(TextureStitchEvent.Pre event, String path) {
        return event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, path));
    }

    @SubscribeEvent
    public void onModelBake(ModelBakeEvent event) {
        try {
            bakeModels();
            setupWoodTypeModels(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bakeModels() throws Exception {
        // Common models
        IModel model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/milk_jar_liquid"));
        MilkJarRenderer.modelMilkLiquid = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/sink_liquid"));
        SinkRenderer.modelSinkLiquid = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        // Oven models
        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/oven_door"));
        OvenRenderer.modelDoor = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/oven_door_active"));
        OvenRenderer.modelDoorActive = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/oven_cooking_pot"));
        OvenRenderer.modelCookingPot = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/oven_cooking_skillet"));
        OvenRenderer.modelCookingSkillet = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/oven_cooking_saucepan"));
        OvenRenderer.modelCookingSaucepan = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/oven_cooking_bakeware"));
        OvenRenderer.modelCookingBakeware = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        // Fridge models
        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/fridge_door"));
        FridgeRenderer.modelDoor = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/fridge_door_flipped"));
        FridgeRenderer.modelDoorFlipped = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/fridge_large_door"));
        FridgeRenderer.modelDoorLarge = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/fridge_large_door_flipped"));
        FridgeRenderer.modelDoorLargeFlipped = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/fridge_door_handle"));
        FridgeRenderer.modelHandle = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

        model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/fridge_large_door_handle"));
        FridgeRenderer.modelHandleLarge = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());
    }

    private void setupWoodTypeModels(ModelBakeEvent event) {
        // Setup base counter and cabinet models
        setupCounterAndCabinetModels(event, ModBlocks.counter, ModBlocks.cabinet,
                BlockCounter.registryName, BlockCabinet.registryName,
                CounterRenderer.models, CounterRenderer.modelsFlipped,
                CabinetRenderer.models, CabinetRenderer.modelsFlipped);

        // Setup wood-type specific models using helper method
        setupWoodTypeModelGroup(event, ModBlocks.counterOak, ModBlocks.cabinetOak,
                BlockCounterOak.registryName, BlockCabinetOak.registryName,
                CounterRendererOak.models, CounterRendererOak.modelsFlipped,
                CabinetRendererOak.models, CabinetRendererOak.modelsFlipped);

        setupWoodTypeModelGroup(event, ModBlocks.counterSpruce, ModBlocks.cabinetSpruce,
                BlockCounterSpruce.registryName, BlockCabinetSpruce.registryName,
                CounterRendererSpruce.models, CounterRendererSpruce.modelsFlipped,
                CabinetRendererSpruce.models, CabinetRendererSpruce.modelsFlipped);

        setupWoodTypeModelGroup(event, ModBlocks.counterBirch, ModBlocks.cabinetBirch,
                BlockCounterBirch.registryName, BlockCabinetBirch.registryName,
                CounterRendererBirch.models, CounterRendererBirch.modelsFlipped,
                CabinetRendererBirch.models, CabinetRendererBirch.modelsFlipped);

        setupWoodTypeModelGroup(event, ModBlocks.counterJungle, ModBlocks.cabinetJungle,
                BlockCounterJungle.registryName, BlockCabinetJungle.registryName,
                CounterRendererJungle.models, CounterRendererJungle.modelsFlipped,
                CabinetRendererJungle.models, CabinetRendererJungle.modelsFlipped);

        setupWoodTypeModelGroup(event, ModBlocks.counterAcacia, ModBlocks.cabinetAcacia,
                BlockCounterAcacia.registryName, BlockCabinetAcacia.registryName,
                CounterRendererAcacia.models, CounterRendererAcacia.modelsFlipped,
                CabinetRendererAcacia.models, CabinetRendererAcacia.modelsFlipped);

        setupWoodTypeModelGroup(event, ModBlocks.counterDarkOak, ModBlocks.cabinetDarkOak,
                BlockCounterDarkOak.registryName, BlockCabinetDarkOak.registryName,
                CounterRendererDarkOak.models, CounterRendererDarkOak.modelsFlipped,
                CabinetRendererDarkOak.models, CabinetRendererDarkOak.modelsFlipped);
    }

    private void setupWoodTypeModelGroup(ModelBakeEvent event,
                                         Block counterBlock, Block cabinetBlock,
                                         ResourceLocation counterRegistryName, ResourceLocation cabinetRegistryName,
                                         IBakedModel[] counterModels, IBakedModel[] counterModelsFlipped,
                                         IBakedModel[] cabinetModels, IBakedModel[] cabinetModelsFlipped) {
        setupCounterAndCabinetModels(event, counterBlock, cabinetBlock,
                counterRegistryName, cabinetRegistryName,
                counterModels, counterModelsFlipped,
                cabinetModels, cabinetModelsFlipped);
    }

    private void setupCounterAndCabinetModels(ModelBakeEvent event, Block counterBlock, Block cabinetBlock,
                                              ResourceLocation counterRegistryName, ResourceLocation cabinetRegistryName,
                                              IBakedModel[] counterModels, IBakedModel[] counterModelsFlipped,
                                              IBakedModel[] cabinetModels, IBakedModel[] cabinetModelsFlipped) {
        // Initialize arrays
        counterModels = new IBakedModel[4];
        counterModelsFlipped = new IBakedModel[4];
        cabinetModels = new IBakedModel[4];
        cabinetModelsFlipped = new IBakedModel[4];

        // Get door states - this part needs to be adapted based on the actual block implementations
        IBlockState counterState = getDoorState(counterBlock);
        IBlockState counterFlippedState = getDoorFlippedState(counterBlock);
        IBlockState cabinetState = getDoorState(cabinetBlock);
        IBlockState cabinetFlippedState = getDoorFlippedState(cabinetBlock);

        for (int i = 0; i < 4; i++) {
            EnumFacing facing = EnumFacing.byHorizontalIndex(i);

            counterModels[i] = getBakedModel(event, counterRegistryName, counterState, facing);
            counterModelsFlipped[i] = getBakedModel(event, counterRegistryName, counterFlippedState, facing);

            cabinetModels[i] = getBakedModel(event, cabinetRegistryName, cabinetState, facing);
            cabinetModelsFlipped[i] = getBakedModel(event, cabinetRegistryName, cabinetFlippedState, facing);
        }
    }

    private IBlockState getDoorState(Block block) {
        // This is a simplified implementation - you'll need to adapt this based on your actual block properties
        return block.getDefaultState();
    }

    private IBlockState getDoorFlippedState(Block block) {
        // This is a simplified implementation - you'll need to adapt this based on your actual block properties
        return block.getDefaultState();
    }

    private IBakedModel getBakedModel(ModelBakeEvent event, ResourceLocation registryName, IBlockState state, EnumFacing facing) {
        ModelResourceLocation location = new ModelResourceLocation(registryName,
                dummyStateMapper.getPropertyString(state.withProperty(BlockCounter.FACING, facing).getProperties()));
        return event.getModelRegistry().getObject(location);
    }
}