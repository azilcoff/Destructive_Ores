package net.azilcoff.dores.item;

import net.azilcoff.dores.DestructiveOres;
import net.azilcoff.dores.component.ModDataComponentTypes;
import net.azilcoff.dores.item.custom.UraniumItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.random.Random;

import java.util.function.Function;

public class ModItems {

    public static final Item URANIUM = registerItem("uranium", ItemGroups.INGREDIENTS, settings -> new UraniumItem(settings.rarity(Rarity.EPIC).component(ModDataComponentTypes.RADIATION, Random.create().nextBetween(10, 100))));

    public static <R extends Item> Item registerItem (String id, RegistryKey<ItemGroup> tab, Function<Item.Settings, R> entry){
        R r = Registry.register(Registries.ITEM, Identifier.of(DestructiveOres.MOD_ID, id), entry.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DestructiveOres.MOD_ID, id)))));
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries ->entries.add(r));
        return r;
    }

    public static void registerModItems(){
        DestructiveOres.LOGGER.info("Registering Mod Items for "+DestructiveOres.MOD_ID);
    }
}
