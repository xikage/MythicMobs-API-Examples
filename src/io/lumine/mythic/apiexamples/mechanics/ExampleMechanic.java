package io.lumine.mythic.apiexamples.mechanics;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.ITargetedEntitySkill;
import io.lumine.mythic.api.skills.SkillMetadata;
import io.lumine.mythic.api.skills.SkillResult;
import io.lumine.mythic.bukkit.BukkitAdapter;

public class ExampleMechanic implements ITargetedEntitySkill {

    protected final int duration;
    protected final int level;
    
    public ExampleMechanic(MythicLineConfig config) {
        this.duration = config.getInteger(new String[] {"duration", "d"}, 100);
        this.level = config.getInteger(new String[] {"level", "l"}, 0);
    }

    @Override
    public SkillResult castAtEntity(SkillMetadata data, AbstractEntity target) {
    	LivingEntity bukkitTarget = (LivingEntity) BukkitAdapter.adapt(target);
    	
    	bukkitTarget.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, duration, level));

    	return SkillResult.SUCCESS;
    }
}
