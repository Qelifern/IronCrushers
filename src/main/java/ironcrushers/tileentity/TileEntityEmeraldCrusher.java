package ironcrushers.tileentity;

import ironcrushers.config.EmeraldCrusherConfig;
import ironcrushers.container.ContainerEmeraldCrusher;
import ironcrushers.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class TileEntityEmeraldCrusher extends TileEntityIronCrusherBase {
    public TileEntityEmeraldCrusher() {
        super(ModBlocks.EMERALD_CRUSHER_TYPE);
    }

    @Override
    public int getCookTime() {
        return EmeraldCrusherConfig.SPEED.get();
    }

    @Override
    public String IgetName() {
        return "container.emerald_crusher";
    }

    @Override
    public Container IcreateMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerEmeraldCrusher(i, world, pos, playerInventory, playerEntity, this.fields);
    }
}
