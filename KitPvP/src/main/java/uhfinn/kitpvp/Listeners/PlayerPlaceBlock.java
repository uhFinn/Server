/* Author: Finn
 * Latest edit: Finn
 * */
package uhfinn.kitpvp.Listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import uhfinn.kitpvp.Main;

public class PlayerPlaceBlock implements Listener {
    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event){
        Player p = event.getPlayer();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            if (event.getBlock().getLocation().getY() > 50) {
                p.sendMessage(ChatColor.DARK_RED + "You can't place blocks above Y-50");
                event.setCancelled(true);
            } else {
                Block block = event.getBlock();
                switch (block.getType()) {
                    case OAK_PLANKS:
                        scheduleBreaking(block, 10 * 20, event.getBlockReplacedState().getType());
                        break;
                    case OBSIDIAN:
                        scheduleBreaking(block, 150 * 20, event.getBlockReplacedState().getType());
                        break;
                }
            }
        }
    }
    private void scheduleBreaking(Block block, int ticks, Material replaceType)
    {
        //warning shots getting setup here.
        for(int i=0;i<50;i+=10)
        {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                public void run() {
                    if(block.getLocation().getBlock().getType() == block.getType()){
                        Main.INSTANCE().getActiveWorld().spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, block.getType().createBlockData());
                    }
                }
            }, ticks - i);
        }
        //final breaking.
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
            public void run() {
                if(block.getLocation().getBlock().getType() == block.getType()){
                    block.getLocation().getBlock().setType(replaceType);
                }
            }
        }, ticks);
    }

}
