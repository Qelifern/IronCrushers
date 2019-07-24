package ironcrushers.container;

import ironcrushers.recipe.CrusherRecipes;
import ironcrushers.tileentity.TileEntityIronCrusherBase;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotIronCrusherInput extends Slot {


    public SlotIronCrusherInput(TileEntityIronCrusherBase te, int slotIndex, int xPosition, int yPosition) {
        super(te, slotIndex, xPosition, yPosition);
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(ItemStack stack) {
        return !CrusherRecipes.getInstance().getResult(stack).isEmpty();
    }

}
