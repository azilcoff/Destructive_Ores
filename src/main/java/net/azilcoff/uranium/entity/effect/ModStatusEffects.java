package net.azilcoff.uranium.entity.effect;

import net.azilcoff.uranium.Uranium;
import net.azilcoff.uranium.entity.effect.custom.HighRadiationStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;


public class ModStatusEffects {
    public static final RegistryEntry<StatusEffect> HIGH_RADIATION = registerStatusEffect("high_radiation", new HighRadiationStatusEffect(StatusEffectCategory.HARMFUL, 0xb4da0c));

    private static <S extends StatusEffect> RegistryEntry<StatusEffect> registerStatusEffect(String id, S entry){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Uranium.MOD_ID, id), entry);
    }

    public static void registerModStatusEffects(){
        Uranium.LOGGER.info("Registering Mod Status Effects for "+ Uranium.MOD_ID);
    }
}
