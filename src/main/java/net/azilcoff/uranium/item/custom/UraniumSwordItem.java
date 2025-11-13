package net.azilcoff.uranium.item.custom;

import net.azilcoff.uranium.entity.effect.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UraniumSwordItem extends Item {
    public UraniumSwordItem(Settings settings) {
        super(settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(ModStatusEffects.HIGH_RADIATION, target.getEntityWorld().random.nextBetween(1200, 1800)));
        super.postHit(stack, target, attacker);
    }
}
