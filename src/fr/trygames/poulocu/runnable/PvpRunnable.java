package fr.trygames.poulocu.runnable;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PvpRunnable extends BukkitRunnable {

    private int time = 10;

    @Override
    public void run() {
        if (time <= 0) {
            Poulocu.getInstance().setState(GameState.PVP);
            Bukkit.broadcastMessage(Poulocu.prefix + "§cAttention pvp actiff");
            this.cancel();
            return;
        }
        if ((time == 120) || (time == 60) || (time == 30) || (time == 15) || (time == 10) || (time <= 5)) {
            Bukkit.broadcastMessage(Poulocu.prefix + "§7Pvp actiff dans §b§l" + time + " §7seconde(s)");
        }
        time--;
    }

}
