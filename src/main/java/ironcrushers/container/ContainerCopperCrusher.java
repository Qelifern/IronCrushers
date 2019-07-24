package ironcrushers.container;

import ironcrushers.init.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerCopperCrusher extends ContainerIronCrusherBase {


    public ContainerCopperCrusher(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
        super(ModBlocks.COPPER_CRUSHER_CONTAINER, windowId, world, pos, playerInventory, player);
    }

    public ContainerCopperCrusher(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player, IIntArray fields) {
        super(ModBlocks.COPPER_CRUSHER_CONTAINER, windowId, world, pos, playerInventory, player, fields);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(IWorldPosCallable.of(te.getWorld(), te.getPos()), playerEntity, ModBlocks.copper_crusher);
    }
}
