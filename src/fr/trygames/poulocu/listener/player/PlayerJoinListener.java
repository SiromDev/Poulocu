package fr.trygames.poulocu.listener.player;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import fr.trygames.poulocu.runnable.StartingRunnable;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (Poulocu.getInstance().isState(GameState.WAITING) || Poulocu.getInstance().isState(GameState.STARTING)) {
            if (Bukkit.getOnlinePlayers().size() > Poulocu.maxPlayers){
                player.kickPlayer("§e§lLa partie est actuéllement pleine");
            } else {

                Bukkit.broadcastMessage(Poulocu.prefix + "§b§l" + player.getName() + " §7a rejoint §c§l● §7[§b" + Bukkit.getOnlinePlayers().size() + "§7/§b" + Poulocu.maxPlayers + "§7]");
                player.setGameMode(GameMode.ADVENTURE);
                player.teleport(Poulocu.waiting);

                player.getInventory().clear();

                player.getInventory().setHelmet(null);
                player.getInventory().setChestplate(null);
                player.getInventory().setLeggings(null);
                player.getInventory().setBoots(null);

                player.updateInventory();

                if (!StartingRunnable.starting){
                    if (Bukkit.getOnlinePlayers().size() >= Poulocu.minPlayers) {
                        Poulocu.getInstance().setState(GameState.STARTING);

                        StartingRunnable runnable = new StartingRunnable();
                        runnable.runTaskTimer(Poulocu.getInstance(), 20L, 20L);
                        StartingRunnable.starting = true;
                    }
                }

            }
        } else if (Poulocu.getInstance().isState(GameState.PLAYING)) {
            player.kickPlayer("§e§lLa partie est déjat commencée");
        } else {
            player.kickPlayer("§e§lLa se términe veuiller patienter");
        }

        event.setJoinMessage(null);
    }

    @EventHandler
    public void test(PlayerChatEvent event){

        Player player = event.getPlayer();

        if (Bukkit.getOnlinePlayers().size() > Poulocu.maxPlayers){
            event.setMessage(null);
            player.kickPlayer("§e§lLa partie est actuéllement pleine");
        } else {
            Bukkit.broadcastMessage("§b" + player.getName() + "§c: §7" + event.getMessage());
            event.setCancelled(true);
        }
    }

}
