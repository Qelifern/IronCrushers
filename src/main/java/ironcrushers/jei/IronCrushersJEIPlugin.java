package ironcrushers.jei;

import ironcrushers.Main;
import ironcrushers.gui.*;
import ironcrushers.init.ModBlocks;
import ironcrushers.jei.categories.CrusherRecipeCategory;
import ironcrushers.jei.makers.CrusherRecipeMaker;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
public class IronCrushersJEIPlugin implements IModPlugin {

    public static final ResourceLocation CRUSHING = new ResourceLocation("ironcrushers", "crushing");
    public static final ResourceLocation GUI_CRUSHER = new ResourceLocation("ironcrushers", "textures/gui/gui_vanilla.png");

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Main.MOD_ID, "plugin_ironcrushers");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.iron_crusher), CRUSHING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.gold_crusher), CRUSHING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.diamond_crusher), CRUSHING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.emerald_crusher), CRUSHING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.obsidian_crusher), CRUSHING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.copper_crusher), CRUSHING);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.silver_crusher), CRUSHING);

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registry) {
        registry.addRecipeClickArea(GuiIronCrusher.class, 79, 35, 24, 17, CRUSHING);
        registry.addRecipeClickArea(GuiGoldCrusher.class, 79, 35, 24, 17, CRUSHING);
        registry.addRecipeClickArea(GuiDiamondCrusher.class, 79, 35, 24, 17, CRUSHING);
        registry.addRecipeClickArea(GuiEmeraldCrusher.class, 79, 35, 24, 17, CRUSHING);
        registry.addRecipeClickArea(GuiObsidianCrusher.class, 79, 35, 24, 17, CRUSHING);
        registry.addRecipeClickArea(GuiCopperCrusher.class, 79, 35, 24, 17, CRUSHING);
        registry.addRecipeClickArea(GuiSilverCrusher.class, 79, 35, 24, 17, CRUSHING);

    }
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        final IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registry.addRecipeCategories(new CrusherRecipeCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();

        registry.addRecipes(CrusherRecipeMaker.getCrusherRecipes(jeiHelpers), CRUSHING);

    }

}