package net.azilcoff.uranium.block;

import net.azilcoff.uranium.Uranium;
import net.azilcoff.uranium.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {
    public static final Block URANIUM_ORE = registerBlock("uranium_ore", ItemGroups.NATURAL, settings -> new ExperienceDroppingBlock(UniformIntProvider.create(2,7), settings
            .sounds(BlockSoundGroup.STONE)
            .requiresTool()
            .strength(3f)));

    public static final Block DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore", ItemGroups.NATURAL, settings -> new ExperienceDroppingBlock(UniformIntProvider.create(2,7), settings
            .sounds(BlockSoundGroup.DEEPSLATE)
            .requiresTool()
            .strength(3.4f)));

    private static <R extends Block> Block registerBlock(String id, RegistryKey<ItemGroup> tab, Function<AbstractBlock.Settings, R> entry){
        Block block = Registry.register(Registries.BLOCK, Identifier.of(Uranium.MOD_ID, id), entry.apply(AbstractBlock.Settings.create()
                .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Uranium.MOD_ID, id)))));

        ModItems.registerItem(id, null, settings -> new BlockItem(block, settings.useBlockPrefixedTranslationKey()));
        if (tab != null) ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(block));

        return block;
    }

    public static void registerModBlocks(){
        Uranium.LOGGER.info("Registering Mod Block for "+ Uranium.MOD_ID);
    }
}
