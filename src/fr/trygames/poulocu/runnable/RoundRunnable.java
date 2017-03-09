package fr.trygames.poulocu.runnable;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import fr.trygames.poulocu.item.ShopItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class RoundRunnable extends BukkitRunnable {

    int pass = 1;
    int totalRound = Poulocu.roundNumbers * 5;

    @Override
    public void run() {

        if (pass == (Poulocu.roundNumbers * 5)) {
            Poulocu.getInstance().setState(GameState.BUY);

            BuyRunnable buyRunnable = new BuyRunnable();
            buyRunnable.runTaskTimer(Poulocu.getInstance(), 20L, 20L);

            for (Player pls : Bukkit.getOnlinePlayers()){
                pls.sendMessage("§8▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");
                pls.sendMessage(Poulocu.prefix + "§7Veulliez acheter du stuff");
                pls.sendMessage(Poulocu.prefix + "§7Vous disposez de §6§l" + Poulocu.getInstance().point.get(pls) + " §7coin(s)");
                pls.sendMessage("§8▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤▤");

                pls.getInventory().clear();
                pls.getInventory().setItem(8, ShopItem.getInstance().getItemStack());
                pls.updateInventory();
            }

            this.cancel();
            return;
        }

        int i = 0;

        for (Player pls : Bukkit.getOnlinePlayers()){
            Random r = new Random();

            Chicken chicken = (Chicken) Bukkit.getWorlds().get(0).spawnEntity(Poulocu.getInstance().pop[i], EntityType.CHICKEN);

            ArmorStand armorStand = (ArmorStand) Bukkit.getWorlds().get(0).spawnEntity(Poulocu.getInstance().pop[i], EntityType.ARMOR_STAND);

            armorStand.setPassenger(chicken);

            ItemStack itemStack = new ItemStack(Material.SEA_LANTERN);
            ItemMeta itemMeta = itemStack.getItemMeta();

            armorStand.setHelmet(itemStack);
            armorStand.setVisible(false);
            armorStand.setVelocity(new Vector(r.nextFloat() - r.nextFloat(), 1.5f, -1f));

            pls.playSound(pls.getLocation(), Sound.CHICKEN_HURT, 2f, 2f);
            i = i + 1;
        }

        pass++;
        totalRound--;
    }

}
