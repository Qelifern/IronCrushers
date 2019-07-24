package ironcrushers.gui;

import ironcrushers.container.ContainerIronCrusher;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiIronCrusher extends GuiIronCrusherBase<ContainerIronCrusher> {


    public GuiIronCrusher(ContainerIronCrusher container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }


}
