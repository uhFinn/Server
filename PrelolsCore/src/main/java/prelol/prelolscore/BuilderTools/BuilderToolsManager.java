package prelol.prelolscore.BuilderTools;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;

public class BuilderToolsManager implements Listener
{
    private static BuilderToolsManager _btregionmanager;
    public  static BuilderToolsManager Instance()
    {
        if(_btregionmanager ==null)
            _btregionmanager =new BuilderToolsManager();
        return _btregionmanager;
    }

    private HashMap<UUID, Location> pos1 = new HashMap<>();
    private HashMap<UUID, Location> pos2 = new HashMap<>();
    public void setPos1(UUID player,Location pos)
    {
        pos1.put(player, pos);
    }
    public void setPos2(UUID player,Location pos)
    {
        pos2.put(player, pos);
    }
    public Location getPos1(UUID player)
    {
        return pos1.get(player);
    }
    public Location getPos2(UUID player)
    {
        return pos2.get(player);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onUseEvent(PlayerInteractEvent e)
    {
        if(!e.getPlayer().hasPermission("prelolscore.build")&&!e.getPlayer().isOp())
            return;

        if(e.getAction()== Action.LEFT_CLICK_BLOCK)
        {
            if(e.getMaterial()== Material.STICK)
            {
                setPos1(e.getPlayer().getUniqueId(),e.getClickedBlock().getLocation());
                e.getPlayer().sendMessage(ChatColor.GREEN+"Set pos 1");
                e.setCancelled(true);
            }
        }
        if(e.getAction()== Action.RIGHT_CLICK_BLOCK)
        {
            if(e.getMaterial()== Material.STICK)
            {
                setPos2(e.getPlayer().getUniqueId(),e.getClickedBlock().getLocation());
                e.getPlayer().sendMessage(ChatColor.GREEN+"Set pos 2");
                e.setCancelled(true);
            }
        }
    }
}
