package io.lumine.xikage.mythicmobs.apiexamples.conditions;

import org.bukkit.entity.LivingEntity;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitAdapter;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityCondition;

public class InVehicleCondition extends SkillCondition implements IEntityCondition {

	public InVehicleCondition(MythicLineConfig config) {
		super(config.getLine());
	}

	@Override
	public boolean check(AbstractEntity target) {
		LivingEntity bukkitTarget = (LivingEntity) BukkitAdapter.adapt(target);
		return (bukkitTarget.getVehicle() != null);
	}
}
