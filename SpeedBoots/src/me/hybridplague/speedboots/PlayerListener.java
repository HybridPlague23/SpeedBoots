package me.hybridplague.speedboots;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener {

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		ItemStack item = p.getInventory().getBoots();
		ItemMeta meta = item.getItemMeta();
		
		String displayName = meta.getDisplayName();
		
		if (displayName.equals(ChatColor.GREEN + "" + ChatColor.BOLD + "Boots of Speed")) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 5, false, false, true));
		}
		return;
	}
}
