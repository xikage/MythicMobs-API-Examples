package io.lumine.xikage.mythicmobs.apiexamples.drops;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.adapters.bukkit.BukkitItemStack;
import io.lumine.xikage.mythicmobs.drops.Drop;
import io.lumine.xikage.mythicmobs.drops.DropMetadata; 
import io.lumine.xikage.mythicmobs.drops.IMultiDrop;
import io.lumine.xikage.mythicmobs.drops.LootBag;
import io.lumine.xikage.mythicmobs.drops.droppables.ItemDrop;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;

public class SpecialItem extends Drop implements IMultiDrop {

	private Material material;
	
	public SpecialItem(String line, MythicLineConfig config) {
		super(line, config);
		
		String str = config.getString(new String[] {"type", "t"}, dropVar);
		
		this.material = Material.valueOf(str.toUpperCase());
	}

	@Override
	public LootBag get(DropMetadata metadata) {
		final LootBag loot = new LootBag(metadata);

		final ItemStack item = new ItemStack(material, 1);
		final ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName("SPECIAL");
		item.setItemMeta(meta);
		
		MythicMobs.log("FUCKFUCK " + this.getLine());
		
		loot.add(new ItemDrop(this.getLine(), (MythicLineConfig) this.getConfig(), new BukkitItemStack(item)));
		
		return loot;
	}

}
