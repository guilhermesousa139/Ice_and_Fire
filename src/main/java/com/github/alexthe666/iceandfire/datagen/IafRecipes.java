package com.github.alexthe666.iceandfire.datagen;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.github.alexthe666.iceandfire.datagen.tags.IafItemTags;
import com.github.alexthe666.iceandfire.enums.EnumDragonArmor;
import com.github.alexthe666.iceandfire.enums.EnumSeaSerpent;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.github.alexthe666.iceandfire.item.ItemDragonArmor;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Generates recipes without advancements
 */
public class IafRecipes extends RecipeProvider {
    public IafRecipes(final DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull final Consumer<FinishedRecipe> consumer) {
        createShaped(consumer);
        createShapeless(consumer);
    }

    private void createShaped(@NotNull final Consumer<FinishedRecipe> consumer) {
        CustomShaped.shaped(IafItemRegistry.AMPHITHERE_ARROW.get(), 4)
                .pattern("X")
                .pattern("#")
                .pattern("Y")
                .define('#', Tags.Items.RODS_WOODEN)
                .define('X', Items.FLINT)
                .define('Y', IafItemRegistry.AMPHITHERE_FEATHER.get())
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.AMPHITHERE_MACUAHUITL.get())
                .pattern("OXO")
                .pattern("FXF")
                .pattern("OSO")
                .define('X', ItemTags.PLANKS)
                .define('S', Tags.Items.RODS_WOODEN)
                .define('O', Tags.Items.OBSIDIAN)
                .define('F', IafItemRegistry.AMPHITHERE_FEATHER.get())
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.BLINDFOLD.get())
                .pattern("SLS")
                .define('L', Tags.Items.LEATHER)
                .define('S', Tags.Items.STRING)
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.CHAIN.get())
                .pattern("S")
                .pattern("S")
                .pattern("S")
                .define('S', Items.CHAIN)
                .save(consumer);

        armorSet(consumer, Items.CHAIN,
                Items.CHAINMAIL_HELMET,
                Items.CHAINMAIL_CHESTPLATE,
                Items.CHAINMAIL_LEGGINGS,
                Items.CHAINMAIL_BOOTS
        );

        CustomShaped.shaped(IafItemRegistry.ITEM_COCKATRICE_SCEPTER.get())
                .pattern("S")
                .pattern("E")
                .pattern("W")
                .define('W', IafItemTags.WITHER_BONES)
                .define('S', IafItemRegistry.WITHER_SHARD.get())
                .define('E', IafItemRegistry.COCKATRICE_EYE.get())
                .save(consumer);

        armorSet(consumer, Tags.Items.INGOTS_COPPER,
                IafItemRegistry.COPPER_HELMET.get(),
                IafItemRegistry.COPPER_CHESTPLATE.get(),
                IafItemRegistry.COPPER_LEGGINGS.get(),
                IafItemRegistry.COPPER_BOOTS.get()
        );

        toolSet(consumer, Tags.Items.INGOTS_COPPER, Tags.Items.RODS_WOODEN,
                IafItemRegistry.COPPER_SWORD.get(),
                IafItemRegistry.COPPER_PICKAXE.get(),
                IafItemRegistry.COPPER_AXE.get(),
                IafItemRegistry.COPPER_SHOVEL.get(),
                IafItemRegistry.COPPER_HOE.get()
        );

        CustomShaped.shaped(IafItemRegistry.DEATHWORM_GAUNTLET_RED.get())
                .pattern(" T ")
                .pattern("CHC")
                .pattern("CCC")
                .define('C', IafItemRegistry.DEATH_WORM_CHITIN_RED.get())
                .define('H', IafItemRegistry.CHAIN.get())
                .define('T', IafItemRegistry.DEATHWORM_TOUNGE.get())
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.DEATHWORM_GAUNTLET_WHITE.get())
                .pattern(" T ")
                .pattern("CHC")
                .pattern("CCC")
                .define('C', IafItemRegistry.DEATH_WORM_CHITIN_WHITE.get())
                .define('H', IafItemRegistry.CHAIN.get())
                .define('T', IafItemRegistry.DEATHWORM_TOUNGE.get())
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.DEATHWORM_GAUNTLET_YELLOW.get())
                .pattern(" T ")
                .pattern("CHC")
                .pattern("CCC")
                .define('C', IafItemRegistry.DEATH_WORM_CHITIN_YELLOW.get())
                .define('H', IafItemRegistry.CHAIN.get())
                .define('T', IafItemRegistry.DEATHWORM_TOUNGE.get())
                .save(consumer);

        armorSet(consumer, IafItemRegistry.DEATH_WORM_CHITIN_RED.get(),
                IafItemRegistry.DEATHWORM_RED_HELMET.get(),
                IafItemRegistry.DEATHWORM_RED_CHESTPLATE.get(),
                IafItemRegistry.DEATHWORM_RED_LEGGINGS.get(),
                IafItemRegistry.DEATHWORM_RED_BOOTS.get()
        );

        armorSet(consumer, IafItemRegistry.DEATH_WORM_CHITIN_WHITE.get(),
                IafItemRegistry.DEATHWORM_WHITE_HELMET.get(),
                IafItemRegistry.DEATHWORM_WHITE_CHESTPLATE.get(),
                IafItemRegistry.DEATHWORM_WHITE_LEGGINGS.get(),
                IafItemRegistry.DEATHWORM_WHITE_BOOTS.get()
        );

        armorSet(consumer, IafItemRegistry.DEATH_WORM_CHITIN_YELLOW.get(),
                IafItemRegistry.DEATHWORM_YELLOW_HELMET.get(),
                IafItemRegistry.DEATHWORM_YELLOW_CHESTPLATE.get(),
                IafItemRegistry.DEATHWORM_YELLOW_LEGGINGS.get(),
                IafItemRegistry.DEATHWORM_YELLOW_BOOTS.get()
        );

        dragonArmorSet(consumer, Tags.Items.STORAGE_BLOCKS_COPPER,
                IafItemRegistry.DRAGONARMOR_COPPER_0.get(),
                IafItemRegistry.DRAGONARMOR_COPPER_1.get(),
                IafItemRegistry.DRAGONARMOR_COPPER_2.get(),
                IafItemRegistry.DRAGONARMOR_COPPER_3.get()
        );

        dragonArmorSet(consumer, Tags.Items.STORAGE_BLOCKS_DIAMOND,
                IafItemRegistry.DRAGONARMOR_DIAMOND_0.get(),
                IafItemRegistry.DRAGONARMOR_DIAMOND_1.get(),
                IafItemRegistry.DRAGONARMOR_DIAMOND_2.get(),
                IafItemRegistry.DRAGONARMOR_DIAMOND_3.get()
        );

        CustomShaped.shaped(IafItemRegistry.DIAMOND_HIPPOGRYPH_ARMOR.get())
                .pattern("   ")
                .pattern("FDF")
                .pattern("   ")
                .define('F', Tags.Items.FEATHERS)
                .define('D', Items.DIAMOND_HORSE_ARMOR)
                .save(consumer);

        nineBlockStorageRecipes(consumer, IafItemRegistry.DRAGON_BONE.get(), IafBlockRegistry.DRAGON_BONE_BLOCK.get()
                , locationString("dragon_bone_block"), null
                , locationString("dragonbone"), null);

        CustomShaped.shaped(IafBlockRegistry.DRAGON_BONE_BLOCK_WALL.get())
                .pattern("BBB")
                .pattern("BBB")
                .define('B', IafItemRegistry.DRAGON_BONE.get())
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.DRAGON_FLUTE.get())
                .pattern("B  ")
                .pattern(" B ")
                .pattern("  I")
                .define('I', Tags.Items.INGOTS_IRON)
                .define('B', IafItemRegistry.DRAGON_BONE.get())
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.DRAGON_HORN.get())
                .pattern("  B")
                .pattern(" BB")
                .pattern("IB ")
                .define('I', Tags.Items.RODS_WOODEN)
                .define('B', IafItemRegistry.DRAGON_BONE.get())
                .save(consumer);

        CustomShaped.shaped(IafBlockRegistry.DRAGON_ICE_SPIKES.get(), 4)
                .pattern("I I")
                .pattern("I I")
                .define('I', IafBlockRegistry.DRAGON_ICE.get())
                .save(consumer);

        CustomShaped.shaped(IafBlockRegistry.NEST.get(), 8)
                .pattern("HHH")
                .pattern("HBH")
                .pattern("HHH")
                .define('H', Blocks.HAY_BLOCK)
                .define('B', IafItemRegistry.DRAGON_BONE.get())
                .save(consumer);

        CustomShaped.shaped(IafItemRegistry.DRAGON_STAFF.get())
                .pattern("S")
                .pattern("T")
                .pattern("T")
                .define('T', Tags.Items.RODS_WOODEN)
                .define('S', IafItemTags.DRAGON_SKULLS)
                .save(consumer);

        toolSet(consumer, IafItemRegistry.DRAGON_BONE.get(), IafItemTags.WITHER_BONES,
                IafItemRegistry.DRAGONBONE_SWORD.get(),
                IafItemRegistry.DRAGONBONE_PICKAXE.get(),
                IafItemRegistry.DRAGONBONE_AXE.get(),
                IafItemRegistry.DRAGONBONE_SHOVEL.get(),
                IafItemRegistry.DRAGONBONE_HOE.get()
        );

        CustomShaped.shaped(IafItemRegistry.DRAGON_BOW.get())
                .pattern(" DS")
                .pattern("W S")
                .pattern(" DS")
                .define('S', Tags.Items.STRING)
                .define('W', IafItemTags.WITHER_BONES)
                .define('D', IafItemRegistry.DRAGON_BONE.get())
                .save(consumer);

        forgeBrick(consumer, Items.STONE_BRICKS, IafItemTags.FIRE_DRAGON_SCALE_STORAGE_BLOCKS, IafBlockRegistry.DRAGONFORGE_FIRE_BRICK.get());
        forgeCore(consumer, IafBlockRegistry.DRAGONFORGE_FIRE_BRICK.get(), IafItemRegistry.FIRE_DRAGON_HEART.get(), IafBlockRegistry.DRAGONFORGE_FIRE_CORE_DISABLED.get());
        forgeInput(consumer, IafBlockRegistry.DRAGONFORGE_FIRE_BRICK.get(), Tags.Items.INGOTS_IRON, IafBlockRegistry.DRAGONFORGE_FIRE_INPUT.get());

        forgeBrick(consumer, Items.STONE_BRICKS, IafItemTags.ICE_DRAGON_SCALE_STORAGE_BLOCKS, IafBlockRegistry.DRAGONFORGE_ICE_BRICK.get());
        forgeCore(consumer, IafBlockRegistry.DRAGONFORGE_ICE_BRICK.get(), IafItemRegistry.ICE_DRAGON_HEART.get(), IafBlockRegistry.DRAGONFORGE_ICE_CORE_DISABLED.get());
        forgeInput(consumer, IafBlockRegistry.DRAGONFORGE_ICE_BRICK.get(), Tags.Items.INGOTS_IRON, IafBlockRegistry.DRAGONFORGE_ICE_INPUT.get());

        forgeBrick(consumer, Items.STONE_BRICKS, IafItemTags.LIGHTNING_DRAGON_SCALE_STORAGE_BLOCKS, IafBlockRegistry.DRAGONFORGE_LIGHTNING_BRICK.get());
        forgeCore(consumer, IafBlockRegistry.DRAGONFORGE_LIGHTNING_BRICK.get(), IafItemRegistry.LIGHTNING_DRAGON_HEART.get(), IafBlockRegistry.DRAGONFORGE_LIGHTNING_CORE_DISABLED.get());
        forgeInput(consumer, IafBlockRegistry.DRAGONFORGE_LIGHTNING_BRICK.get(), Tags.Items.INGOTS_IRON, IafBlockRegistry.DRAGONFORGE_LIGHTNING_INPUT.get());

        CustomShaped.shaped(IafItemRegistry.DRAGON_MEAL.get())
                .pattern("BMB")
                .pattern("MBM")
                .pattern("BMB")
                .define('B', Tags.Items.BONES)
                .define('M', IafItemTags.DRAGON_FOOD_MEAT)
                .save(consumer);

        compact(consumer, IafItemRegistry.DRAGONSCALES_RED.get(), IafBlockRegistry.DRAGON_SCALE_RED.get());
        compact(consumer, IafItemRegistry.DRAGONSCALES_GREEN.get(), IafBlockRegistry.DRAGON_SCALE_GREEN.get());
        compact(consumer, IafItemRegistry.DRAGONSCALES_BRONZE.get(), IafBlockRegistry.DRAGON_SCALE_BRONZE.get());
        compact(consumer, IafItemRegistry.DRAGONSCALES_GRAY.get(), IafBlockRegistry.DRAGON_SCALE_GRAY.get());

        compact(consumer, IafItemRegistry.DRAGONSCALES_BLUE.get(), IafBlockRegistry.DRAGON_SCALE_BLUE.get());
        compact(consumer, IafItemRegistry.DRAGONSCALES_WHITE.get(), IafBlockRegistry.DRAGON_SCALE_WHITE.get());
        compact(consumer, IafItemRegistry.DRAGONSCALES_SAPPHIRE.get(), IafBlockRegistry.DRAGON_SCALE_SAPPHIRE.get());
        compact(consumer, IafItemRegistry.DRAGONSCALES_SILVER.get(), IafBlockRegistry.DRAGON_SCALE_SILVER.get());

        compact(consumer, IafItemRegistry.DRAGONSCALES_ELECTRIC.get(), IafBlockRegistry.DRAGON_SCALE_ELECTRIC.get());
        compact(consumer, IafItemRegistry.DRAGONSCALES_AMYTHEST.get(), IafBlockRegistry.DRAGON_SCALE_AMYTHEST.get());
        compact(consumer, IafItemRegistry.DRAGONSCALES_COPPER.get(), IafBlockRegistry.DRAGON_SCALE_COPPER.get());
        compact(consumer, IafItemRegistry.DRAGONSCALES_BLACK.get(), IafBlockRegistry.DRAGON_SCALE_BLACK.get());

        for (EnumDragonArmor type : EnumDragonArmor.values()) {
            armorSet(consumer, type.armorMaterial.getRepairIngredient(),
                    type.helmet.get(),
                    type.chestplate.get(),
                    type.leggings.get(),
                    type.boots.get()
            );
        }

        for (EnumSeaSerpent type : EnumSeaSerpent.values()) {
            armorSet(consumer, type.armorMaterial.getRepairIngredient(),
                    type.helmet.get(),
                    type.chestplate.get(),
                    type.leggings.get(),
                    type.boots.get()
            );
        }

        compact(consumer, IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get(), IafBlockRegistry.DRAGONSTEEL_FIRE_BLOCK.get());

        toolSet(consumer, IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get(), IafItemTags.WITHER_BONES,
                IafItemRegistry.DRAGONSTEEL_FIRE_SWORD.get(),
                IafItemRegistry.DRAGONSTEEL_FIRE_PICKAXE.get(),
                IafItemRegistry.DRAGONSTEEL_FIRE_AXE.get(),
                IafItemRegistry.DRAGONSTEEL_FIRE_SHOVEL.get(),
                IafItemRegistry.DRAGONSTEEL_FIRE_HOE.get()
        );

        armorSet(consumer, IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get(),
                IafItemRegistry.DRAGONSTEEL_FIRE_HELMET.get(),
                IafItemRegistry.DRAGONSTEEL_FIRE_CHESTPLATE.get(),
                IafItemRegistry.DRAGONSTEEL_FIRE_LEGGINGS.get(),
                IafItemRegistry.DRAGONSTEEL_FIRE_BOOTS.get()
        );

        dragonArmorSet(consumer, IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_FIRE_0.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_FIRE_1.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_FIRE_2.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_FIRE_3.get()
        );

        compact(consumer, IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get(), IafBlockRegistry.DRAGONSTEEL_ICE_BLOCK.get());

        toolSet(consumer, IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get(), IafItemTags.WITHER_BONES,
                IafItemRegistry.DRAGONSTEEL_ICE_SWORD.get(),
                IafItemRegistry.DRAGONSTEEL_ICE_PICKAXE.get(),
                IafItemRegistry.DRAGONSTEEL_ICE_AXE.get(),
                IafItemRegistry.DRAGONSTEEL_ICE_SHOVEL.get(),
                IafItemRegistry.DRAGONSTEEL_ICE_HOE.get()
        );

        armorSet(consumer, IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get(),
                IafItemRegistry.DRAGONSTEEL_ICE_HELMET.get(),
                IafItemRegistry.DRAGONSTEEL_ICE_CHESTPLATE.get(),
                IafItemRegistry.DRAGONSTEEL_ICE_LEGGINGS.get(),
                IafItemRegistry.DRAGONSTEEL_ICE_BOOTS.get()
        );

        dragonArmorSet(consumer, IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_ICE_0.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_ICE_1.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_ICE_2.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_ICE_3.get()
        );

        compact(consumer, IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get(), IafBlockRegistry.DRAGONSTEEL_LIGHTNING_BLOCK.get());

        toolSet(consumer, IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get(), IafItemTags.WITHER_BONES,
                IafItemRegistry.DRAGONSTEEL_LIGHTNING_SWORD.get(),
                IafItemRegistry.DRAGONSTEEL_LIGHTNING_PICKAXE.get(),
                IafItemRegistry.DRAGONSTEEL_LIGHTNING_AXE.get(),
                IafItemRegistry.DRAGONSTEEL_LIGHTNING_SHOVEL.get(),
                IafItemRegistry.DRAGONSTEEL_LIGHTNING_HOE.get()
        );

        armorSet(consumer, IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get(),
                IafItemRegistry.DRAGONSTEEL_LIGHTNING_HELMET.get(),
                IafItemRegistry.DRAGONSTEEL_LIGHTNING_CHESTPLATE.get(),
                IafItemRegistry.DRAGONSTEEL_LIGHTNING_LEGGINGS.get(),
                IafItemRegistry.DRAGONSTEEL_LIGHTNING_BOOTS.get()
        );

        dragonArmorSet(consumer, IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_LIGHTNING_0.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_LIGHTNING_1.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_LIGHTNING_2.get(),
                IafItemRegistry.DRAGONARMOR_DRAGONSTEEL_LIGHTNING_3.get()
        );
    }

    private void createShapeless(@NotNull final Consumer<FinishedRecipe> consumer) {
        CustomShapeless.shapeless(IafItemRegistry.AMBROSIA.get())
                .requires(IafItemRegistry.PIXIE_DUST.get())
                .requires(Items.BOWL)
                .save(consumer);

        CustomShapeless.shapeless(Items.CHARCOAL)
                .requires(IafBlockRegistry.ASH.get(), 9)
                .save(consumer, location("ash_to_charcoal"));

        CustomShapeless.shapeless(IafBlockRegistry.ASH.get())
                .requires(IafItemTags.CHARRED_BLOCKS, 9)
                .save(consumer);

        CustomShapeless.shapeless(IafItemRegistry.BESTIARY.get())
                .requires(IafItemRegistry.MANUSCRIPT.get(), 3)
                .save(consumer);

        CustomShapeless.shapeless(IafItemRegistry.CHAIN_STICKY.get())
                .requires(Tags.Items.SLIMEBALLS)
                .requires(IafItemRegistry.CHAIN.get())
                .save(consumer);

        CustomShapeless.shapeless(Items.COPPER_INGOT)
                .requires(IafItemTags.COPPER_NUGGETS, 9)
                .save(consumer);

        CustomShapeless.shapeless(IafItemRegistry.COPPER_NUGGET.get(), 9)
                .requires(Tags.Items.INGOTS_COPPER)
                .save(consumer, location("copper_ingot_to_nuggets"));

        CustomShapeless.shapeless(IafBlockRegistry.COPPER_PILE.get())
                .requires(IafItemTags.COPPER_NUGGETS, 2)
                .save(consumer);

        CustomShapeless.shapeless(IafBlockRegistry.DRAGON_ICE.get())
                .requires(IafItemTags.FROZEN_BLOCKS, 9)
                .save(consumer);

        CustomShapeless.shapeless(Items.BONE_MEAL, 5)
                .requires(IafItemTags.MOB_SKULLS)
                .save(consumer, location("skull_to_bone_meal"));

        CustomShapeless.shapeless(IafItemRegistry.DRAGONBONE_ARROW.get(), 5)
                .requires(IafItemRegistry.DRAGON_BONE.get())
                .requires(IafItemRegistry.WITHER_SHARD.get())
                .save(consumer);
    }

    private void compact(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike unpacked, final ItemLike packed) {
        nineBlockStorageRecipes(consumer, unpacked, packed
                , locationString(ForgeRegistries.ITEMS.getKey(packed.asItem()).getPath()), null
                , locationString(ForgeRegistries.ITEMS.getKey(unpacked.asItem()).getPath()), null);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final TagKey<Item> material, final TagKey<Item> handle, final ItemLike... items) {
        toolSet(consumer, Ingredient.of(material), Ingredient.of(handle), items);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike material, final TagKey<Item> handle, final ItemLike... items) {
        toolSet(consumer, Ingredient.of(material), Ingredient.of(handle), items);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final TagKey<Item> material, final ItemLike handle, final ItemLike... items) {
        toolSet(consumer, Ingredient.of(material), Ingredient.of(handle), items);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike material, final ItemLike handle, final ItemLike... items) {
        toolSet(consumer, Ingredient.of(material), Ingredient.of(handle), items);
    }

    private void toolSet(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike... results) {
        for (ItemLike result : results) {
            Item item = result.asItem();

            if (item instanceof SwordItem) {
                sword(consumer, material, handle, result);
            } else if (item instanceof PickaxeItem) {
                pickaxe(consumer, material, handle, result);
            } else if (item instanceof AxeItem) {
                axe(consumer, material, handle, result);
            } else if (item instanceof ShovelItem) {
                shovel(consumer, material, handle, result);
            } else if (item instanceof HoeItem) {
                hoe(consumer, material, handle, result);
            } else {
                throw new IllegalArgumentException("Result is not a valid tool: [" + result + "]");
            }
        }
    }

    private void armorSet(@NotNull final Consumer<FinishedRecipe> consumer, final TagKey<Item> tag, final ItemLike... results) {
        armorSet(consumer, Ingredient.of(tag), results);
    }

    private void armorSet(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike item, final ItemLike... results) {
        armorSet(consumer, Ingredient.of(item), results);
    }

    private void armorSet(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike... results) {
        for (ItemLike result : results) {
            if (result.asItem() instanceof ArmorItem armorItem) {
                switch (armorItem.getSlot()) {
                    case HEAD -> helmet(consumer, ingredient, result);
                    case CHEST -> chestPlate(consumer, ingredient, result);
                    case LEGS -> leggings(consumer, ingredient, result);
                    case FEET -> boots(consumer, ingredient, result);
                    default -> throw new IllegalArgumentException("Result is not a valid armor item: [" + result + "]");
                }
            } else {
                throw new IllegalArgumentException("Result is not an armor item: [" + result + "]");
            }
        }
    }

    private void helmet(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("###")
                .pattern("# #")
                .define('#', ingredient)
                .save(consumer);
    }

    private void chestPlate(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .save(consumer);
    }

    private void leggings(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ingredient)
                .save(consumer);
    }

    private void boots(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("# #")
                .pattern("# #")
                .define('#', ingredient)
                .save(consumer);
    }

    private void sword(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("m")
                .pattern("m")
                .pattern("h")
                .define('m', material)
                .define('h', handle)
                .save(consumer);
    }

    private void pickaxe(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("mmm")
                .pattern(" h ")
                .pattern(" h ")
                .define('m', material)
                .define('h', handle)
                .save(consumer);
    }

    private void axe(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("mm")
                .pattern("mh")
                .pattern(" h")
                .define('m', material)
                .define('h', handle)
                .save(consumer);
    }

    private void shovel(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("m")
                .pattern("h")
                .pattern("h")
                .define('m', material)
                .define('h', handle)
                .save(consumer);
    }

    private void hoe(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient material, final Ingredient handle, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("mm")
                .pattern(" h")
                .pattern(" h")
                .define('m', material)
                .define('h', handle)
                .save(consumer);
    }

    private void dragonArmorSet(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike material, final ItemLike... results) {
        dragonArmorSet(consumer, Ingredient.of(material), results);
    }

    private void dragonArmorSet(@NotNull final Consumer<FinishedRecipe> consumer, final TagKey<Item> tag, final ItemLike... results) {
        dragonArmorSet(consumer, Ingredient.of(tag), results);
    }

    private void dragonArmorSet(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike... results) {
        for (ItemLike result : results) {
            if (result instanceof ItemDragonArmor dragonArmor) {
                switch (dragonArmor.dragonSlot) {
                    case 0 -> dragonHead(consumer, ingredient, result);
                    case 1 -> dragonNeck(consumer, ingredient, result);
                    case 2 -> dragonBody(consumer, ingredient, result);
                    case 3 -> dragonTail(consumer, ingredient, result);
                    default ->
                            throw new IllegalArgumentException("Result is not a valid dragon armor [" + result + "]");
                }
            } else {
                throw new IllegalArgumentException("Result is not a dragon armor [" + result + "]");
            }
        }
    }

    private void dragonHead(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("   ")
                .pattern(" ##")
                .pattern("###")
                .define('#', ingredient)
                .save(consumer);
    }

    private void dragonNeck(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("   ")
                .pattern("###")
                .pattern(" ##")
                .define('#', ingredient)
                .save(consumer);
    }

    private void dragonBody(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("###")
                .pattern("###")
                .pattern("# #")
                .define('#', ingredient)
                .save(consumer);
    }

    private void dragonTail(@NotNull final Consumer<FinishedRecipe> consumer, final Ingredient ingredient, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("   ")
                .pattern("  #")
                .pattern("## ")
                .define('#', ingredient)
                .save(consumer);
    }

    private void forgeBrick(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike brick, final TagKey<Item> scales, final ItemLike result) {
        CustomShaped.shaped(result, 4)
                .pattern("SBS")
                .pattern("BSB")
                .pattern("SBS")
                .define('S', Ingredient.of(scales))
                .define('B', brick)
                .save(consumer);
    }

    private void forgeCore(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike brick, final ItemLike heart, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("BBB")
                .pattern("BHB")
                .pattern("BBB")
                .define('H', heart)
                .define('B', brick)
                .save(consumer);
    }

    private void forgeInput(@NotNull final Consumer<FinishedRecipe> consumer, final ItemLike brick, final TagKey<Item> material, final ItemLike result) {
        CustomShaped.shaped(result)
                .pattern("BIB")
                .pattern("I I")
                .pattern("BIB")
                .define('I', Ingredient.of(material))
                .define('B', brick)
                .save(consumer);
    }

    /**
     * Remove the serialization of the advancements
     */
    public void run(@NotNull final CachedOutput output) {
        Set<ResourceLocation> set = Sets.newHashSet();
        buildCraftingRecipes((finishedRecipe) -> {
            if (!set.add(finishedRecipe.getId())) {
                throw new IllegalStateException("Duplicate recipe " + finishedRecipe.getId());
            } else {
                saveRecipe(output, finishedRecipe.serializeRecipe(), this.recipePathProvider.json(finishedRecipe.getId()));
            }
        });
    }

    /**
     * Private access
     */
    private static void saveRecipe(final CachedOutput output, final JsonObject recipeJson, final Path path) {
        try {
            DataProvider.saveStable(output, recipeJson, path);
        } catch (IOException exception) {
            IceAndFire.LOGGER.error("Couldn't save recipe {}", path, exception);
        }
    }

    private static ResourceLocation location(final String path) {
        return new ResourceLocation(IceAndFire.MODID, path);
    }

    private static String locationString(final String path) {
        return IceAndFire.MODID + ":" + path;
    }

    /**
     * Remove checks regarding advancements since their implementation is unoptimized and creates lag
     */
    private static class CustomShaped extends ShapedRecipeBuilder {
        public CustomShaped(final ItemLike result, int count) {
            super(result, count);
        }

        public static CustomShaped shaped(final ItemLike result) {
            return shaped(result, 1);
        }

        public static CustomShaped shaped(final ItemLike result, int count) {
            return new CustomShaped(result, count);
        }

        @Override
        public CustomShaped pattern(@NotNull final String pattern) {
            super.pattern(pattern);
            return this;
        }

        @Override
        public CustomShaped define(@NotNull final Character symbol, @NotNull final Ingredient ingredient) {
            super.define(symbol, ingredient);
            return this;
        }

        @Override
        public void save(final Consumer<FinishedRecipe> finishedRecipe, @NotNull final ResourceLocation recipeId) {
            this.ensureValid(recipeId);
            finishedRecipe.accept(new ShapedRecipeBuilder.Result(recipeId, this.result, this.count, this.group == null ? "" : this.group, this.rows, this.key, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath())));
        }

        private void ensureValid(final ResourceLocation id) {
            if (this.rows.isEmpty()) {
                throw new IllegalStateException("No pattern is defined for shaped recipe " + id + "!");
            } else {
                Set<Character> set = Sets.newHashSet(this.key.keySet());
                set.remove(' ');

                for (String s : this.rows) {
                    for (int i = 0; i < s.length(); ++i) {
                        char c0 = s.charAt(i);
                        if (!this.key.containsKey(c0) && c0 != ' ') {
                            throw new IllegalStateException("Pattern in recipe " + id + " uses undefined symbol '" + c0 + "'");
                        }

                        set.remove(c0);
                    }
                }

                if (!set.isEmpty()) {
                    throw new IllegalStateException("Ingredients are defined but not used in pattern for recipe " + id);
                } else if (this.rows.size() == 1 && this.rows.get(0).length() == 1) {
                    throw new IllegalStateException("Shaped recipe " + id + " only takes in a single item - should it be a shapeless recipe instead?");
                }
            }
        }
    }

    /**
     * Remove checks regarding advancements since their implementation is unoptimized and creates lag
     */
    private static class CustomShapeless extends ShapelessRecipeBuilder {
        public CustomShapeless(final ItemLike result, int count) {
            super(result, count);
        }

        public static CustomShapeless shapeless(final ItemLike result) {
            return shapeless(result, 1);
        }

        public static CustomShapeless shapeless(final ItemLike result, int count) {
            return new CustomShapeless(result, count);
        }

        public CustomShapeless requires(@NotNull final TagKey<Item> tag, int count) {
            for (int i = 0; i < count; i++) {
                this.requires(Ingredient.of(tag));
            }

            return this;
        }

        @Override
        public CustomShapeless requires(@NotNull final Ingredient ingredient, int quantity) {
            super.requires(ingredient, quantity);
            return this;
        }

        @Override
        public void save(final Consumer<FinishedRecipe> finishedRecipe, @NotNull final ResourceLocation recipeId) {
            finishedRecipe.accept(new CustomShapeless.Result(recipeId, this.result, this.count, this.group == null ? "" : this.group, this.ingredients, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath())));
        }
    }
}
