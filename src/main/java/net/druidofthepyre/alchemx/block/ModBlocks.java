package net.druidofthepyre.alchemx.block;

import net.druidofthepyre.alchemx.AlchemX;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import javax.swing.*;

public class ModBlocks {
    public static final Block ABYSSITE_BLOCK = registerBlock("abyssite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    private static final Block ABYSSITE_ORE = registerBlock("abyssite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(5,8), AbstractBlock.Settings.create()
                    .strength(5f).requiresTool().sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AlchemX.MOD_ID, name), block);
    }

    private static void registerBlockItems(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AlchemX.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        AlchemX.LOGGER.info(AlchemX.MOD_ID + ": register blocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ABYSSITE_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ABYSSITE_ORE);
        });
    }
}
