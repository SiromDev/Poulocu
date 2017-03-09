package fr.trygames.poulocu.listener.entity;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Random;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){

        Entity entity = event.getEntity();

        if (Poulocu.getInstance().isState(GameState.WAITING)
                || Poulocu.getInstance().isState(GameState.STARTING)
                || Poulocu.getInstance().isState(GameState.PLAYING)
                || Poulocu.getInstance().isState(GameState.BUY)) {
            if (entity instanceof Player) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onTest(EntityDamageByEntityEvent event){

        if (Poulocu.getInstance().isState(GameState.PLAYING)) {

            if (event.getDamager() instanceof Arrow) {
                if (event.getEntity().getType() == EntityType.ARMOR_STAND) {

                    final Arrow arrow = (Arrow) event.getDamager();
                    Player shooter = (Player) arrow.getShooter();

                    Random r = new Random();

                    int point = Poulocu.getInstance().point.get(shooter);
                    Poulocu.getInstance().point.remove(shooter);

                    int poin = r.nextInt(5);

                    if (poin == 0) poin = 1;

                    Poulocu.getInstance().point.put(shooter, point + poin);

                    shooter.playSound(shooter.getLocation(), Sound.EXPLODE, 1f, 1f);
                    event.getEntity().playEffect(EntityEffect.FIREWORK_EXPLODE);

                    Poulocu.getInstance().debug(shooter.getName(), "" + Poulocu.getInstance().point.get(shooter));
                    event.getEntity().remove();
                }
            }
        }

    }

}
