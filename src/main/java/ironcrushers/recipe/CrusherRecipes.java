package ironcrushers.recipe;

import com.google.common.collect.Maps;
import ironcrushers.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Map;

public class CrusherRecipes {

    private static final CrusherRecipes INSTANCE = new CrusherRecipes();

    private final Map<ItemStack, ItemStack> recipeList = Maps.<ItemStack, ItemStack>newHashMap();

    public static CrusherRecipes getInstance() {
        return INSTANCE;
    }

    private CrusherRecipes() {

        // SPECIAL
        this.addRecipe(Blocks.MAGMA_BLOCK, new ItemStack(Items.MAGMA_CREAM, 4));
        this.addRecipe(Blocks.GRAVEL, new ItemStack(Items.FLINT, 1));
        this.addRecipe(Blocks.NETHERRACK, new ItemStack(Blocks.GRAVEL, 1)/*, "dustSulfur", 15*/);
        this.addRecipe(Blocks.SANDSTONE, new ItemStack(Blocks.SAND, 2));
        this.addRecipe(Blocks.RED_SANDSTONE, new ItemStack(Blocks.RED_SAND, 2));
        this.addRecipe(Blocks.GLOWSTONE, new ItemStack(Items.GLOWSTONE_DUST, 4));
        this.addRecipe(Items.BLAZE_ROD, new ItemStack(Items.BLAZE_POWDER, 6)/*, "dustSulfur", 50*/);
		/*
		if (OreDictionary.doesOreNameExist("dustCoal") && OreDictionary.doesOreNameExist("dustSulfur")) {
			this.addRecipe(new ItemStack(Items.COAL, 1, 0),
					ItemHelper.cloneStack(OreDictionary.getOres("dustCoal", false).get(0), 1), "dustSulfur", 15);
		}
		if (OreDictionary.doesOreNameExist("dustCharcoal")) {
			this.addRecipe(new ItemStack(Items.COAL, 1, 1),
					ItemHelper.cloneStack(OreDictionary.getOres("dustCharcoal", false).get(0), 1));
		}
		if (OreDictionary.doesOreNameExist("itemSilicon")) {
			this.addRecipe(Blocks.SAND, ItemHelper.cloneStack(OreDictionary.getOres("itemSilicon", false).get(0), 1));
		}
		if (OreDictionary.doesOreNameExist("dustEnderPearl")) {
			this.addRecipe(Items.ENDER_PEARL,
					ItemHelper.cloneStack(OreDictionary.getOres("dustEnderPearl", false).get(0), 1));
		}
		*/

        // PLANTS
        this.addRecipe(new ItemStack(Blocks.DANDELION), new ItemStack(Items.YELLOW_DYE, 4));
        this.addRecipe(new ItemStack(Blocks.POPPY), new ItemStack(Items.RED_DYE, 4));
        this.addRecipe(new ItemStack(Blocks.BLUE_ORCHID), new ItemStack(Items.LIGHT_BLUE_DYE, 4));
        this.addRecipe(new ItemStack(Blocks.ALLIUM), new ItemStack(Items.MAGENTA_DYE, 4));
        this.addRecipe(new ItemStack(Blocks.AZURE_BLUET), new ItemStack(Items.LIGHT_GRAY_DYE, 4));
        this.addRecipe(new ItemStack(Blocks.RED_TULIP), new ItemStack(Items.RED_DYE, 4));
        this.addRecipe(new ItemStack(Blocks.ORANGE_TULIP), new ItemStack(Items.ORANGE_DYE, 4));
        this.addRecipe(new ItemStack(Blocks.WHITE_TULIP), new ItemStack(Items.BONE_MEAL, 4));
        this.addRecipe(new ItemStack(Blocks.PINK_TULIP), new ItemStack(Items.PINK_DYE, 4));
        this.addRecipe(new ItemStack(Blocks.OXEYE_DAISY), new ItemStack(Items.LIGHT_GRAY_DYE, 4));

        this.addRecipe(new ItemStack(Blocks.SUNFLOWER, 1), new ItemStack(Items.YELLOW_DYE, 8));
        this.addRecipe(new ItemStack(Blocks.LILAC, 1), new ItemStack(Items.MAGENTA_DYE, 8));
        this.addRecipe(new ItemStack(Blocks.ROSE_BUSH, 1), new ItemStack(Items.RED_DYE, 8));
        this.addRecipe(new ItemStack(Blocks.PEONY, 1), new ItemStack(Items.PINK_DYE, 8));

        this.addRecipe(new ItemStack(Blocks.SUGAR_CANE), new ItemStack(Items.SUGAR, 2));

        // RECYCLING
        this.addRecipe(new ItemStack(Blocks.GLASS), new ItemStack(Blocks.SAND, 1));

        this.addRecipe(new ItemStack(Blocks.BLACK_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.RED_STAINED_GLASS_PANE), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.GREEN_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.BROWN_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.BLUE_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.PURPLE_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.CYAN_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.LIGHT_GRAY_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.GRAY_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.PINK_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.LIME_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.YELLOW_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.LIGHT_BLUE_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.MAGENTA_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.ORANGE_STAINED_GLASS), new ItemStack(Blocks.SAND));
        this.addRecipe(new ItemStack(Blocks.WHITE_STAINED_GLASS_PANE), new ItemStack(Blocks.SAND));

