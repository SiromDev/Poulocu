package fr.trygames.poulocu.manager;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import fr.trygames.poulocu.item.GunItem;
import fr.trygames.poulocu.runnable.PvpRunnable;
import fr.trygames.poulocu.runnable.RoundRunnable;
import fr.trygames.poulocu.runnable.StartingRunnable;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class GameManager {

    public GameManager(){

    }

    public void start(){
        Bukkit.broadcastMessage(Poulocu.prefix + "§aLa partie viens de commencé!");
        Poulocu.getInstance().setState(GameState.PLAYING);
        teleportAll(Poulocu.bases, GameMode.ADVENTURE);

        setInventory();

        for(Player pls : Bukkit.getOnlinePlayers()){
            pls.playSound(pls.getLocation(), Sound.CHICKEN_HURT, 2f, 2f);
            Poulocu.getInstance().point.put(pls, 0);
        }

        RoundRunnable roundRunnable = new RoundRunnable();
        roundRunnable.runTaskTimer(Poulocu.getInstance(), 100L, 100L);
    }

    public void pvp(){
        Bukkit.getWorlds().get(0).setPVP(true);
        Bukkit.getWorlds().get(0).setDifficulty(Difficulty.NORMAL);

        PvpRunnable pvpRunnable = new PvpRunnable();
        pvpRunnable.runTaskTimer(Poulocu.getInstance(), 20L, 20L);

        for (Player pls : Bukkit.getOnlinePlayers()){
            pls.teleport(new Location(Bukkit.getWorlds().get(0), 546.5, 15, 1888.5));
        }
    }

    public void check(){
        int n = 0;
        for (Player pls : Bukkit.getOnlinePlayers()){
            if (pls.getGameMode() == GameMode.ADVENTURE){
                Bukkit.broadcastMessage("yep");
                n = n + 1;
            }
        }
        if (n == 1) {
            Bukkit.broadcastMessage("yop");
            end();
        }
    }

    public void end(){
        for (Player pls : Bukkit.getOnlinePlayers()){
            if (pls.getGameMode() == GameMode.ADVENTURE){
                pls.sendMessage("§8▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
                Bukkit.broadcastMessage(Poulocu.prefix + "§6§l" + pls.getName() + " §aA gagniez la partie le serveur vas redémarer!");
                pls.sendMessage("§8▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
            }
        }

        Bukkit.getMessenger().registerOutgoingPluginChannel(Poulocu.getInstance(), "BungeeCord");
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF("hub");

        Bukkit.getScheduler().scheduleSyncDelayedTask(Poulocu.getInstance(), new Runnable() {
            @Override
            public void run() {
                for (Player pls : Bukkit.getOnlinePlayers()){
                    pls.sendMessage("§8▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
                    pls.sendMessage(Poulocu.prefix + "§6§l" + pls.getName() + " §7Vous avez gagnier §8§l0 §7TryCoins");
                    pls.sendMessage("§8▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
                    pls.sendPluginMessage(Poulocu.getInstance(), "BungeeCord", out.toByteArray());
                }

                Bukkit.getScheduler().scheduleSyncDelayedTask(Poulocu.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "restart");
                    }
                }, 10L);

            }
        }, 100L);
    }

    public void stop(){

    }

    public void setInventory(){
        for (Player pls : Bukkit.getOnlinePlayers()){
            pls.getInventory().clear();
            pls.getInventory().setItem(4, GunItem.getInstance().getItemStack());
            pls.updateInventory();
        }
    }

    public void teleportAll(Location[] locations, GameMode gameMode){

        int i = 0;

        for (Player pls : Bukkit.getOnlinePlayers()){
            if (pls.getGameMode() == gameMode){
                Poulocu.getInstance().pLoc.put(pls, locations[i]);
                pls.teleport(locations[i]);
                Poulocu.getInstance().basePlayers.put(pls, locations[i]);
                i++;
            }
        }

    }

}
