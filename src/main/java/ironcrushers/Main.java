package ironcrushers;


import ironcrushers.config.Config;
import ironcrushers.config.UpdateCheckerConfig;
import ironcrushers.init.ModBlocks;
import ironcrushers.init.ModItems;
import ironcrushers.proxy.ClientProxy;
import ironcrushers.proxy.IProxy;
import ironcrushers.proxy.ServerProxy;
import ironcrushers.update.UpdateChecker;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MOD_ID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class Main
{
    public static final String MOD_ID = "ironcrushers";
    public static final String VERSION = "100";
    public static final String MC_VERSION = "1.14.3";

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ItemGroup itemGroup = new ItemGroup(Main.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.iron_crusher);
        }
    };

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Main() {

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);


        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers-client.toml"));
        Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers.toml"));

        if (UpdateCheckerConfig.UPDATE.get()) {
            new UpdateChecker();
        } else {
            Main.LOGGER.warn("You have disabled Iron Crushers's Update Checker, to re-enable change the value in .minecraft->config->ironfurnaces-client.toml to 'true'.");
        }

    }

    @SubscribeEvent
    public static void config(ConfigChangedEvent.OnConfigChangedEvent event) {
        Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers-client.toml"));
        Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers.toml"));
    }

    @SubscribeEvent
    public static void config(ModConfig.ConfigReloading event) {
        Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers-client.toml"));
        Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers.toml"));
    }

    @SubscribeEvent
    public static void config(ModConfig.ModConfigEvent event) {
        Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers-client.toml"));
        Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers.toml"));
    }

    @SubscribeEvent
    public static void config(ModConfig.Loading event) {
        Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers-client.toml"));
        Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("ironcrushers.toml"));
    }

    @SubscribeEvent
    public static void registerTiles(RegistryEvent.Register<TileEntityType<?>> event) {
        ModBlocks.registerTiles(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ModBlocks.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ModItems.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
        ModBlocks.registerContainers(event.getRegistry());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.log(Level.INFO, "HELLO WORLD");
        proxy.setup(event);
    }

}
