package ironcrushers.tileentity;

import ironcrushers.config.GoldCrusherConfig;
import ironcrushers.container.ContainerGoldCrusher;
import ironcrushers.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;

public class TileEntityGoldCrusher extends TileEntityIronCrusherBase {
    public TileEntityGoldCrusher() {
        super(ModBlocks.GOLD_CRUSHER_TYPE);
    }

    @Override
    public int getCookTime() {
        return GoldCrusherConfig.SPEED.get();
    }

    @Override
    public String IgetName() {
        return "container.gold_crusher";
    }

    @Override
    public Container IcreateMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerGoldCrusher(i, world, pos, playerInventory, playerEntity, this.fields);
    }
}
