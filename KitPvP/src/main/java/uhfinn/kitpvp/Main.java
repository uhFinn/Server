/*
* Author: Finn
* Latest edit: Finn
* */


package uhfinn.kitpvp;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
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
}


