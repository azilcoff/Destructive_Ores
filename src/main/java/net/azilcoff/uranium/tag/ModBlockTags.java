package net.azilcoff.uranium.tag;

import net.azilcoff.uranium.Uranium;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> INCORRECT_FOR_URANIUM = createTag("incorrect_for_uranium");

    private static TagKey<Block> createTag (String name){
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Uranium.MOD_ID,name));
    }
}
