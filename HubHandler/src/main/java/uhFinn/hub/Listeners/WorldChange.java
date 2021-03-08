/*
 * Author: Finn
 * Latest Edit: Finn
 *
 */

package uhFinn.hub.Listeners;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import uhFinn.hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WorldChange implements Listener {

    private Main plugin;
    public WorldChange(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onWorldSwitch(PlayerChangedWorldEvent event){
        Player p = event.getPlayer();
        if(p.getWorld() == plugin.getServer().getWorld("spawn")){
            p.playSound(p.getLocation(), Sound.MUSIC_DISC_MALL, 100, 1);
            p.getInventory().clear();
            p.getInventory().setItem(0, new ItemStack(Material.CLOCK));
            ItemMeta one = p.getInventory().getItem(0).getItemMeta();
            one.setDisplayName(ChatColor.WHITE + "Hub Selector");
            p.getInventory().getItem(0).setItemMeta(one);

            p.getInventory().setItem(1, new ItemStack(Material.COMPASS));
            ItemMeta two = p.getInventory().getItem(1).getItemMeta();
            two.setDisplayName(ChatColor.WHITE + "Game Selector");
            p.getInventory().getItem(1).setItemMeta(two);

            p.getInventory().setItem(4, new ItemStack(Material.ENDER_CHEST));
            ItemMeta five = p.getInventory().getItem(4).getItemMeta();
            five.setDisplayName(ChatColor.WHITE + "Cosmetics");
            p.getInventory().getItem(4).setItemMeta(five);

            p.getInventory().setItem(7, new ItemStack(Material.NAME_TAG));
            ItemMeta eight = p.getInventory().getItem(7).getItemMeta();
            eight.setDisplayName(ChatColor.RED + "Store");
            eight.addEnchant(Enchantment.MULTISHOT, 1, true);
            p.getInventory().getItem(7).setItemMeta(eight);

            p.getInventory().setItem(8, new ItemStack(Material.BOOK));
            ItemMeta nine = p.getInventory().getItem(8).getItemMeta();
            nine.setDisplayName(ChatColor.WHITE + "Rules & How To Play");
            p.getInventory().getItem(8).setItemMeta(nine);
        } else {
            if(event.getFrom() == plugin.getServer().getWorld("spawn")){
                p.getInventory().clear();
            }
        }

    }

}
