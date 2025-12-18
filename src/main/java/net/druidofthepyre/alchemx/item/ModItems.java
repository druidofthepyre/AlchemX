package net.druidofthepyre.alchemx.item;

import net.druidofthepyre.alchemx.AlchemX;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ABYSSITE_SHARD = registerItem("abyssite_shard", new Item(new Item.Settings()));
    public static final Item ABYSSITE_CRYSTAL = registerItem("abyssite_crystal", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AlchemX.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AlchemX.LOGGER.info(AlchemX.MOD_ID + ": register items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ABYSSITE_SHARD);
            fabricItemGroupEntries.add(ABYSSITE_CRYSTAL);
        });
    }
}
