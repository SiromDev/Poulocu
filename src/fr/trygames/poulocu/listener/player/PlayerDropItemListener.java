package fr.trygames.poulocu.listener.player;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){

        Player player = event.getPlayer();

        if (!Poulocu.getInstance().isState(GameState.PVP) && !Poulocu.getInstance().isState(GameState.BUY)) {
            event.setCancelled(true);
        }

    }

}
