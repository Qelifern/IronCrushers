package ironcrushers.blocks;

import ironcrushers.Main;
import ironcrushers.tileentity.TileEntityEmeraldCrusher;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockEmeraldCrusher extends BlockIronCrusherBase {

    public static final ResourceLocation EMERALD_CRUSHER = new ResourceLocation(Main.MOD_ID, "emerald_crusher");

    public BlockEmeraldCrusher(Properties properties) {
        super(properties);
        this.setRegistryName(EMERALD_CRUSHER);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityEmeraldCrusher();
    }
}
