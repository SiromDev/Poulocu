package fr.trygames.poulocu.listener.player;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){

        Player player = event.getPlayer();
        Location location = player.getLocation();

        if (player.getGameMode() == GameMode.ADVENTURE) {
            if (Poulocu.getInstance().isState(GameState.WAITING) || Poulocu.getInstance().isState(GameState.STARTING) || Poulocu.getInstance().isState(GameState.BUY)) {
                if (location.getY() <= 0){
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "title " + player.getName() + " title [{\"text\":\"§6§lNe téloigne pas trop!\",\"color\":\"gold\"}]");
                    player.sendMessage(Poulocu.prefix + "§7Bouge pas une poule invisible vient te ramener des ténébre!");
                    player.teleport(Poulocu.waiting);
                }
            } else if (Poulocu.getInstance().isState(GameState.PLAYING)) {
                if (location.getY() <= 0){
                    player.teleport(Poulocu.getInstance().basePlayers.get(player));
                }
            }
        }

    }

}
