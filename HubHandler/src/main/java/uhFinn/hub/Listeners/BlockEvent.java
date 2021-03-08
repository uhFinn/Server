/*
 * Author: Finn
 * Latest Edit: Finn
 *
 */

package uhFinn.hub.Listeners;
import org.bukkit.GameMode;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
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

public class BlockEvent implements Listener {

    private Main plugin;
    public BlockEvent(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        Player p = event.getPlayer();
        if(p.getWorld() == plugin.getServer().getWorld("spawn")){
            if(p.getGameMode() == GameMode.SURVIVAL){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player p = event.getPlayer();
        if(p.getWorld() == plugin.getServer().getWorld("spawn")){
            if(p.getGameMode() == GameMode.SURVIVAL){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onExplosion(ExplosionPrimeEvent event){
        if(event.getEntity().getWorld() == plugin.getServer().getWorld("spawn")){
            event.setCancelled(true);
        }
    }



}