        this.addRecipe(new ItemStack(Blocks.BLACK_CONCRETE), new ItemStack(Blocks.BLACK_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.RED_CONCRETE), new ItemStack(Blocks.RED_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.GREEN_CONCRETE), new ItemStack(Blocks.GREEN_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.BROWN_CONCRETE), new ItemStack(Blocks.BROWN_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.BLUE_CONCRETE), new ItemStack(Blocks.BLUE_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.PURPLE_CONCRETE), new ItemStack(Blocks.PURPLE_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.CYAN_CONCRETE), new ItemStack(Blocks.CYAN_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.LIGHT_GRAY_CONCRETE), new ItemStack(Blocks.LIGHT_GRAY_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.GRAY_CONCRETE), new ItemStack(Blocks.GRAY_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.PINK_CONCRETE), new ItemStack(Blocks.PINK_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.LIME_CONCRETE), new ItemStack(Blocks.LIME_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.YELLOW_CONCRETE), new ItemStack(Blocks.YELLOW_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.LIGHT_BLUE_CONCRETE), new ItemStack(Blocks.LIGHT_BLUE_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.MAGENTA_CONCRETE), new ItemStack(Blocks.MAGENTA_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.ORANGE_CONCRETE), new ItemStack(Blocks.ORANGE_CONCRETE_POWDER));
        this.addRecipe(new ItemStack(Blocks.WHITE_CONCRETE), new ItemStack(Blocks.WHITE_CONCRETE_POWDER));

        this.addRecipe(new ItemStack(Blocks.REDSTONE_LAMP), new ItemStack(Items.GLOWSTONE_DUST, 4));

        this.addRecipe(new ItemStack(Blocks.BRICKS), new ItemStack(Items.BRICK, 4));
        this.addRecipe(new ItemStack(Blocks.NETHER_BRICKS), new ItemStack(Items.NETHER_BRICK, 4));

        this.addRecipe(new ItemStack(Blocks.QUARTZ_BLOCK), new ItemStack(Items.QUARTZ, 4));
        this.addRecipe(new ItemStack(Blocks.QUARTZ_PILLAR), new ItemStack(Items.QUARTZ, 4));
        this.addRecipe(new ItemStack(Blocks.CHISELED_QUARTZ_BLOCK), new ItemStack(Items.QUARTZ, 4));
        this.addRecipe(new ItemStack(Blocks.SMOOTH_QUARTZ), new ItemStack(Items.QUARTZ, 4));

        this.addRecipe(new ItemStack(Blocks.SANDSTONE), new ItemStack(Blocks.SAND, 2) /*, "dustNiter", 40 */);
        this.addRecipe(new ItemStack(Blocks.CHISELED_SANDSTONE), new ItemStack(Blocks.SAND, 2) /*, "dustNiter", 40 */);
        this.addRecipe(new ItemStack(Blocks.CUT_SANDSTONE), new ItemStack(Blocks.SAND, 2) /*, "dustNiter", 40 */);
        this.addRecipe(new ItemStack(Blocks.SMOOTH_SANDSTONE), new ItemStack(Blocks.SAND, 2) /*, "dustNiter", 40 */);

        this.addRecipe(new ItemStack(Blocks.RED_SANDSTONE), new ItemStack(Blocks.RED_SAND, 2)/*, "dustNiter", 40*/);
        this.addRecipe(new ItemStack(Blocks.CHISELED_RED_SANDSTONE), new ItemStack(Blocks.RED_SAND, 2)/*, "dustNiter", 40*/);
        this.addRecipe(new ItemStack(Blocks.CUT_RED_SANDSTONE), new ItemStack(Blocks.RED_SAND, 2)/*, "dustNiter", 40*/);
        this.addRecipe(new ItemStack(Blocks.SMOOTH_RED_SANDSTONE), new ItemStack(Blocks.RED_SAND, 2)/*, "dustNiter", 40*/);

