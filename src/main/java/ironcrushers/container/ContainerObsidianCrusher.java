package ironcrushers.container;

import ironcrushers.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerObsidianCrusher extends ContainerIronCrusherBase {


    public ContainerObsidianCrusher(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
        super(ModBlocks.OBSIDIAN_CRUSHER_CONTAINER, windowId, world, pos, playerInventory, player);
    }

    public ContainerObsidianCrusher(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player, IIntArray fields) {
        super(ModBlocks.OBSIDIAN_CRUSHER_CONTAINER, windowId, world, pos, playerInventory, player, fields);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(IWorldPosCallable.of(te.getWorld(), te.getPos()), playerEntity, ModBlocks.obsidian_crusher);
    }
}
