/* Author: Jonathan
 * Latest edit: Jonathan
 * */
package uhfinn.kitpvp.Listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import uhfinn.kitpvp.Main;

public class PlayerKillBelowHeight implements Listener
{
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        Player p = (Player) event.getPlayer();
        Location loc = p.getLocation();
        if(loc.getY() < 7){
            if(loc.getWorld() == Main.INSTANCE().getActiveWorld()) {
                p.setHealth(0);
            }
        }
    }
}
