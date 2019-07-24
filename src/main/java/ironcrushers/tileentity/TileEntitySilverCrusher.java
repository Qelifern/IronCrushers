package ironcrushers.tileentity;

import ironcrushers.config.SilverCrusherConfig;
import ironcrushers.container.ContainerSilverCrusher;
import ironcrushers.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class TileEntitySilverCrusher extends TileEntityIronCrusherBase {
    public TileEntitySilverCrusher() {
        super(ModBlocks.SILVER_CRUSHER_TYPE);
    }

    @Override
    public int getCookTime() {
        return SilverCrusherConfig.SPEED.get();
    }

    @Override
    public String IgetName() {
        return "container.silver_crusher";
    }

    @Override
    public Container IcreateMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerSilverCrusher(i, world, pos, playerInventory, playerEntity, this.fields);
    }
}
