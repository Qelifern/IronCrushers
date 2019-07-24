package ironcrushers.blocks;

import ironcrushers.Main;
import ironcrushers.tileentity.TileEntityDiamondCrusher;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockDiamondCrusher extends BlockIronCrusherBase {

    public static final ResourceLocation DIAMOND_CRUSHER = new ResourceLocation(Main.MOD_ID, "diamond_crusher");

    public BlockDiamondCrusher(Properties properties) {
        super(properties);
        this.setRegistryName(DIAMOND_CRUSHER);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityDiamondCrusher();
    }
}
