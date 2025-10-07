package net.blay09.mods.cookingforblockheads.tile.vanila;

import net.blay09.mods.cookingforblockheads.CookingForBlockheads;
import net.blay09.mods.cookingforblockheads.block.ModBlocks;
import net.blay09.mods.cookingforblockheads.tile.TileCabinet;

public class TileCabinetOak extends TileCabinet {
    @Override
    public String getUnlocalizedName() {
        return CookingForBlockheads.MOD_ID + ":cabinet_oak";
    }

    public TileCabinetOak getBaseTile() {
        if (!hasWorld()) {
            return this;
        }

        if (world.getBlockState(pos.down()).getBlock() == ModBlocks.cabinetOak) {
            TileCabinetOak baseTile = (TileCabinetOak) world.getTileEntity(pos.down());
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
