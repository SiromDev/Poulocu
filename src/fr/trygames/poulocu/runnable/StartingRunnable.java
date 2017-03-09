package fr.trygames.poulocu.runnable;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import fr.trygames.poulocu.interfaces.DefaultInterface;
import fr.trygames.poulocu.interfaces.RunnableInterface;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class StartingRunnable extends BukkitRunnable {

    public static boolean starting = false;

    private int time = 10;

    @Override
    public void run() {
        if (time <= 0) {
            Poulocu.getInstance().gameManager.start();
            this.cancel();
            return;
        }
        if ((time == 120) || (time == 60) || (time == 30) || (time == 15) || (time == 10) || (time <= 5)) {
            Bukkit.broadcastMessage(Poulocu.prefix + "§7La patrie commence dans §b§l" + time + " §7seconde(s)");
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "title @a title [{\"text\":\"§bLa partie commence dans: §7" + time + " §bsec\",\"color\":\"gold\"}]");
            for(Player pls : Bukkit.getOnlinePlayers()){
                pls.playSound(pls.getLocation(), Sound.CHICKEN_WALK, 2f, 2f);
            }
        }
        time--;
    }

}