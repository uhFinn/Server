/* Author: Jonathan
 * Latest edit: Jonathan
 * */
package mc.uhFinn.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;

public class PlayerDamageFromBlock implements Listener
{
    @EventHandler
    public void onEntityDamageByBlock(EntityDamageByBlockEvent event){
        if(event.getDamager() != null)
        {
            Material block = event.getDamager().getType();
            if (block == Material.SWEET_BERRY_BUSH || block == Material.MAGMA_BLOCK)
            {
                event.setCancelled(true);
            }
        }
    }
}
