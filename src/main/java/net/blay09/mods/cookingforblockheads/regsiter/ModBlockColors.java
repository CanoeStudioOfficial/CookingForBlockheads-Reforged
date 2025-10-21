package net.blay09.mods.cookingforblockheads.regsiter;

import net.blay09.mods.cookingforblockheads.block.ModBlocks;
import net.blay09.mods.cookingforblockheads.tile.*;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModBlockColors {

    public static void registerBlockColorHandlers() {
        registerFridgeColorHandler();
        registerCookingTableColorHandler();
        registerCounterColorHandler();
        registerCabinetColorHandler();
        registerCornerColorHandler();
        registerSinkColorHandler();
    }

    private static void registerFridgeColorHandler() {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                TileEntity tileEntity = world.getTileEntity(pos);
                if (tileEntity instanceof TileFridge) {
                    TileFridge baseFridge = ((TileFridge) tileEntity).getBaseFridge();
                    return baseFridge.getFridgeColor().getColorValue();
                }
            }
            return 0xFFFFFFFF;
        }, ModBlocks.fridge);
    }

    private static void registerCookingTableColorHandler() {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                TileEntity tileEntity = world.getTileEntity(pos);
                if (tileEntity instanceof TileCookingTable) {
                    TileCookingTable tileBase = ((TileCookingTable) tileEntity).getBaseTile();
                    return tileBase.getDyedColor().getColorValue();
                }
            }
            return 0xFFFFFFFF;
        }, ModBlocks.cookingTable);
    }

    private static void registerCounterColorHandler() {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                TileEntity tileEntity = world.getTileEntity(pos);
                if (tileEntity instanceof TileCounter) {
                    TileCounter tileBase = ((TileCounter) tileEntity).getBaseTile();
                    return tileBase.getDyedColor().getColorValue();
                }
            }
            return 0xFFFFFFFF;
        }, ModBlocks.counter);
    }

    private static void registerCabinetColorHandler() {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                TileEntity tileEntity = world.getTileEntity(pos);
                if (tileEntity instanceof TileCabinet) {
                    TileCabinet tileBase = ((TileCabinet) tileEntity).getBaseTile();
                    return tileBase.getDyedColor().getColorValue();
                }
            }
            return 0xFFFFFFFF;
        }, ModBlocks.cabinet);
    }

    private static void registerCornerColorHandler() {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                TileEntity tileEntity = world.getTileEntity(pos);
                if (tileEntity instanceof TileCorner) {
                    TileCorner tileBase = ((TileCorner) tileEntity).getBaseTile();
                    return tileBase.getDyedColor().getColorValue();
                }
            }
            return 0xFFFFFFFF;
        }, ModBlocks.corner);
    }

    private static void registerSinkColorHandler() {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                TileEntity tileEntity = world.getTileEntity(pos);
                if (tileEntity instanceof TileSink) {
                    TileSink tileBase = ((TileSink) tileEntity).getBaseTile();
                    return tileBase.getDyedColor().getColorValue();
                }
            }
            return 0xFFFFFFFF;
        }, ModBlocks.sink);
    }
}