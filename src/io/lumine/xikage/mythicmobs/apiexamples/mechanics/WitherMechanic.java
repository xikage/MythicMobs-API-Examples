package io.lumine.xikage.mythicmobs.apiexamples.mechanics;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;
import io.lumine.xikage.mythicmobs.skills.mechanics.CustomMechanic;

public class WitherMechanic extends SkillMechanic implements ITargetedEntitySkill {

    protected final int duration;
    protected final int level;
    
    public WitherMechanic(String line, MythicLineConfig mlc) {
        super(line, mlc);
        this.setAsyncSafe(false);
        this.setTargetsCreativePlayers(false);
        
        this.duration = mlc.getInteger(new String[] {"duration", "d"}, 100);
        this.level = mlc.getInteger(new String[] {"level", "l"}, 0);
        
        MythicMobs.log("Custom Wither mechanic loaded!");
    }

    @Override
    public boolean castAtEntity(SkillMetadata data, AbstractEntity target) {
    	Entity bukkitCaster = BukkitAdapter.adapt(data.getCaster().getEntity());
    	LivingEntity bukkitTarget = (LivingEntity) BukkitAdapter.adapt(target);
    	
    	bukkitTarget.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, duration, level));
    	
    	MythicMobs.debug(1, "Custom Wither mechanic fired!");
    	return true;
    }
}
