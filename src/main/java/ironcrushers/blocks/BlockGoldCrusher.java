package ironcrushers.blocks;

import ironcrushers.Main;
import ironcrushers.tileentity.TileEntityGoldCrusher;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockGoldCrusher extends BlockIronCrusherBase {

    public static final ResourceLocation GOLD_CRUSHER = new ResourceLocation(Main.MOD_ID, "gold_crusher");

    public BlockGoldCrusher(Properties properties) {
        super(properties);
        this.setRegistryName(GOLD_CRUSHER);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityGoldCrusher();
    }
}
