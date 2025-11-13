package net.azilcoff.uranium.item;

import net.azilcoff.uranium.Uranium;
import net.azilcoff.uranium.item.custom.UraniumItem;
import net.azilcoff.uranium.item.custom.UraniumSwordItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final Item URANIUM = registerItem("uranium", ItemGroups.INGREDIENTS, settings -> new UraniumItem(settings.rarity(Rarity.EPIC)));
    public static final Item URANIUM_SWORD = registerSwordItem("uranium_sword", UraniumSwordItem::new, ModToolMaterials.URANIUM);

    public static <R extends Item> Item registerItem (String id, RegistryKey<ItemGroup> tab, Function<Item.Settings, R> entry) {
        R r = Registry.register(Registries.ITEM, Identifier.of(Uranium.MOD_ID, id), entry.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Uranium.MOD_ID, id)))));
        if (tab != null) ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(r));
        return r;
    }
    private static <R extends Item> Item registerSwordItem(String id, Function<Item.Settings, R> entry, ToolMaterial material){
        R r = Registry.register(Registries.ITEM, Identifier.of(Uranium.MOD_ID, id), entry.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Uranium.MOD_ID, id)))
                .sword(material, 3.0F, -2.4F)));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(r));
        return r;
    }

    public static void registerModItems(){
        Uranium.LOGGER.info("Registering Mod Items for "+ Uranium.MOD_ID);
    }
}
