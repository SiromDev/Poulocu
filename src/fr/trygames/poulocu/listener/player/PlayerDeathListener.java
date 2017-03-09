package fr.trygames.poulocu.listener.player;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){

        Player player = event.getEntity();

        if (Poulocu.getInstance().isState(GameState.PVP)) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage(Poulocu.prefix + "§7Tu est désormait en spectateur");

            Bukkit.getScheduler().scheduleSyncDelayedTask(Poulocu.getInstance(), new Runnable() {
                @Override
                public void run() {
                    Poulocu.getInstance().gameManager.check();
                }
            }, 20L);

        }

    }

}
