package ironcrushers.init;

import ironcrushers.Main;
import ironcrushers.blocks.*;
import ironcrushers.items.ItemDust;
import ironcrushers.items.ItemEngine;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {


    @ObjectHolder("ironcrushers:combustion_engine")
    public static ItemEngine combustion_engine;

    @ObjectHolder("ironcrushers:gold_dust")
    public static ItemDust gold_dust;

    @ObjectHolder("ironcrushers:iron_dust")
    public static ItemDust iron_dust;


    public static void register(IForgeRegistry<Item> registry) {

        registry.register(new ItemDust(new Item.Properties().group(Main.itemGroup)).setRegistryName("gold_dust"));
        registry.register(new ItemDust(new Item.Properties().group(Main.itemGroup)).setRegistryName("iron_dust"));

        registry.register(new BlockItem(ModBlocks.iron_crusher, new Item.Properties().group(Main.itemGroup)).setRegistryName(BlockIronCrusher.IRON_CRUSHER));
        registry.register(new BlockItem(ModBlocks.gold_crusher, new Item.Properties().group(Main.itemGroup)).setRegistryName(BlockGoldCrusher.GOLD_CRUSHER));
        registry.register(new BlockItem(ModBlocks.diamond_crusher, new Item.Properties().group(Main.itemGroup)).setRegistryName(BlockDiamondCrusher.DIAMOND_CRUSHER));
        registry.register(new BlockItem(ModBlocks.emerald_crusher, new Item.Properties().group(Main.itemGroup)).setRegistryName(BlockEmeraldCrusher.EMERALD_CRUSHER));
        registry.register(new BlockItem(ModBlocks.obsidian_crusher, new Item.Properties().group(Main.itemGroup)).setRegistryName(BlockObsidianCrusher.OBSIDIAN_CRUSHER));
        registry.register(new BlockItem(ModBlocks.copper_crusher, new Item.Properties().group(Main.itemGroup)).setRegistryName(BlockCopperCrusher.COPPER_CRUSHER));
        registry.register(new BlockItem(ModBlocks.silver_crusher, new Item.Properties().group(Main.itemGroup)).setRegistryName(BlockSilverCrusher.SILVER_CRUSHER));

        registry.register(new ItemEngine(new Item.Properties().group(Main.itemGroup).maxStackSize(1)).setRegistryName("combustion_engine"));



        Main.LOGGER.info("IronCrushers Items Registry Done.");
    }

}
