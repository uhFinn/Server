/*
* Author: Jonathan Boes
* All packages containing the word "prelol" are property of the Author mentioned above.
* Decompiling and/or editing of this packages is prohibited without written permission from the Author mentioned above.
*
* By obtaining a copy of this plugin you agree to the terms written above.
* */

package prelol.prelolscore;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import prelol.prelolscore.BuilderTools.BuilderToolsManager;
import prelol.prelolscore.Command.CommandListener;

public final class Main extends JavaPlugin
{
    private static Main _instance;
    public static Main Instance()
    {
        return _instance;
    }

    @Override
    public void onEnable()
    {
        _instance=this;

        addListener(new CommandListener());
        addListener(new BuilderToolsManager());
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }

    // adds a listener.
    public void addListener(Listener listener)
    {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }
}
