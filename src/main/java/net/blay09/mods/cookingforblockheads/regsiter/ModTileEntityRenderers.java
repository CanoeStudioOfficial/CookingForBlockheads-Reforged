package net.blay09.mods.cookingforblockheads.regsiter;

import net.blay09.mods.cookingforblockheads.client.render.*;
import net.blay09.mods.cookingforblockheads.tile.*;
import net.blay09.mods.cookingforblockheads.tile.vanila.*;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModTileEntityRenderers {

    public static void registerTileEntityRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileToolRack.class, new ToolRackRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCookingTable.class, new CookingTableRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileOven.class, new OvenRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileFridge.class, new FridgeRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMilkJar.class, new MilkJarRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCowJar.class, new CowJarRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileToaster.class, new ToasterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSpiceRack.class, new SpiceRackRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounter.class, new CounterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterOak.class, new CounterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterSpruce.class, new CounterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterBirch.class, new CounterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterJungle.class, new CounterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterAcacia.class, new CounterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounterDarkOak.class, new CounterRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinet.class, new CabinetRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetOak.class, new CabinetRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetSpruce.class, new CabinetRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetBirch.class, new CabinetRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetJungle.class, new CabinetRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetAcacia.class, new CabinetRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCabinetDarkOak.class, new CabinetRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSink.class, new SinkRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileFruitBasket.class, new FruitBasketRenderer());
    }
}