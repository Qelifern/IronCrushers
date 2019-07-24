package ironcrushers.blocks;

import ironcrushers.Main;
import ironcrushers.tileentity.TileEntitySilverCrusher;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockSilverCrusher extends BlockIronCrusherBase {

    public static final ResourceLocation SILVER_CRUSHER = new ResourceLocation(Main.MOD_ID, "silver_crusher");

    public BlockSilverCrusher(Properties properties) {
        super(properties);
        this.setRegistryName(SILVER_CRUSHER);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntitySilverCrusher();
    }
}
