package ironcrushers.tileentity;

import ironcrushers.blocks.BlockIronCrusherBase;
import ironcrushers.energy.IronCrusherEnergyStorage;
import ironcrushers.recipe.CrusherRecipes;
import net.minecraft.inventory.container.FurnaceFuelSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public abstract class TileEntityIronCrusherBase extends TileEntityInventory implements ITickableTileEntity {

    private static final int[] SLOTS_TOP = new int[]{0};
    private static final int[] SLOTS_BOTTOM = new int[]{2, 1};
    private static final int[] SLOTS_SIDES = new int[]{1};
    private int timer;
    /**
     * The number of ticks that the furnace will keep burning
     */
    private int furnaceBurnTime;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime = this.getCookTime();

    protected final IRecipeType<? extends AbstractCookingRecipe> recipeType;

    private LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergy);

    public TileEntityIronCrusherBase(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn, 4);
        recipeType = IRecipeType.SMELTING;
    }

    private IEnergyStorage createEnergy() {
        return new IronCrusherEnergyStorage(160000, 1600, 0);
    }

    public final IIntArray fields = new IIntArray() {
        public int get(int index) {
            switch (index) {
                case 0:
                    return TileEntityIronCrusherBase.this.furnaceBurnTime;
                case 1:
                    return TileEntityIronCrusherBase.this.currentItemBurnTime;
                case 2:
                    return TileEntityIronCrusherBase.this.cookTime;
                case 3:
                    return TileEntityIronCrusherBase.this.totalCookTime;
                default:
                    return 0;
            }
        }

        public void set(int index, int value) {
            switch (index) {
                case 0:
                    TileEntityIronCrusherBase.this.furnaceBurnTime = value;
                    break;
                case 1:
                    TileEntityIronCrusherBase.this.currentItemBurnTime = value;
                    break;
                case 2:
                    TileEntityIronCrusherBase.this.cookTime = value;
                    break;
                case 3:
                    TileEntityIronCrusherBase.this.totalCookTime = value;
                    break;
            }

        }

        public int size() {
            return 4;
        }
    };

    public int getEnergy() {
        return this.getCapability(CapabilityEnergy.ENERGY).map(h -> h.getEnergyStored()).orElse(0);
    }

    public int getCapacity() {
        return this.getCapability(CapabilityEnergy.ENERGY).map(h -> h.getMaxEnergyStored()).orElse(0);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        energy.ifPresent(h ->{
            ((IronCrusherEnergyStorage)h).writeToNBT(compound);
        });
        compound.putInt("BurnTime", this.furnaceBurnTime);
        compound.putInt("CookTime", this.cookTime);
        compound.putInt("CookTimeTotal", this.totalCookTime);
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        energy.ifPresent(h ->{
            ((IronCrusherEnergyStorage)h).readFromNBT(compound);
        });
        this.furnaceBurnTime = compound.getInt("BurnTime");
        this.cookTime = compound.getInt("CookTime");
        this.totalCookTime = compound.getInt("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.inventory.get(1));
        this.timer = 0;
    }


    public int getCookTime() {
        return 200;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }


    public boolean hasPower() {
        return this.getEnergy() > 0;
    }


    public boolean isCrushing() {
        return this.cookTime > 0;
    }

    @Override
    public void tick() {
        timer++;
        boolean flag1 = false;
        if (this.isCrushing()) {
            energy.ifPresent(h ->{
                ((IronCrusherEnergyStorage)h).setEnergy(h.getEnergyStored() - (12000 / this.getCookTime()));
            });
        }
        if (this.isBurning()) {
            energy.ifPresent(h -> {
                h.receiveEnergy(200, false);
            });
            this.furnaceBurnTime -= 100;
        }

        if (!this.world.isRemote) {
            ItemStack itemstack = this.inventory.get(1);
            if (this.hasPower() || !itemstack.isEmpty()) {
                if (!this.isBurning() && (this.getEnergy() + (getItemBurnTime(itemstack) * 2)) < this.getCapacity()) {
                    this.furnaceBurnTime = getItemBurnTime(itemstack);
                    this.currentItemBurnTime = this.furnaceBurnTime;
                    if (this.isBurning()) {
                        flag1 = true;
                        if (itemstack.hasContainerItem()) {
                            this.inventory.set(1, itemstack.getContainerItem());
                        } else if (!itemstack.isEmpty()) {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) {
                                Item item1 = item.getContainerItem();
                                this.inventory.set(1, item1 == null ? ItemStack.EMPTY : new ItemStack(item1));
                            }
                        }
                    }
                }
                if (!this.inventory.get(0).isEmpty()) {
                    if (this.canSmelt(this.inventory.get(0))) {
                        if (this.inventory.get(0).getCount() == 1 && !this.isCrushing()) {
                            this.inventory.set(3, this.inventory.get(0).copy());
                            this.inventory.get(0).shrink(1);
                        }
                        if (this.inventory.get(0).getCount() > 1 && !this.isCrushing()) {
                            this.inventory.set(3, new ItemStack(this.inventory.get(0).getItem(), 1));
                            this.inventory.get(0).shrink(1);
                        }
                    }
                }


                if (this.hasPower() && this.canSmelt(this.inventory.get(3))) {
                    ++this.cookTime;
                    if (this.cookTime >= this.totalCookTime) {
                        energy.ifPresent(h ->{
                            ((IronCrusherEnergyStorage)h).setEnergy(h.getEnergyStored() - (12000 / this.getCookTime()));
                        });
                        this.totalCookTime = this.getCookTime();
                        this.smeltItem(this.inventory.get(3));
                        this.cookTime = 0;
                        this.inventory.set(3, ItemStack.EMPTY);
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            } else if (!this.hasPower() && this.cookTime > 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }
        }
        if (timer % 24 == 0) {
            if (world.getBlockState(pos).getBlock() instanceof BlockIronCrusherBase) {
                if (this.isBurning() != world.getBlockState(pos).get(BlockStateProperties.LIT)) {
                    world.setBlockState(pos, world.getBlockState(pos).with(BlockStateProperties.LIT, this.isBurning()), 3);
                }
                if (this.hasPower() != world.getBlockState(pos).get(BlockStateProperties.POWERED)) {
                    world.setBlockState(pos, world.getBlockState(pos).with(BlockStateProperties.POWERED, this.hasPower()), 3);
                }
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    private boolean canSmelt(ItemStack input) {
        ItemStack output = CrusherRecipes.getInstance().getResult(input).copy();
        if (this.hasPower() && this.getEnergy() >= 12000 || this.isCrushing() && this.hasPower()) {
            if (output.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = this.inventory.get(2);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!itemstack1.isItemEqual(output)) {
                    return false;
                } else if (itemstack1.getCount() + output.getCount() <= this.getInventoryStackLimit() && itemstack1.getCount() < itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
                    return true;
                } else {
                    return itemstack1.getCount() + output.getCount() <= output.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
                }
            }
        } else {
            return false;
        }
    }

    private void smeltItem(ItemStack input) {
        if (this.canSmelt(input)) {
            ItemStack itemstack1 = CrusherRecipes.getInstance().getResult(input).copy();
            ItemStack itemstack2 = this.inventory.get(2);
            if (itemstack2.isEmpty()) {
                this.inventory.set(2, itemstack1.copy());
            } else if (itemstack2.getItem() == itemstack1.getItem()) {
                itemstack2.grow(itemstack1.getCount());
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't fuel
     */
    public static int getItemBurnTime(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            Item item = stack.getItem();
            int ret = stack.getBurnTime();
            return net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack, ret == -1 ? FurnaceTileEntity.getBurnTimes().getOrDefault(item, 0) : ret);
        }
    }

    @Override
    public int[] IgetSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return SLOTS_BOTTOM;
        } else {
            return side == Direction.UP ? SLOTS_TOP : SLOTS_SIDES;
        }
    }

    @Override
    public boolean IcanExtractItem(int index, ItemStack stack, Direction direction) {
        if (direction == Direction.DOWN && index == 1) {
            Item item = stack.getItem();
            if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean IisItemValidForSlot(int index, ItemStack stack) {
        if (index == 2) {
            return false;
        } else if (index != 1) {
            return true;
        } else {
            ItemStack itemstack = this.inventory.get(1);
            return FurnaceTileEntity.isFuel(stack) || FurnaceFuelSlot.isBucket(stack) && itemstack.getItem() != Items.BUCKET;
        }
    }

    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
            net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        if (!this.removed && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == Direction.UP)
                return handlers[0].cast();
            else if (facing == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[2].cast();
        }
        if (!this.removed && capability == CapabilityEnergy.ENERGY) {
            return energy.cast();
        }
        return super.getCapability(capability, facing);
    }
}
