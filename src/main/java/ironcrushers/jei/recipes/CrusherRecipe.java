package ironcrushers.jei.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CrusherRecipe {
	/* Recipe */
	public List<ItemStack> inputs;
	public final ItemStack output;

	public CrusherRecipe(ItemStack input, ItemStack output) {
		List<ItemStack> inputList = new ArrayList<ItemStack>();
		inputList.add(input);
		this.inputs = inputList;
		this.output = output;
	}
}
