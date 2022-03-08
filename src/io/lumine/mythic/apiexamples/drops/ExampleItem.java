package io.lumine.mythic.apiexamples.drops;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.lumine.mythic.api.adapters.AbstractItemStack;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.drops.IItemDrop;
import io.lumine.mythic.api.drops.DropMetadata;
import io.lumine.mythic.bukkit.adapters.BukkitItemStack;

public class ExampleItem implements IItemDrop {

	private Material material;
	
	public ExampleItem(MythicLineConfig config, String argument) {
		String str = config.getString(new String[] {"type", "t"}, "STONE", argument);
		
		this.material = Material.valueOf(str.toUpperCase());
	}

    @Override
    public AbstractItemStack getDrop(DropMetadata data, double amount) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        
        meta.setDisplayName("SPECIAL EXAMPLE ITEM");
        item.setItemMeta(meta);
        
        return new BukkitItemStack(item);
    }

}
