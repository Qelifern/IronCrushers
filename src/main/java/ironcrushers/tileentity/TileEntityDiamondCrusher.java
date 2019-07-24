package ironcrushers.tileentity;

import ironcrushers.config.DiamondCrusherConfig;
import ironcrushers.container.ContainerDiamondCrusher;
import ironcrushers.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class TileEntityDiamondCrusher extends TileEntityIronCrusherBase {
    public TileEntityDiamondCrusher() {
        super(ModBlocks.DIAMOND_CRUSHER_TYPE);
    }

    @Override
    public int getCookTime() {
        return DiamondCrusherConfig.SPEED.get();
    }

    @Override
    public String IgetName() {
        return "container.diamond_crusher";
    }

    @Override
    public Container IcreateMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerDiamondCrusher(i, world, pos, playerInventory, playerEntity, this.fields);
    }
}
