package net.azilcoff.uranium.entity.effect.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class HighRadiationStatusEffect extends StatusEffect {


    public HighRadiationStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 45 == 0;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        entity.damage(world, entity.getDamageSources().generic(), (float) world.random.nextBetween(3,4));
        if (!entity.getMainHandStack().isEmpty()){
            entity.getMainHandStack().damage(world.random.nextBetween(21,43), entity, EquipmentSlot.MAINHAND);
            world.playSound(null, entity.getBlockPos(), SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.NEUTRAL, 0.5f, 1f);
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
