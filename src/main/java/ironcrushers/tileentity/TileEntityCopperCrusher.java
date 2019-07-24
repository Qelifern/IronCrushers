package ironcrushers.tileentity;

import ironcrushers.config.CopperCrusherConfig;
import ironcrushers.container.ContainerCopperCrusher;
import ironcrushers.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class TileEntityCopperCrusher extends TileEntityIronCrusherBase {
    public TileEntityCopperCrusher() {
        super(ModBlocks.COPPER_CRUSHER_TYPE);
    }

    @Override
    public int getCookTime() {
        return CopperCrusherConfig.SPEED.get();
    }

    @Override
    public String IgetName() {
        return "container.copper_crusher";
    }

    @Override
    public Container IcreateMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerCopperCrusher(i, world, pos, playerInventory, playerEntity, this.fields);
    }
}
