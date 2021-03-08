/* Author: Jonathan
 * Latest edit: Jonathan
 * */
package uhfinn.kitpvp.Listeners;

import mc.uhFinn.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakBlock implements Listener
{
    @EventHandler
    public void onBreakBlock(BlockBreakEvent event){
        Player p = event.getPlayer();
        if(p.getGameMode() == GameMode.SURVIVAL && p.getWorld() == Main.INSTANCE().getActiveWorld()){
            event.setCancelled(true);
        }
    }
}
