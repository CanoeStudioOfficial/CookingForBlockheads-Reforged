package net.blay09.mods.cookingforblockheads.tile.vanila;

import net.blay09.mods.cookingforblockheads.CookingForBlockheads;
import net.blay09.mods.cookingforblockheads.block.ModBlocks;
import net.blay09.mods.cookingforblockheads.tile.TileCabinet;

public class TileCabinetDarkOak extends TileCabinet {
    @Override
    public String getUnlocalizedName() {
        return CookingForBlockheads.MOD_ID + ":cabinet_darkoak";
    }

    public TileCabinetDarkOak getBaseTile() {
        if (!hasWorld()) {
            return this;
        }

        if (world.getBlockState(pos.down()).getBlock() == ModBlocks.cabinetDarkOak) {
            TileCabinetDarkOak baseTile = (TileCabinetDarkOak) world.getTileEntity(pos.down());
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
