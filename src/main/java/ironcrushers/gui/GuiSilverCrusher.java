package ironcrushers.gui;

import ironcrushers.container.ContainerSilverCrusher;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiSilverCrusher extends GuiIronCrusherBase<ContainerSilverCrusher> {


    public GuiSilverCrusher(ContainerSilverCrusher container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }


}
