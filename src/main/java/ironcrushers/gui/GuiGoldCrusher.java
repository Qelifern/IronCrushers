package ironcrushers.gui;

import ironcrushers.container.ContainerGoldCrusher;
import ironcrushers.container.ContainerIronCrusherBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiGoldCrusher extends GuiIronCrusherBase<ContainerGoldCrusher> {


    public GuiGoldCrusher(ContainerGoldCrusher container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }


}
