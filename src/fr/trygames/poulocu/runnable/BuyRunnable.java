package fr.trygames.poulocu.runnable;

import fr.trygames.poulocu.Poulocu;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BuyRunnable extends BukkitRunnable {

    int time = 60;

    @Override
    public void run() {
        if (time <= 0) {
            Poulocu.getInstance().gameManager.pvp();
            this.cancel();
            return;
        }

        if ((time == 120) || (time == 60) || (time == 30) || (time == 15) || (time == 10) || (time <= 5)) {
            Bukkit.broadcastMessage(Poulocu.prefix + "§7Le pvp commence dans §b§l" + time + " §7seconde(s)");
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "title @a title [{\"text\":\"§bPvp dans: §7" + time + " §bsec\",\"color\":\"gold\"}]");
        }

        time--;
    }

}
