package net.blay09.mods.cookingforblockheads.tile.vanila;

import net.blay09.mods.cookingforblockheads.CookingForBlockheads;
import net.blay09.mods.cookingforblockheads.block.ModBlocks;
import net.blay09.mods.cookingforblockheads.tile.TileCabinet;

public class TileCabinetBirch extends TileCabinet {
    @Override
    public String getUnlocalizedName() {
        return CookingForBlockheads.MOD_ID + ":cabinet_birch";
    }

    public TileCabinetBirch getBaseTile() {
        if (!hasWorld()) {
            return this;
        }

        if (world.getBlockState(pos.down()).getBlock() == ModBlocks.cabinetBirch) {
            TileCabinetBirch baseTile = (TileCabinetBirch) world.getTileEntity(pos.down());
            if (baseTile != null) {
                return baseTile;
            }
        }

        return this;
    }

    @Override
    public boolean isWood() {
        return true;
    }
}
