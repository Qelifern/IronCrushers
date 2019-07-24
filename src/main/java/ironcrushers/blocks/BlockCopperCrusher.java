package ironcrushers.blocks;

import ironcrushers.Main;
import ironcrushers.tileentity.TileEntityCopperCrusher;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockCopperCrusher extends BlockIronCrusherBase {

    public static final ResourceLocation COPPER_CRUSHER = new ResourceLocation(Main.MOD_ID, "copper_crusher");

    public BlockCopperCrusher(Properties properties) {
        super(properties);
        this.setRegistryName(COPPER_CRUSHER);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityCopperCrusher();
    }
}