        this.addRecipe(new ItemStack(Blocks.BRICK_STAIRS), new ItemStack(Items.BRICK, 6));
        this.addRecipe(new ItemStack(Blocks.NETHER_BRICK_STAIRS), new ItemStack(Items.NETHER_BRICK, 6));
        this.addRecipe(new ItemStack(Blocks.QUARTZ_STAIRS), new ItemStack(Items.QUARTZ, 6));
        this.addRecipe(new ItemStack(Blocks.SANDSTONE_STAIRS), new ItemStack(Blocks.SAND, 6)/* , "dustNiter", 20 */);
        this.addRecipe(new ItemStack(Blocks.RED_SANDSTONE_STAIRS), new ItemStack(Blocks.SAND, 6)/* , "dustNiter", 20 */);

        this.addRecipe(new ItemStack(Blocks.BRICK_SLAB), new ItemStack(Items.BRICK, 2));
        this.addRecipe(new ItemStack(Blocks.NETHER_BRICK_SLAB), new ItemStack(Items.NETHER_BRICK, 2));
        this.addRecipe(new ItemStack(Blocks.QUARTZ_SLAB), new ItemStack(Items.QUARTZ, 2));
        this.addRecipe(new ItemStack(Blocks.SANDSTONE_SLAB), new ItemStack(Blocks.SAND, 2)/* , "dustNiter", 20 */);
        this.addRecipe(new ItemStack(Blocks.RED_SANDSTONE_SLAB), new ItemStack(Blocks.RED_SAND, 2)/* , "dustNiter", 20 */);

        this.addRecipe(new ItemStack(Blocks.FLOWER_POT), new ItemStack(Items.BRICK, 3));
        this.addRecipe(new ItemStack(Items.GLASS_BOTTLE), new ItemStack(Blocks.SAND));

        this.addRecipe(Blocks.STONE_BRICKS, new ItemStack(Blocks.COBBLESTONE, 1));
        this.addRecipe(Blocks.CHISELED_STONE_BRICKS, new ItemStack(Blocks.COBBLESTONE, 1));
        this.addRecipe(Blocks.CRACKED_STONE_BRICKS, new ItemStack(Blocks.COBBLESTONE, 1));
        this.addRecipe(Blocks.SMOOTH_STONE, new ItemStack(Blocks.COBBLESTONE, 1));

        this.addRecipe(Blocks.STONE, new ItemStack(Blocks.GRAVEL, 1));
        this.addRecipe(Blocks.COBBLESTONE, new ItemStack(Blocks.SAND, 1));

        this.addRecipe(new ItemStack(Items.DIAMOND_SWORD), new ItemStack(Items.DIAMOND, 2));
        this.addRecipe(new ItemStack(Items.DIAMOND_PICKAXE), new ItemStack(Items.DIAMOND, 3));
        this.addRecipe(new ItemStack(Items.DIAMOND_AXE), new ItemStack(Items.DIAMOND, 3));
        this.addRecipe(new ItemStack(Items.DIAMOND_SHOVEL), new ItemStack(Items.DIAMOND));
        this.addRecipe(new ItemStack(Items.DIAMOND_HOE), new ItemStack(Items.DIAMOND, 2));

        this.addRecipe(new ItemStack(Items.DIAMOND_HELMET), new ItemStack(Items.DIAMOND, 5));
        this.addRecipe(new ItemStack(Items.DIAMOND_CHESTPLATE), new ItemStack(Items.DIAMOND, 8));
        this.addRecipe(new ItemStack(Items.DIAMOND_LEGGINGS), new ItemStack(Items.DIAMOND, 7));
        this.addRecipe(new ItemStack(Items.DIAMOND_BOOTS), new ItemStack(Items.DIAMOND, 4));

        this.addRecipe(new ItemStack(Items.DIAMOND_HORSE_ARMOR), new ItemStack(Items.DIAMOND, 4));

        this.addRecipe(new ItemStack(Items.GOLDEN_SWORD), new ItemStack(ModItems.gold_dust, 2));
        this.addRecipe(new ItemStack(Items.GOLDEN_PICKAXE), new ItemStack(ModItems.gold_dust, 3));
        this.addRecipe(new ItemStack(Items.GOLDEN_AXE), new ItemStack(ModItems.gold_dust, 3));
        this.addRecipe(new ItemStack(Items.GOLDEN_SHOVEL), new ItemStack(ModItems.gold_dust));
        this.addRecipe(new ItemStack(Items.GOLDEN_HOE), new ItemStack(ModItems.gold_dust, 2));

        this.addRecipe(new ItemStack(Items.GOLDEN_HELMET), new ItemStack(ModItems.gold_dust, 5));
        this.addRecipe(new ItemStack(Items.GOLDEN_CHESTPLATE), new ItemStack(ModItems.gold_dust, 8));
        this.addRecipe(new ItemStack(Items.GOLDEN_LEGGINGS), new ItemStack(ModItems.gold_dust, 7));
        this.addRecipe(new ItemStack(Items.GOLDEN_BOOTS), new ItemStack(ModItems.gold_dust, 4));

