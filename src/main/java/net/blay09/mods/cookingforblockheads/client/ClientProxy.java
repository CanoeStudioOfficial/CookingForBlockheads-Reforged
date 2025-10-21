package net.blay09.mods.cookingforblockheads.client;

import net.blay09.mods.cookingforblockheads.CommonProxy;
import net.blay09.mods.cookingforblockheads.CookingForBlockheads;
import net.blay09.mods.cookingforblockheads.block.BlockFridge;
import net.blay09.mods.cookingforblockheads.block.ModBlocks;
import net.blay09.mods.cookingforblockheads.client.render.FridgeRenderer;
import net.blay09.mods.cookingforblockheads.client.render.MilkJarRenderer;
import net.blay09.mods.cookingforblockheads.client.render.OvenRenderer;
import net.blay09.mods.cookingforblockheads.client.render.SinkRenderer;
import net.blay09.mods.cookingforblockheads.regsiter.ModBlockColors;
import net.blay09.mods.cookingforblockheads.regsiter.ModTileEntityRenderers;
import net.blay09.mods.cookingforblockheads.regsiter.ModelBakeHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class ClientProxy extends CommonProxy {

    public static final TextureAtlasSprite[] ovenToolIcons = new TextureAtlasSprite[4];

    public static final TextureAtlasSprite[] ovenToolTextures = new TextureAtlasSprite[8];



    public ClientProxy() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ModelBakeHandler());
    }

    @Override
    public void registerModels() {
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

        DefaultStateMapper ignorePropertiesStateMapper = new DefaultStateMapper() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                ResourceLocation location = state.getBlock().getRegistryName();
                return new ModelResourceLocation(location != null ? location.toString() : "", "normal");
            }
        };

        ModTileEntityRenderers.registerTileEntityRenderers();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        ModBlockColors.registerBlockColorHandlers();
    }

    @Override
    public List<String> getItemTooltip(ItemStack itemStack, EntityPlayer player) {
        return itemStack.getTooltip(player, ITooltipFlag.TooltipFlags.NORMAL);
    }

    @SubscribeEvent
    public void registerIcons(TextureStitchEvent.Pre event) {
        ovenToolIcons[0] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "items/slot_bakeware"));
        ovenToolIcons[1] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "items/slot_pot"));
        ovenToolIcons[2] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "items/slot_saucepan"));
        ovenToolIcons[3] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "items/slot_skillet"));

        ovenToolTextures[0] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "blocks/cooking_pot_bottom"));
        ovenToolTextures[1] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "blocks/cooking_pot_parts"));
        ovenToolTextures[2] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "blocks/cooking_pot_side"));
        ovenToolTextures[3] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "blocks/cooking_pot_top"));

        ovenToolTextures[4] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "blocks/skillet_top"));
        ovenToolTextures[5] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "blocks/skillet_side"));
        ovenToolTextures[6] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "blocks/skillet_bottom"));

        ovenToolTextures[7] = event.getMap().registerSprite(new ResourceLocation(CookingForBlockheads.MOD_ID, "blocks/bakeware"));
    }

    @SubscribeEvent
    public void onModelBake(ModelBakeEvent event) {
        try {
            IModel model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/milk_jar_liquid"));
            MilkJarRenderer.modelMilkLiquid = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

            model = ModelLoaderRegistry.getModel(new ResourceLocation(CookingForBlockheads.MOD_ID, "block/sink_liquid"));
            SinkRenderer.modelSinkLiquid = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, ModelLoader.defaultTextureGetter());

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

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
