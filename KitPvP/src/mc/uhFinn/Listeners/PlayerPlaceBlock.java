/* Author: Jonathan
 * Latest edit: Jonathan
 * */
package mc.uhFinn.Listeners;

import mc.uhFinn.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceBlock implements Listener {
    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event){
        Player p = event.getPlayer();
        if (p.getGameMode() == GameMode.SURVIVAL) {
            if(event.getBlock().getLocation().getY() > 50){
                p.sendMessage(ChatColor.RED + "You can't place blocks above Y-50");
                event.setCancelled(true);
            } else {
                //if(event.getBlockReplacedState() == Block)
                Block block = event.getBlock();
                if (block.getType() == Material.OAK_PLANKS) {
                    int time = 10 * 20;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OAK_PLANKS){
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OAK_PLANKS.createBlockData());
                            }
                        }
                    }, time - 40);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OAK_PLANKS){
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OAK_PLANKS.createBlockData());
                            }
                        }
                    }, time - 30);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OAK_PLANKS){
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OAK_PLANKS.createBlockData());
                            }
                        }
                    }, time - 20);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OAK_PLANKS){
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OAK_PLANKS.createBlockData());
                            }
                        }
                    }, time - 10);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OAK_PLANKS){
                                block.getLocation().getBlock().setType(Material.AIR);
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OAK_PLANKS.createBlockData());
                            }
                        }
                    }, time);
                    //send to a single player so only they see the explosion happen
                    //manager.sendServerPacket(p, packet);
                    //send to all players


                } else if (block.getType() == Material.OBSIDIAN) {
                    int time = 150 * 20;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OBSIDIAN){
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OBSIDIAN.createBlockData());
                            }
                        }
                    }, time - 40);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OBSIDIAN){
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OBSIDIAN.createBlockData());
                            }
                        }
                    }, time - 30);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OBSIDIAN){
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OBSIDIAN.createBlockData());
                            }
                        }
                    }, time - 20);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OBSIDIAN){
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OBSIDIAN.createBlockData());
                            }
                        }
                    }, time - 10);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            if(block.getLocation().getBlock().getType() == Material.OBSIDIAN){
                                block.getLocation().getBlock().setType(Material.AIR);
                                Bukkit.getWorld("normal").spawnParticle(Particle.BLOCK_CRACK, block.getLocation(), 20, 0.3, 0.3, 0.3, Material.OBSIDIAN.createBlockData());
                            }
                        }
                    }, time);
                    //send to a single player so only they see the explosion happen
                    //manager.sendServerPacket(p, packet);
                    //send to all players
                }
            }
        }
    }

}
