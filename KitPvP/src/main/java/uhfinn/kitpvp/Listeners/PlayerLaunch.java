/* Author: Finn
 * Latest edit: Finn
 * */
package uhfinn.kitpvp.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import uhfinn.kitpvp.Main;

/*
 * Ill be honest this code is an absolute shit show
 * Im going to be looking at methods into compressing this because honestly,
 * This is just pain to look at
 */

public class PlayerLaunch implements Listener
{
    @EventHandler
    public void playerLaunch(PlayerMoveEvent event){
        Player p = event.getPlayer();
        if(Main.INSTANCE().getActiveWorld().getBlockAt(p.getLocation()).getType() == Material.CAVE_AIR){
            final boolean[] active = {false};
            if(p.getLocation().getY() < 155){
                if(p.getLocation().getY() > 140){
                    if (active[0] == false) {
                        active[0] = true;
                        p.setInvulnerable(true);
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                            public void run() {
                                p.setInvulnerable(false);
                                active[0] = false;
                            }
                        }, 100L);
                    }
                }
            } else {
                p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1, 1);
                if (p.getLocation().getX() > 0 && p.getLocation().getZ() > 0) {
                    //Mythical Forest
                    if (active[0] == false) {
                        active[0] = true;
                        Location mythical1 = new Location(Bukkit.getWorld("normal"), 100, 14, 126);
                        Location mythical2 = new Location(Bukkit.getWorld("normal"), 84, 12, 43);
                        Location mythical3 = new Location(Bukkit.getWorld("normal"), 171, 12, 39);
                        Location mythical4 = new Location(Bukkit.getWorld("normal"), 34, 12, 137);
                        int mythical1P = Bukkit.getWorld("normal").spawnEntity(mythical1, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int mythical2P = Bukkit.getWorld("normal").spawnEntity(mythical2, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int mythical3P = Bukkit.getWorld("normal").spawnEntity(mythical3, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int mythical4P = Bukkit.getWorld("normal").spawnEntity(mythical4, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int total = mythical1P + mythical2P + mythical3P + mythical4P;
                        double random = Math.round(Math.random() * total);
                        if (random <= mythical1P) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = mythical1;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (mythical1P + mythical2P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = mythical2;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (mythical1P + mythical2P + mythical3P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = mythical3;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (mythical1P + mythical2P + mythical3P + mythical4P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = mythical4;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        }
                    }
                } else if (p.getLocation().getX() < 0 && p.getLocation().getZ() > 0) {
                    //Snow
                    if (active[0] == false) {
                        active[0] = true;
                        Location snow1 = new Location(Bukkit.getWorld("normal"), -197, 12, 51);
                        Location snow2 = new Location(Bukkit.getWorld("normal"), -121, 12, 129);
                        Location snow3 = new Location(Bukkit.getWorld("normal"), -69, 12, 67);
                        Location snow4 = new Location(Bukkit.getWorld("normal"), -17, 12, 200);
                        int snow1P = Bukkit.getWorld("normal").spawnEntity(snow1, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int snow2P = Bukkit.getWorld("normal").spawnEntity(snow2, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int snow3P = Bukkit.getWorld("normal").spawnEntity(snow3, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int snow4P = Bukkit.getWorld("normal").spawnEntity(snow4, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int total = snow1P + snow2P + snow3P + snow4P;
                        double random = Math.round(Math.random() * total);
                        if (random <= (snow1P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = snow1;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (snow1P + snow2P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = snow2;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (snow1P + snow2P + snow3P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = snow3;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (snow1P + snow2P + snow3P + snow4P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = snow4;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        }
                    }
                } else if (p.getLocation().getX() < 0 && p.getLocation().getZ() < 0) {
                    //Oriental
                    if (active[0] == false) {
                        active[0] = true;
                        Location oriental1 = new Location(Bukkit.getWorld("normal"), -38, 20, -91);
                        Location oriental2 = new Location(Bukkit.getWorld("normal"), -154, 20, -99);
                        Location oriental3 = new Location(Bukkit.getWorld("normal"), -85, 22, -105);
                        Location oriental4 = new Location(Bukkit.getWorld("normal"), -72, 16, -41);
                        int oriental1P = Bukkit.getWorld("normal").spawnEntity(oriental1, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int oriental2P = Bukkit.getWorld("normal").spawnEntity(oriental2, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int oriental3P = Bukkit.getWorld("normal").spawnEntity(oriental3, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int oriental4P = Bukkit.getWorld("normal").spawnEntity(oriental4, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int total = oriental1P + oriental2P + oriental3P + oriental4P;
                        double random = Math.round(Math.random() * total);
                        if (random <= oriental1P) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = oriental1;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (oriental1P + oriental2P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = oriental2;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (oriental1P + oriental2P + oriental3P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = oriental3;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (oriental1P + oriental2P + oriental3P + oriental4P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = oriental4;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        }
                    }
                } else if (p.getLocation().getX() > 0 && p.getLocation().getZ() < 0) {
                    //Lava
                    if (active[0] == false) {
                        active[0] = true;
                        Location lava1 = new Location(Bukkit.getWorld("normal"), 71, 12, -84);
                        Location lava2 = new Location(Bukkit.getWorld("normal"), 180, 10, -62);
                        Location lava3 = new Location(Bukkit.getWorld("normal"), 146, 12, -126);
                        Location lava4 = new Location(Bukkit.getWorld("normal"), 90, 13, -201);
                        int lava1P = Bukkit.getWorld("normal").spawnEntity(lava1, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int lava2P = Bukkit.getWorld("normal").spawnEntity(lava2, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int lava3P = Bukkit.getWorld("normal").spawnEntity(lava3, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int lava4P = Bukkit.getWorld("normal").spawnEntity(lava4, EntityType.ENDERMITE).getNearbyEntities(40, 40, 40).size() + 1;
                        int total = lava1P + lava2P + lava3P + lava4P;
                        double random = Math.round(Math.random() * total);
                        if (random <= lava1P) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = lava1;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (lava1P + lava2P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = lava2;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (lava1P + lava2P + lava3P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = lava3;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        } else if (random <= (lava1P + lava2P + lava3P + lava4P)) {
                            ArmorStand armor = (ArmorStand) Bukkit.getWorld("normal").spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                            armor.setVisible(false);
                            Location location = lava4;
                            armor.addPassenger(p);
                            armor.setVelocity(calculateVelocity(armor.getLocation().toVector(), new Location(armor.getWorld(), location.getX(), armor.getLocation().getY(), location.getZ()), 8, 1));
                            p.setInvulnerable(true);
                            BukkitRunnable runnable = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 2, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX()), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ())).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() - 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() + 1)).getType() != Material.AIR || Bukkit.getWorld("normal").getBlockAt((int) Math.round(armor.getLocation().getX() + 1), (int) Math.round(armor.getLocation().getY()) - 1, (int) Math.round(armor.getLocation().getZ() - 1)).getType() != Material.AIR) {
                                        this.cancel();
                                        p.teleport(armor.getLocation());
                                        armor.remove();
                                        p.setInvulnerable(false);
                                        active[0] = false;
                                    }
                                }
                            };
                            runnable.runTaskTimer(Main.INSTANCE(), 10, 10);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onSpawnEndermite(EntitySpawnEvent event){
        if(event.getEntity().getType() == EntityType.ENDERMITE){
            event.getEntity().remove();
        }
    }

    private static Vector calculateVelocity(Vector from, Location to, int heightGain, double Gravity)
    {
        // Gravity
        double gravity = Gravity;
        // Block locations
        int endGain = to.getBlockY() - from.getBlockY();
        double horizDist = Math.sqrt(distanceSquared(from, to.toVector()));
        // Height gain
        int gain = heightGain;
        double maxGain = gain > (endGain + gain) ? gain : (endGain + gain);
        // Solve quadratic equation for velocity
        double a = -horizDist * horizDist / (4 * maxGain);
        double b = horizDist;
        double c = -endGain;
        double slope = -b / (2 * a) - Math.sqrt(b * b - 4 * a * c) / (2 * a);
        // Vertical velocity
        double vy = Math.sqrt(maxGain * gravity);
        // Horizontal velocity
        double vh = vy / slope;
        // Calculate horizontal direction
        int dx = to.getBlockX() - from.getBlockX();
        int dz = to.getBlockZ() - from.getBlockZ();
        double mag = Math.sqrt(dx * dx + dz * dz);
        double dirx = dx / mag;
        double dirz = dz / mag;
        // Horizontal velocity components
        double vx = vh * dirx;
        double vz = vh * dirz;
        return new Vector(vx, vy, vz);
    }

    private static double distanceSquared(Vector from, Vector to)
    {
        double dx = to.getBlockX() - from.getBlockX();
        double dz = to.getBlockZ() - from.getBlockZ();
        return dx * dx + dz * dz;
    }

}
