package me.hybridplague.speedboots;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class SpeedBoots extends JavaPlugin {

	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
	}
	
	@Override
	public void onDisable() {
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("speedboots")) {
			if (!(sender instanceof Player))
				return false;
			Player p = (Player) sender;

			if (!p.hasPermission("speedboots.get"))
				return false;
			
			p.getInventory().addItem(boots());
			
			return true;
			
		}
		return false;
	}
	
	public ItemStack boots() {
		
		ItemStack item = new ItemStack(Material.NETHERITE_BOOTS);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&9&oBoots crafted by the Gods"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "&c• &fGrants the ability of Super Speed"));
		lore.add(ChatColor.translateAlternateColorCodes('&', "  &fand Jump Boost 6"));
		
		meta.setLore(lore);
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boots of Speed");
		
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.setUnbreakable(true);
		
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", .5, Operation.ADD_NUMBER, EquipmentSlot.FEET));
		
		item.setItemMeta(meta);
		
		return item;
		
	}
	
	
}