        this.addRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR), new ItemStack(ModItems.gold_dust, 4));

        this.addRecipe(new ItemStack(Items.IRON_SWORD), new ItemStack(ModItems.iron_dust, 2));
        this.addRecipe(new ItemStack(Items.IRON_PICKAXE), new ItemStack(ModItems.iron_dust, 3));
        this.addRecipe(new ItemStack(Items.IRON_AXE), new ItemStack(ModItems.iron_dust, 3));
        this.addRecipe(new ItemStack(Items.IRON_SHOVEL), new ItemStack(ModItems.iron_dust));
        this.addRecipe(new ItemStack(Items.IRON_HOE), new ItemStack(ModItems.iron_dust, 2));

        this.addRecipe(new ItemStack(Items.IRON_HELMET), new ItemStack(ModItems.iron_dust, 5));
        this.addRecipe(new ItemStack(Items.IRON_CHESTPLATE), new ItemStack(ModItems.iron_dust, 8));
        this.addRecipe(new ItemStack(Items.IRON_LEGGINGS), new ItemStack(ModItems.iron_dust, 7));
        this.addRecipe(new ItemStack(Items.IRON_BOOTS), new ItemStack(ModItems.iron_dust, 4));

        this.addRecipe(new ItemStack(Items.IRON_HORSE_ARMOR), new ItemStack(ModItems.iron_dust, 4));

        // Draconic Evolution
        //this.addRecipe("oreDraconium", "dustDraconium", 6);

        // Actually Additions

        //this.addRecipeOreToDust("oreQuartzBlack", "dustQuartzBlack");
        //this.addRecipeIngotToDust("gemQuartzBlack", "dustQuartzBlack");

        // Dyes
        this.addRecipe(Items.BONE, new ItemStack(Items.BONE_MEAL, 6));

        this.addRecipe(new ItemStack(Blocks.BLACK_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.RED_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.GREEN_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.BROWN_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.BLUE_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.PURPLE_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.CYAN_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.LIGHT_GRAY_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.GRAY_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.PINK_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.LIME_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.YELLOW_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.LIGHT_BLUE_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.MAGENTA_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.ORANGE_WOOL), new ItemStack(Items.STRING, 4));
        this.addRecipe(new ItemStack(Blocks.WHITE_WOOL), new ItemStack(Items.STRING, 4));

        // Ores, Ingots, Dusts
        // ORES

        this.addRecipe(new ItemStack(Blocks.IRON_ORE), new ItemStack(ModItems.iron_dust, 2));
        this.addRecipe(new ItemStack(Blocks.GOLD_ORE), new ItemStack(ModItems.gold_dust, 2));

        this.addRecipe(new ItemStack(Blocks.COAL_ORE), new ItemStack(Items.COAL, 3) /*, "dustCoal", 25F */);
        this.addRecipe(new ItemStack(Blocks.DIAMOND_ORE), new ItemStack(Items.DIAMOND, 2));
        this.addRecipe(new ItemStack(Blocks.EMERALD_ORE), new ItemStack(Items.EMERALD, 2));
        this.addRecipe(new ItemStack(Blocks.LAPIS_ORE), new ItemStack(Items.LAPIS_LAZULI, 12)/* , "dustSulfur", 20F */);
        this.addRecipe(new ItemStack(Blocks.REDSTONE_ORE), new ItemStack(Items.REDSTONE, 6)/* , "crystalCinnabar", 25F */);
        this.addRecipe(new ItemStack(Blocks.NETHER_QUARTZ_ORE), new ItemStack(Items.QUARTZ, 3)/* , "dustSulfur", 15F */);

    }

    public void addRecipe(Item input, ItemStack output) {
        this.addRecipe(new ItemStack(input), output);
    }

    public void addRecipe(Block input, ItemStack output) {
        this.addRecipe(new ItemStack(input), output);
    }

    public void addRecipe(ItemStack input, ItemStack output) {
        if (this.getResult(input) != ItemStack.EMPTY) {
            return;
        } else {
            this.recipeList.put(input, output);
        }
    }

    public ItemStack getResult(ItemStack stack) {
        for (Map.Entry<ItemStack, ItemStack> entry : this.recipeList.entrySet()) {
            if (this.compareItemStacks(stack, entry.getKey())) {
                return entry.getValue();
            }
        }
        return ItemStack.EMPTY;
    }

    public boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem();
    }

    public Map<ItemStack, ItemStack> getRecipes() {
        return this.recipeList;
    }

}
