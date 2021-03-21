/* Author: Finn
 * Latest edit: Finn
 * */
package uhfinn.kitpvp.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.*;
import uhfinn.kitpvp.Main;

public class PlayerJoin implements Listener
{
    @EventHandler
    public void join(PlayerJoinEvent event){
        Player player = event.getPlayer();

        ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard b = m.getNewScoreboard();

        Objective objective = b.registerNewObjective("Scoreboard", "");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.DARK_AQUA + "    [ServerName] KitPVP    ");

        Score slot1 = objective.getScore(" ");
        slot1.setScore(7);
        Score slot2 = objective.getScore(ChatColor.WHITE + "Your Level: " + "{Level}");
        slot2.setScore(6);
        Score slot3 = objective.getScore(ChatColor.WHITE + "Your Money: " + "{Money}");
        slot3.setScore(5);
        Score slot4 = objective.getScore(ChatColor.WHITE + "Your Kills: " + "{Kills}");
        slot4.setScore(4);
        Score slot5 = objective.getScore(ChatColor.WHITE + "Your Rank: " + "#{FormattedRank}");
        slot5.setScore(3);
        Score slot6 = objective.getScore(" ");
        slot6.setScore(2);
        Score slot7 = objective.getScore("[Server IP]");
        slot7.setScore(1);

        player.setScoreboard(b);


    }
    //May Be Temporary
    @EventHandler
    public void onHunger(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }
    //
}
