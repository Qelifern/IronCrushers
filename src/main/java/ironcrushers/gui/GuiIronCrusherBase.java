package ironcrushers.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import ironcrushers.Main;
import ironcrushers.container.ContainerIronCrusherBase;
import ironcrushers.tileentity.TileEntityIronCrusherBase;
import ironcrushers.util.StringHelper;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class GuiIronCrusherBase<T extends ContainerIronCrusherBase> extends ContainerScreen<T> {

    private static final ResourceLocation background = new ResourceLocation(Main.MOD_ID + ":" + "textures/gui/crusher.png");
    private TileEntityIronCrusherBase te;
    private PlayerInventory playerInv;
    ITextComponent name;

    public GuiIronCrusherBase(T t, PlayerInventory inv, ITextComponent name) {
        super(t, inv, name);
        playerInv = inv;
        this.name = name;
    }


    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        //drawString(Minecraft.getInstance().fontRenderer, "Energy: " + container.getEnergy(), 10, 10, 0xffffff);
        this.minecraft.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedComponentText(), 7, this.ySize - 93, 4210752);
        this.minecraft.fontRenderer.drawString(name.getUnformattedComponentText(), 7 + this.xSize / 2 - this.minecraft.fontRenderer.getStringWidth(name.getUnformattedComponentText()) / 2, 6, 4210752);

        int actualMouseX = mouseX - ((this.width - this.xSize) / 2);
        int actualMouseY = mouseY - ((this.height - this.ySize) / 2);
        if(actualMouseX >= 9 && actualMouseX <= 23 && actualMouseY >= 9 && actualMouseY <= 31) {
            int energy = ((ContainerIronCrusherBase)this.container).getEnergy();
            int capacity = ((ContainerIronCrusherBase)this.container).getCapacity();
            this.renderTooltip(StringHelper.displayEnergy(energy, capacity), actualMouseX, actualMouseY);
        }

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(background);
        int relX = (this.width - this.xSize) / 2;
        int relY = (this.height - this.ySize) / 2;
        this.blit(relX, relY, 0, 0, this.xSize, this.ySize);
        int i;
        if (((ContainerIronCrusherBase)this.container).isBurning()) {
            i = ((ContainerIronCrusherBase)this.container).getBurnScaled(13);
            this.blit(guiLeft + 9, guiTop + 38 + 12 - i, 176, 12 - i, 14, i + 1);
        }

        i = ((ContainerIronCrusherBase)this.container).getCookScaled(24);
        this.blit(guiLeft + 79, guiTop + 34, 176, 14, i + 1, 16);

        i = ((ContainerIronCrusherBase)this.container).getEnergyScaled(22);
        this.blit(guiLeft + 9, guiTop + 31 - i, 176, 53 - i, 14, i);

        if (((ContainerIronCrusherBase)this.container).isCrushing() || !this.container.getSlot(0).inventory.isEmpty()) {
            this.blit(guiLeft + 58, guiTop + 46, 176, 53, 12, 12);
        }


    }


}
