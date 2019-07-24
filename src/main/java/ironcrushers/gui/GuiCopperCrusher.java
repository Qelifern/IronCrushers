package ironcrushers.gui;

import ironcrushers.container.ContainerCopperCrusher;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiCopperCrusher extends GuiIronCrusherBase<ContainerCopperCrusher> {


    public GuiCopperCrusher(ContainerCopperCrusher container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }


}
