package ironcrushers.proxy;

import ironcrushers.Main;
import ironcrushers.gui.*;
import ironcrushers.init.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy implements IProxy {

	@Override
	public void setup(FMLCommonSetupEvent event) {
		OBJLoader.INSTANCE.addDomain(Main.MOD_ID);
		ScreenManager.registerFactory(ModBlocks.IRON_CRUSHER_CONTAINER, GuiIronCrusher::new);
		ScreenManager.registerFactory(ModBlocks.GOLD_CRUSHER_CONTAINER, GuiGoldCrusher::new);
		ScreenManager.registerFactory(ModBlocks.DIAMOND_CRUSHER_CONTAINER, GuiDiamondCrusher::new);
		ScreenManager.registerFactory(ModBlocks.EMERALD_CRUSHER_CONTAINER, GuiEmeraldCrusher::new);
		ScreenManager.registerFactory(ModBlocks.OBSIDIAN_CRUSHER_CONTAINER, GuiObsidianCrusher::new);
		ScreenManager.registerFactory(ModBlocks.COPPER_CRUSHER_CONTAINER, GuiCopperCrusher::new);
		ScreenManager.registerFactory(ModBlocks.SILVER_CRUSHER_CONTAINER, GuiSilverCrusher::new);
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}



}
