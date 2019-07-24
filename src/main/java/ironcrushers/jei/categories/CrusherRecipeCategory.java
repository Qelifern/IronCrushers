package ironcrushers.jei.categories;


import ironcrushers.jei.IronCrushersJEIPlugin;
import ironcrushers.jei.recipes.CrusherRecipe;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.util.ResourceLocation;

public class CrusherRecipeCategory extends CrusherBaseRecipeCategory<CrusherRecipe> {


	public CrusherRecipeCategory(IGuiHelper guiHelper) {
		super(guiHelper);
	}

	@Override
	public ResourceLocation getUid() {
		return IronCrushersJEIPlugin.CRUSHING;
	}

    @Override
    public Class getRecipeClass() {
        return CrusherRecipe.class;
    }
}
