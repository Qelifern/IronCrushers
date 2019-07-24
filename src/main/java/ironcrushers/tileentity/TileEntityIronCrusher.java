package ironcrushers.tileentity;

import ironcrushers.config.IronCrusherConfig;
import ironcrushers.container.ContainerIronCrusher;
import ironcrushers.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class TileEntityIronCrusher extends TileEntityIronCrusherBase {
    public TileEntityIronCrusher() {
        super(ModBlocks.IRON_CRUSHER_TYPE);
    }

    @Override
    public int getCookTime() {
        return IronCrusherConfig.SPEED.get();
    }

    @Override
    public String IgetName() {
        return "container.iron_crusher";
    }

    @Override
    public Container IcreateMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerIronCrusher(i, world, pos, playerInventory, playerEntity, this.fields);
    }
}
