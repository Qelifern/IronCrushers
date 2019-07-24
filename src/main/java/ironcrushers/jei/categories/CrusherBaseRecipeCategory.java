package ironcrushers.jei.categories;


import ironcrushers.init.ModBlocks;
import ironcrushers.jei.IronCrushersJEIPlugin;
import ironcrushers.jei.recipes.CrusherRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public abstract class CrusherBaseRecipeCategory<T extends CrusherRecipe> extends CrusherVariantCategory<T> {

	protected IDrawable background;
	protected IDrawable icon;
	protected String localizedName;
	protected final IDrawableAnimated arrow;

	public CrusherBaseRecipeCategory(IGuiHelper guiHelper) {
		super(guiHelper);
		this.background = guiHelper.createDrawable(IronCrushersJEIPlugin.GUI_CRUSHER, 0, 114, 82, 44);
		this.icon = guiHelper.createDrawableIngredient(new ItemStack(ModBlocks.iron_crusher));
		this.localizedName = I18n.format("crusher_recipes");
		this.arrow = guiHelper.drawableBuilder(IronCrushersJEIPlugin.GUI_CRUSHER, 82, 128, 24, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);

	}

	@Nonnull
	@Override
	public String getTitle() {
		return localizedName;
	}

	@Nonnull
	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Nonnull
	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setIngredients(T recipe, IIngredients ingredients) {
		ingredients.setInputs(VanillaTypes.ITEM, recipe.inputs);
		ingredients.setOutput(VanillaTypes.ITEM, recipe.output);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, T recipe, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(0, true, 0, 0);
		guiItemStacks.init(2, false, 60, 13);
		guiItemStacks.set(ingredients);
	}

	@Override
	public void draw(T recipe, double mouseX, double mouseY) {
		this.arrow.draw(24, 13);
	}

}
