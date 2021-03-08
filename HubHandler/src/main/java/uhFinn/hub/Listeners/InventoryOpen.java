/*
 * Author: Finn
 * Latest Edit: Finn
 *
 */

package uhFinn.hub.Listeners;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
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

public class InventoryOpen implements Listener {

    private Main plugin;
    public InventoryOpen(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onOpenChest(InventoryOpenEvent event){
        if(event.getInventory().getType() == InventoryType.ENDER_CHEST){
            Player p = (Player) event.getPlayer();
            if(p.getWorld() == plugin.getServer().getWorld("spawn")){
                event.setCancelled(true);
                Inventory inv = Bukkit.getServer().createInventory(null, 54, "Loot Crates");
                inv.setItem(0, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta a = inv.getItem(0).getItemMeta();
                a.setDisplayName(" ");
                inv.getItem(0).setItemMeta(a);

                inv.setItem(1, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta b = inv.getItem(1).getItemMeta();
                b.setDisplayName(" ");
                inv.getItem(1).setItemMeta(b);

                inv.setItem(2, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta c = inv.getItem(2).getItemMeta();
                c.setDisplayName(" ");
                inv.getItem(2).setItemMeta(c);

                inv.setItem(3, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta d = inv.getItem(3).getItemMeta();
                d.setDisplayName(" ");
                inv.getItem(3).setItemMeta(d);

                inv.setItem(4, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta e = inv.getItem(4).getItemMeta();
                e.setDisplayName(" ");
                inv.getItem(4).setItemMeta(e);

                inv.setItem(5, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta f = inv.getItem(5).getItemMeta();
                f.setDisplayName(" ");
                inv.getItem(5).setItemMeta(f);

                inv.setItem(6, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta g = inv.getItem(6).getItemMeta();
                g.setDisplayName(" ");
                inv.getItem(6).setItemMeta(g);

                inv.setItem(7, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta h = inv.getItem(7).getItemMeta();
                h.setDisplayName(" ");
                inv.getItem(7).setItemMeta(h);

                inv.setItem(8, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta i = inv.getItem(8).getItemMeta();
                i.setDisplayName(" ");
                inv.getItem(8).setItemMeta(i);

                //////////////////////



                //////////////////////

                inv.setItem(36, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta j = inv.getItem(36).getItemMeta();
                j.setDisplayName(" ");
                inv.getItem(36).setItemMeta(j);

                inv.setItem(37, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta k = inv.getItem(37).getItemMeta();
                k.setDisplayName(" ");
                inv.getItem(37).setItemMeta(k);

                inv.setItem(38, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta l = inv.getItem(38).getItemMeta();
                l.setDisplayName(" ");
                inv.getItem(38).setItemMeta(l);

                inv.setItem(39, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta m = inv.getItem(39).getItemMeta();
                m.setDisplayName(" ");
                inv.getItem(39).setItemMeta(m);

                inv.setItem(40, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta n = inv.getItem(40).getItemMeta();
                n.setDisplayName(" ");
                inv.getItem(40).setItemMeta(n);

                inv.setItem(41, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta o = inv.getItem(41).getItemMeta();
                o.setDisplayName(" ");
                inv.getItem(41).setItemMeta(o);

                inv.setItem(42, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta pa = inv.getItem(42).getItemMeta();
                pa.setDisplayName(" ");
                inv.getItem(42).setItemMeta(pa);

                inv.setItem(43, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta q = inv.getItem(43).getItemMeta();
                q.setDisplayName(" ");
                inv.getItem(43).setItemMeta(q);

                inv.setItem(44, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                ItemMeta r = inv.getItem(44).getItemMeta();
                r.setDisplayName(" ");
                inv.getItem(44).setItemMeta(r);

                p.openInventory(inv);
            }
        }
    }

}
