package prelol.prelolscore;

import org.bukkit.plugin.java.JavaPlugin;

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
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}
