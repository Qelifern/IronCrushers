package ironcrushers.tileentity;

import ironcrushers.config.ObsidianCrusherConfig;
import ironcrushers.container.ContainerObsidianCrusher;
import ironcrushers.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class TileEntityObsidianCrusher extends TileEntityIronCrusherBase {
    public TileEntityObsidianCrusher() {
        super(ModBlocks.OBSIDIAN_CRUSHER_TYPE);
    }

    @Override
    public int getCookTime() {
        return ObsidianCrusherConfig.SPEED.get();
    }

    @Override
    public String IgetName() {
        return "container.obsidian_crusher";
    }

    @Override
    public Container IcreateMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerObsidianCrusher(i, world, pos, playerInventory, playerEntity, this.fields);
    }
}
