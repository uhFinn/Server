/*
 * Author: Finn
 * Latest Edit: Finn
 *
 */

package uhFinn.hub.Listeners;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
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

import java.io.File;
import java.io.IOException;

public class PlayerJoin implements Listener {

    private Main plugin;
    public PlayerJoin(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        if(p.getWorld() == plugin.getServer().getWorld("spawn")) {

            p.playSound(p.getLocation(), Sound.MUSIC_DISC_MALL, 100, 1);

            p.getInventory().clear();
            p.getInventory().setItem(0, new ItemStack(Material.CLOCK));
            ItemMeta one = p.getInventory().getItem(0).getItemMeta();
            one.setDisplayName("Hub Selector");
            p.getInventory().getItem(0).setItemMeta(one);

            p.getInventory().setItem(1, new ItemStack(Material.COMPASS));
            ItemMeta two = p.getInventory().getItem(1).getItemMeta();
            two.setDisplayName("Game Selector");
            p.getInventory().getItem(1).setItemMeta(two);

            p.getInventory().setItem(4, new ItemStack(Material.ENDER_CHEST));
            ItemMeta five = p.getInventory().getItem(4).getItemMeta();
            five.setDisplayName("Cosmetics");
            p.getInventory().getItem(4).setItemMeta(five);

            p.getInventory().setItem(7, new ItemStack(Material.NAME_TAG));
            ItemMeta eight = p.getInventory().getItem(7).getItemMeta();
            eight.setDisplayName("Store");
            eight.addEnchant(Enchantment.LUCK, 1, true);
            p.getInventory().getItem(7).setItemMeta(eight);

            p.getInventory().setItem(8, new ItemStack(Material.BOOK));
            ItemMeta nine = p.getInventory().getItem(8).getItemMeta();
            nine.setDisplayName("Rules & How To Play");
            p.getInventory().getItem(8).setItemMeta(nine);
        }
    }

    @EventHandler
    public void JoinHandleReal(PlayerJoinEvent event){
        Player p = event.getPlayer();
        String UUID = p.getUniqueId().toString();
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("HubHandler").getDataFolder(), File.separator + "PlayerDatabase");
        File f = new File(userdata, File.separator + UUID + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);

        if (!f.exists()) {
            try {
                p.sendTitle(ChatColor.WHITE + "" + ChatColor.BOLD + "Welcome", ChatColor.WHITE + "To [ServerName]!", 40, 200, 20);
                playerData.createSection("levelling");
                playerData.set("levelling.xp", 0);
                playerData.set("levelling.level", 1);

                playerData.createSection("stats");
                playerData.set("stats.totalLogins", 1);

                playerData.createSection("crates");
                playerData.set("crates.owned", "");
                playerData.set("crates.opened", 0);
                playerData.set("crates.purchased", 0);

                playerData.createSection("rewardStats");
                playerData.set("rewardStats.daily", 0);
                playerData.set("rewardStats.dailyStreak", 0);
                playerData.set("rewardStats.voted", 0);

                playerData.createSection("rankMonthly");
                playerData.set("rankMonthly.default", false);
                playerData.set("rankMonthly.defaultClaimed", "0/0/0");



                playerData.createSection("cosmetics");

                playerData.save(f);
            } catch (IOException exception) {

                exception.printStackTrace();
            }
        } else {
            p.sendTitle(ChatColor.WHITE + "" + ChatColor.BOLD + "Welcome Back", ChatColor.WHITE + "To [ServerName]!", 20, 100, 20);
        }
    }

}
