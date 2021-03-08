/*
 * Author: Finn
 * Latest Edit: Finn
 *
 */

package uhFinn.hub.Listeners;
import org.bukkit.*;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.BookMeta;
import uhFinn.hub.Main;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryInteract implements Listener {

    private Main plugin;
    public InventoryInteract(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        Player p = event.getPlayer();
        if(p.getWorld() == plugin.getServer().getWorld("spawn")){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onMove(InventoryMoveItemEvent event){
        if(event.getSource().getLocation().getWorld() == plugin.getServer().getWorld("spawn")){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR){
            if(p.getWorld() == plugin.getServer().getWorld("spawn")){
                System.out.println("world is spawn " + p.getInventory().getItemInMainHand());
                if(p.getInventory().getItemInMainHand().getType() == Material.COMPASS){
                    Inventory inv = Bukkit.getServer().createInventory(null, 27, "Game Selector");
                    inv.setItem(13, new ItemStack(Material.DIAMOND_SWORD));
                    ItemMeta KitPVP = inv.getItem(13).getItemMeta();
                    KitPVP.setDisplayName("KitPVP");
                    inv.getItem(13).setItemMeta(KitPVP);

                    inv.setItem(11, new ItemStack(Material.SHIELD));
                    ItemMeta MegaHG = inv.getItem(11).getItemMeta();
                    MegaHG.setDisplayName("Mega HungerGames");
                    inv.getItem(11).setItemMeta(MegaHG);

                    inv.setItem(15, new ItemStack(Material.GOLD_INGOT));
                    ItemMeta PkMasters = inv.getItem(15).getItemMeta();
                    PkMasters.setDisplayName("Parkour [Blank]");
                    inv.getItem(15).setItemMeta(PkMasters);

                    p.openInventory(inv);
                }
                if(p.getInventory().getItemInMainHand().getType() == Material.CLOCK){
                    ////////////////////////////////////////////////////////////////////////////
                    Inventory inv = Bukkit.getServer().createInventory(null, 27, "Hub Selector");
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

                    inv.setItem(9, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta j = inv.getItem(9).getItemMeta();
                    j.setDisplayName(" ");
                    inv.getItem(9).setItemMeta(j);

                    inv.setItem(10, new ItemStack(Material.GOLD_INGOT));
                    ItemMeta hub01 = inv.getItem(10).getItemMeta();
                    hub01.setDisplayName(ChatColor.RESET + "" + ChatColor.WHITE + "" + ChatColor.BOLD + "Hub 2");
                    ArrayList lore1 = new ArrayList();
                    lore1.add(ChatColor.RESET + "" + ChatColor.WHITE + "Players Online: " + ChatColor.GREEN + p.getServer().getOnlinePlayers().size() + "/50");
                    lore1.add(ChatColor.RESET + "" + ChatColor.WHITE + "You Are Connected To This Server!");
                    hub01.setLore(lore1);
                    inv.getItem(10).setItemMeta(hub01);

                    inv.setItem(11, new ItemStack(Material.GOLD_NUGGET));
                    ItemMeta hub02 = inv.getItem(11).getItemMeta();
                    hub02.setDisplayName(ChatColor.RESET + "" + ChatColor.WHITE + "" + ChatColor.BOLD + "Hub 2");
                    ArrayList lore2 = new ArrayList();
                    lore2.add(ChatColor.RESET + "" + ChatColor.WHITE + "Players Online: " + ChatColor.GREEN + "0/50");
                    lore2.add(ChatColor.RESET + "" + ChatColor.RED + "" + ChatColor.BOLD + "Oops.. " + ChatColor.RESET + "" + ChatColor.RED + "It Looks Like This Server Is Down, Sorry!");
                    hub02.setLore(lore2);
                    inv.getItem(11).setItemMeta(hub02);

                    inv.setItem(12, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta k = inv.getItem(12).getItemMeta();
                    k.setDisplayName(" ");
                    inv.getItem(12).setItemMeta(k);

                    inv.setItem(13, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta l = inv.getItem(13).getItemMeta();
                    l.setDisplayName(" ");
                    inv.getItem(13).setItemMeta(l);

                    inv.setItem(14, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta m = inv.getItem(14).getItemMeta();
                    m.setDisplayName(" ");
                    inv.getItem(14).setItemMeta(m);

                    inv.setItem(15, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta n = inv.getItem(15).getItemMeta();
                    n.setDisplayName(" ");
                    inv.getItem(15).setItemMeta(n);

                    inv.setItem(16, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta o = inv.getItem(16).getItemMeta();
                    o.setDisplayName(" ");
                    inv.getItem(16).setItemMeta(o);

                    inv.setItem(17, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta pa = inv.getItem(17).getItemMeta();
                    pa.setDisplayName(" ");
                    inv.getItem(17).setItemMeta(pa);

                    inv.setItem(18, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta q = inv.getItem(18).getItemMeta();
                    q.setDisplayName(" ");
                    inv.getItem(18).setItemMeta(q);

                    inv.setItem(19, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta r = inv.getItem(19).getItemMeta();
                    r.setDisplayName(" ");
                    inv.getItem(19).setItemMeta(r);

                    inv.setItem(20, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta s = inv.getItem(20).getItemMeta();
                    s.setDisplayName(" ");
                    inv.getItem(20).setItemMeta(s);

                    inv.setItem(21, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta t = inv.getItem(21).getItemMeta();
                    t.setDisplayName(" ");
                    inv.getItem(21).setItemMeta(t);

                    inv.setItem(22, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta u = inv.getItem(22).getItemMeta();
                    u.setDisplayName(" ");
                    inv.getItem(22).setItemMeta(u);

                    inv.setItem(23, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta v = inv.getItem(23).getItemMeta();
                    v.setDisplayName(" ");
                    inv.getItem(23).setItemMeta(v);

                    inv.setItem(24, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta w = inv.getItem(24).getItemMeta();
                    w.setDisplayName(" ");
                    inv.getItem(24).setItemMeta(w);

                    inv.setItem(25, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta x = inv.getItem(25).getItemMeta();
                    x.setDisplayName(" ");
                    inv.getItem(25).setItemMeta(x);

                    inv.setItem(26, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
                    ItemMeta y = inv.getItem(26).getItemMeta();
                    y.setDisplayName(" ");
                    inv.getItem(26).setItemMeta(y);

                    p.openInventory(inv);
                    ////////////////////////////////////////////////////////////////////////////
                }
                if(p.getInventory().getItemInMainHand().getType() == Material.BOOK){
                    //The below was just for testing, no current purpose
                    List pages = new ArrayList();
                    pages.add(""); // Page 1
                    pages.add(""); // Page 2
                    pages.add(""); // Page 3
                    //The Above was just for testing, no current purpose
                    ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
                    BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
                    bookMeta.setTitle("Rules & How To Play");
                    bookMeta.setAuthor("[ServerName] Network");
                    bookMeta.setPages(pages);
                    writtenBook.setItemMeta(bookMeta);
                }
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event){
        HumanEntity p = event.getViewers().get(0);
        World world = p.getWorld();
        if(world == plugin.getServer().getWorld("spawn")){
            if(p.getGameMode() == GameMode.SURVIVAL){
                event.setCancelled(true);
            }
        }
    }

}
