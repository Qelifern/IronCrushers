package ironcrushers.gui;

import ironcrushers.container.ContainerDiamondCrusher;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiDiamondCrusher extends GuiIronCrusherBase<ContainerDiamondCrusher> {


    public GuiDiamondCrusher(ContainerDiamondCrusher container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }


}
