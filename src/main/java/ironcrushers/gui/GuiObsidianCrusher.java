package ironcrushers.gui;

import ironcrushers.container.ContainerObsidianCrusher;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuiObsidianCrusher extends GuiIronCrusherBase<ContainerObsidianCrusher> {


    public GuiObsidianCrusher(ContainerObsidianCrusher container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
    }


}
