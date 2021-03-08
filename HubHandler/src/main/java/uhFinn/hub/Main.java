package uhFinn.hub;

import uhFinn.hub.Listeners.InventoryInteract;
import uhFinn.hub.Listeners.PlayerJoin;
import uhFinn.hub.Listeners.InventoryOpen;
import uhFinn.hub.Listeners.WorldChange;
import uhFinn.hub.Listeners.BlockEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new PlayerJoin(this);
        new InventoryInteract(this);
        new InventoryOpen(this);
        new WorldChange(this);
        new BlockEvent(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("fireworks")) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            int i;
            for(i = 0; i > 10; i++) {
                Bukkit.dispatchCommand(console, "summon firework_rocket 448 102 294 {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2437522,8073150,14188952,12801229],FadeColors:[I;11743532]}]}}}}");
                Bukkit.dispatchCommand(console, "summon firework_rocket 429 102 294 {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2437522,8073150,14188952,12801229],FadeColors:[I;11743532]}]}}}}");
                Bukkit.dispatchCommand(console, "summon firework_rocket 430 103 299 {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2437522,8073150,14188952,12801229],FadeColors:[I;11743532]}]}}}}");
                Bukkit.dispatchCommand(console, "summon firework_rocket 446 103 299 {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2437522,8073150,14188952,12801229],FadeColors:[I;11743532]}]}}}}");
                Bukkit.dispatchCommand(console, "summon firework_rocket 444 103 303 {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2437522,8073150,14188952,12801229],FadeColors:[I;11743532]}]}}}}");
                Bukkit.dispatchCommand(console, "summon firework_rocket 432 103 303 {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2437522,8073150,14188952,12801229],FadeColors:[I;11743532]}]}}}}");
                Bukkit.dispatchCommand(console, "summon firework_rocket 436 103 303 {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2437522,8073150,14188952,12801229],FadeColors:[I;11743532]}]}}}}");
                Bukkit.dispatchCommand(console, "summon firework_rocket 440 103 303 {LifeTime:30,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Flight:2,Explosions:[{Type:1,Flicker:1,Trail:1,Colors:[I;2437522,8073150,14188952,12801229],FadeColors:[I;11743532]}]}}}}");
            }
        }
        if(command.getName().equals("hub")){
            Player p = Bukkit.getPlayer(sender.getName());
            p.chat("/warp hub");
        }
        return false;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
