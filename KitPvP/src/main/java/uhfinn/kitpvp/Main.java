/*
* Author: Finn
* Latest edit: Finn
* */


package uhfinn.kitpvp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import uhfinn.kitpvp.Listeners.*;

public class Main extends JavaPlugin
{
    private static Main _instance;
    public static Main INSTANCE()
    {
        return _instance;
    }

    private World activeWorld;
    public World getActiveWorld()
    {
        if(activeWorld==null)
            activeWorld= getServer().getWorld("normal");
        return activeWorld;
    }

    @Override
    public void onEnable()
    {
        _instance=this; //setup a singleton (only one exists "single")
        addListener(new PlayerBreakBlock());
        addListener(new PlayerDamageFromBlock());
        addListener(new PlayerKillBelowHeight());
        addListener(new PlayerKill());
        addListener(new PlayerLaunch());
        addListener(new PlayerPlaceBlock());
        addListener(new PlayerJoin());

        /*
         * Timing Effects
         *
         * Notes: These will give the illusion of time shifts every 10 minutes in game
         *        4 Stages: Morning, Mid-Day, Sunset, Night
         *                  Morning: Time - 1000ticks
         *                           Extras - All Redstone Lamps Turn Off
         *                  Mid-Day: Time - 6000ticks
         *                  Sunset:  Time - 12166ticks
         *                           Extras - All Redstone Lamps Turn On
         *                  Night:   Time - 18000ticks
         */

        new BukkitRunnable(){
            @Override
            public void run(){
                if(Bukkit.getWorld("normal").getTime() == 1000){ // Is Morning
                    timeShift(1000, 6000, 10, false);
                } else if(Bukkit.getWorld("normal").getTime() == 6000){ // Is Mid-Day
                    timeShift(6000, 12166, 10, true);
                } else if(Bukkit.getWorld("normal").getTime() == 12000){ // Is Sunset
                    timeShift(12166, 18000, 10, true);
                } else if(Bukkit.getWorld("normal").getTime() == 18000){ // Is Night
                    timeShift(18000, 25000, 10, false);
                }
            }
        }.runTaskTimer(this,12000, 12000);
    }

    @Override
    public void onDisable()
    {

    }

    // adds a listener.
    public void addListener(Listener listener)
    {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    private void timeShift(int fromTime, int toTime, int shiftPeriod, boolean redstoneLamps){
        //Redstone Lamps is currently not active as ill be looking into making it work in ways that don't lag the server
        long split = (toTime - fromTime) / 200;
        long currentTime = Bukkit.getWorld("normal").getTime();
        final Long[] cur = {currentTime}; // Intellij said it needed to be done, so it was done. No questions asked lol
        int i;
        for(i=0; i<200;i++)
        {
            new BukkitRunnable() {
                @Override
                public void run() {
                    cur[0] = cur[0] + split;
                    Bukkit.getWorld("normal").setTime(cur[0]);
                    if(Bukkit.getWorld("normal").getTime() == 17800) Bukkit.getWorld("normal").setTime(18000);
                }
            }.runTaskLater(this, (shiftPeriod * 20L) - i);
        }
    }
}


