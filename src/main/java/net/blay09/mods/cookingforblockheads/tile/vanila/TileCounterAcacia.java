package net.blay09.mods.cookingforblockheads.tile.vanila;

import net.blay09.mods.cookingforblockheads.CookingForBlockheads;
import net.blay09.mods.cookingforblockheads.block.ModBlocks;
import net.blay09.mods.cookingforblockheads.tile.TileCounter;

public class TileCounterAcacia extends TileCounter {

    public String getUnlocalizedName() {
        return CookingForBlockheads.MOD_ID + ":counter_acacia";
    }

    public TileCounterAcacia getBaseTile() {
        if (!hasWorld()) {
            return this;
        }

        if (world.getBlockState(pos.down()).getBlock() == ModBlocks.counterAcacia) {
            TileCounterAcacia baseTile = (TileCounterAcacia) world.getTileEntity(pos.down());
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