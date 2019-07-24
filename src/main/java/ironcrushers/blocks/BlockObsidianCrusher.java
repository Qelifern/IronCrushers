package ironcrushers.blocks;

import ironcrushers.Main;
import ironcrushers.tileentity.TileEntityObsidianCrusher;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockObsidianCrusher extends BlockIronCrusherBase {

    public static final ResourceLocation OBSIDIAN_CRUSHER = new ResourceLocation(Main.MOD_ID, "obsidian_crusher");

    public BlockObsidianCrusher(Properties properties) {
        super(properties);
        this.setRegistryName(OBSIDIAN_CRUSHER);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityObsidianCrusher();
    }
}
