package ironcrushers.container;

import ironcrushers.tileentity.TileEntityIronCrusherBase;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotIronCrusherFuel extends Slot {

    TileEntityIronCrusherBase te;

    public SlotIronCrusherFuel(TileEntityIronCrusherBase te, int slotIndex, int xPosition, int yPosition) {
        super(te, slotIndex, xPosition, yPosition);
        this.te = te;
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(ItemStack stack) {
        return te.getItemBurnTime(stack) > 0;

    }

}
