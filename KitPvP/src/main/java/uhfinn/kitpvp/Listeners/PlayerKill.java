/* Author: Finn
 * Latest edit: Finn
 *
 * Notes: The idea for this is to not essentially make the user go through the respawn process as that statistically is more likely to make them leave as it contains the go to title screen
 *        option, Instead it notably makes them know they are dead but respawns them after 3-ish seconds | This needs testing as I see some potential bugs
 * */
package uhfinn.kitpvp.Listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import uhfinn.kitpvp.Main;

public class PlayerKill implements Listener
{

    Location respawnLocation = new Location(Bukkit.getWorld("normal"), -21, 159, -1, 270, 0);

    @EventHandler
    public void PlayerDamageEvent(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player damaged = (Player) event.getEntity();
            if(damaged.getHealth() < 1){
                event.setCancelled(true); // Prevents the player from 'officially' dying
                damaged.setInvulnerable(true);
                damaged.setGameMode(GameMode.SPECTATOR);

                Location deathView = damaged.getLocation();
                deathView.setY(deathView.getY() + 1.5);
                damaged.teleport(deathView); //Shows a more appropriate, wider angle of where the player died
                //Might set the above to a velocity in the near future to give a nicer effect

                if(event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || event.getCause() == EntityDamageEvent.DamageCause.THORNS){
                    //When A player killed
                    EntityDamageByEntityEvent entityEvent = (EntityDamageByEntityEvent) event;
                    Player damager = (Player) entityEvent.getDamager();

                    //// Damaged player handling ////
                    damaged.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "DEATH >  " + ChatColor.WHITE + "You died to " + event.getCause().name().toLowerCase() + "!"); // Chat Message, May change this later | DEATH >  You died to lava!
                    damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 5 Seconds", 10, 20, 0);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 4 Seconds", 0, 20, 0);
                        }
                    }, 30L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 3 Seconds", 0, 20, 0);
                        }
                    }, 50L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 2 Seconds", 0, 20, 0);
                        }
                    }, 70L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 1 Seconds", 0, 20, 0);
                        }
                    }, 90L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.teleport(respawnLocation); damaged.setGameMode(GameMode.SURVIVAL); damaged.setInvulnerable(false);
                        }
                    }, 110L);

                    //// Damager player handling ////

                    damager.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Kill >  " + ChatColor.WHITE + "You killed " + damaged.getName() + "and earned {CurrencySymbol}5");
                    //Ill implement the SQL for this soon

                } else {

                    //Damage of other causes (E.G. Lava)
                    damaged.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "DEATH >  " + ChatColor.WHITE + "You died to " + event.getCause().name().toLowerCase() + "!"); // Chat Message, May change this later | DEATH >  You died to lava!
                    damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 5 Seconds", 10, 20, 0);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 4 Seconds", 0, 20, 0);
                        }
                    }, 30L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 3 Seconds", 0, 20, 0);
                        }
                    }, 50L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 2 Seconds", 0, 20, 0);
                        }
                    }, 70L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.sendTitle(ChatColor.RED + "Respawning", ChatColor.WHITE + "Respawning in 1 Seconds", 0, 20, 0);
                        }
                    }, 90L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE(), new Runnable() {
                        public void run() {
                            damaged.teleport(respawnLocation); damaged.setGameMode(GameMode.SURVIVAL); damaged.setInvulnerable(false);
                        }
                    }, 110L);
                    /*
                     * There has to be a more efficient way to do the above,
                     * If so please tell me lol
                     *
                     * Other Notes: Plans for a paid rank to be able to bypass the respawn cool down, This follows EULA
                     */
                }
            }
        }
    }
}

//Random Notes: Spawn coords: -21 159 -1 270 0