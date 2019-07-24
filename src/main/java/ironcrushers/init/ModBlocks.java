package ironcrushers.init;

import ironcrushers.Main;
import ironcrushers.blocks.*;
import ironcrushers.container.*;
import ironcrushers.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("ironcrushers:iron_crusher")
    public static BlockIronCrusher iron_crusher;

    @ObjectHolder("ironcrushers:iron_crusher")
    public static TileEntityType<TileEntityIronCrusher> IRON_CRUSHER_TYPE;

    @ObjectHolder("ironcrushers:iron_crusher")
    public static ContainerType<ContainerIronCrusher> IRON_CRUSHER_CONTAINER;

    @ObjectHolder("ironcrushers:gold_crusher")
    public static BlockGoldCrusher gold_crusher;

    @ObjectHolder("ironcrushers:gold_crusher")
    public static TileEntityType<TileEntityGoldCrusher> GOLD_CRUSHER_TYPE;

    @ObjectHolder("ironcrushers:gold_crusher")
    public static ContainerType<ContainerGoldCrusher> GOLD_CRUSHER_CONTAINER;

    @ObjectHolder("ironcrushers:diamond_crusher")
    public static BlockDiamondCrusher diamond_crusher;

    @ObjectHolder("ironcrushers:diamond_crusher")
    public static TileEntityType<TileEntityDiamondCrusher> DIAMOND_CRUSHER_TYPE;

    @ObjectHolder("ironcrushers:diamond_crusher")
    public static ContainerType<ContainerDiamondCrusher> DIAMOND_CRUSHER_CONTAINER;

    @ObjectHolder("ironcrushers:emerald_crusher")
    public static BlockEmeraldCrusher emerald_crusher;

    @ObjectHolder("ironcrushers:emerald_crusher")
    public static TileEntityType<TileEntityEmeraldCrusher> EMERALD_CRUSHER_TYPE;

    @ObjectHolder("ironcrushers:emerald_crusher")
    public static ContainerType<ContainerEmeraldCrusher> EMERALD_CRUSHER_CONTAINER;

    @ObjectHolder("ironcrushers:obsidian_crusher")
    public static BlockObsidianCrusher obsidian_crusher;

    @ObjectHolder("ironcrushers:obsidian_crusher")
    public static TileEntityType<TileEntityObsidianCrusher> OBSIDIAN_CRUSHER_TYPE;

    @ObjectHolder("ironcrushers:obsidian_crusher")
    public static ContainerType<ContainerObsidianCrusher> OBSIDIAN_CRUSHER_CONTAINER;

    @ObjectHolder("ironcrushers:copper_crusher")
    public static BlockCopperCrusher copper_crusher;

    @ObjectHolder("ironcrushers:copper_crusher")
    public static TileEntityType<TileEntityCopperCrusher> COPPER_CRUSHER_TYPE;

    @ObjectHolder("ironcrushers:copper_crusher")
    public static ContainerType<ContainerCopperCrusher> COPPER_CRUSHER_CONTAINER;

    @ObjectHolder("ironcrushers:silver_crusher")
    public static BlockSilverCrusher silver_crusher;

    @ObjectHolder("ironcrushers:silver_crusher")
    public static TileEntityType<TileEntitySilverCrusher> SILVER_CRUSHER_TYPE;

    @ObjectHolder("ironcrushers:silver_crusher")
    public static ContainerType<ContainerSilverCrusher> SILVER_CRUSHER_CONTAINER;


    public static void registerTiles(IForgeRegistry<TileEntityType<?>> registry) {
        registry.register(TileEntityType.Builder.create(TileEntityIronCrusher::new, ModBlocks.iron_crusher).build(null).setRegistryName("iron_crusher"));
        registry.register(TileEntityType.Builder.create(TileEntityGoldCrusher::new, ModBlocks.gold_crusher).build(null).setRegistryName("gold_crusher"));
        registry.register(TileEntityType.Builder.create(TileEntityDiamondCrusher::new, ModBlocks.diamond_crusher).build(null).setRegistryName("diamond_crusher"));
        registry.register(TileEntityType.Builder.create(TileEntityEmeraldCrusher::new, ModBlocks.emerald_crusher).build(null).setRegistryName("emerald_crusher"));
        registry.register(TileEntityType.Builder.create(TileEntityObsidianCrusher::new, ModBlocks.obsidian_crusher).build(null).setRegistryName("obsidian_crusher"));
        registry.register(TileEntityType.Builder.create(TileEntityCopperCrusher::new, ModBlocks.copper_crusher).build(null).setRegistryName("copper_crusher"));
        registry.register(TileEntityType.Builder.create(TileEntitySilverCrusher::new, ModBlocks.silver_crusher).build(null).setRegistryName("silver_crusher"));
        Main.LOGGER.info("IronCrushers TileEntities Registry Done.");

    }

    public static void register(IForgeRegistry<Block> registry) {
        registry.register(new BlockIronCrusher(Block.Properties.from(Blocks.IRON_BLOCK)));
        registry.register(new BlockGoldCrusher(Block.Properties.from(Blocks.GOLD_BLOCK)));
        registry.register(new BlockDiamondCrusher(Block.Properties.from(Blocks.DIAMOND_BLOCK)));
        registry.register(new BlockEmeraldCrusher(Block.Properties.from(Blocks.EMERALD_BLOCK)));
        registry.register(new BlockObsidianCrusher(Block.Properties.from(Blocks.OBSIDIAN)));
        registry.register(new BlockCopperCrusher(Block.Properties.from(Blocks.GOLD_BLOCK)));
        registry.register(new BlockSilverCrusher(Block.Properties.from(Blocks.IRON_BLOCK)));

        Main.LOGGER.info("IronCrushers Blocks Registry Done.");
    }

    public static void registerContainers(IForgeRegistry<ContainerType<?>> registry) {
        registry.register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerIronCrusher(windowId, Main.proxy.getClientWorld(), pos, inv, Main.proxy.getClientPlayer());
        }).setRegistryName("iron_crusher"));
        registry.register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerGoldCrusher(windowId, Main.proxy.getClientWorld(), pos, inv, Main.proxy.getClientPlayer());
        }).setRegistryName("gold_crusher"));
        registry.register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerDiamondCrusher(windowId, Main.proxy.getClientWorld(), pos, inv, Main.proxy.getClientPlayer());
        }).setRegistryName("diamond_crusher"));
        registry.register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerEmeraldCrusher(windowId, Main.proxy.getClientWorld(), pos, inv, Main.proxy.getClientPlayer());
        }).setRegistryName("emerald_crusher"));
        registry.register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerObsidianCrusher(windowId, Main.proxy.getClientWorld(), pos, inv, Main.proxy.getClientPlayer());
        }).setRegistryName("obsidian_crusher"));
        registry.register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerCopperCrusher(windowId, Main.proxy.getClientWorld(), pos, inv, Main.proxy.getClientPlayer());
        }).setRegistryName("copper_crusher"));
        registry.register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerSilverCrusher(windowId, Main.proxy.getClientWorld(), pos, inv, Main.proxy.getClientPlayer());
        }).setRegistryName("silver_crusher"));
        Main.LOGGER.info("IronCrushers Containers Registry Done.");
    }

}
