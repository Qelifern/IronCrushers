package ironcrushers.blocks;

import ironcrushers.Main;
import ironcrushers.tileentity.TileEntityIronCrusher;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockIronCrusher extends BlockIronCrusherBase {

    public static final ResourceLocation IRON_CRUSHER = new ResourceLocation(Main.MOD_ID, "iron_crusher");

    public BlockIronCrusher(Block.Properties properties) {
        super(properties);
        this.setRegistryName(IRON_CRUSHER);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityIronCrusher();
    }
}
