package net.blay09.mods.cookingforblockheads.tile;

import net.blay09.mods.cookingforblockheads.CookingForBlockheads;
import net.blay09.mods.cookingforblockheads.block.ModBlocks;

public class TileCounterOak extends TileCounter {

    public String getUnlocalizedName() {
        return CookingForBlockheads.MOD_ID + ":counter_oak";
    }

    public TileCounterOak getBaseTile() {
        if (!hasWorld()) {
            return this;
        }

        if (world.getBlockState(pos.down()).getBlock() == ModBlocks.counterOak) {
            TileCounterOak baseTile = (TileCounterOak) world.getTileEntity(pos.down());
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