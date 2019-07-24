package ironcrushers.jei.makers;


import ironcrushers.jei.recipes.CrusherRecipe;
import ironcrushers.recipe.CrusherRecipes;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.helpers.IStackHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrusherRecipeMaker {

	private CrusherRecipeMaker() {

	}

	public static List<CrusherRecipe> getCrusherRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();
		CrusherRecipes crusherRecipes = CrusherRecipes.getInstance();
		Map<ItemStack, ItemStack> recipeMap = crusherRecipes.getRecipes();

		List<CrusherRecipe> recipes = new ArrayList<CrusherRecipe>();

		for (Map.Entry<ItemStack, ItemStack> entry : recipeMap.entrySet()) {
			ItemStack input = entry.getKey();
			ItemStack output = crusherRecipes.getResult(input);
			CrusherRecipe recipe = new CrusherRecipe(input, output);
			recipes.add(recipe);
		}

		return recipes;

	}

}
