/* Author: Jonathan
 * Latest edit: Jonathan
 * */
package uhfinn.kitpvp.Listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerPressureplateBooster implements Listener
{
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        Player p = event.getPlayer();
        if (event.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) {
            p.setVelocity(p.getEyeLocation().getDirection().multiply(17.5));
        }
    }
}
