package kitpvp;
import Listener.Listening;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public final class me extends JavaPlugin  implements Listener {

    public static Economy economy = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        new Listening(this);

        setupEconomy();
        System.out.println(economy);

        if (!setupEconomy() ) {
            System.out.println("Disabled due to no Vault dependency found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public static Economy getEconomy() {
        return economy;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
