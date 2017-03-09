package fr.trygames.poulocu.listener.player;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import fr.trygames.poulocu.manager.ShopManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();

        if (Poulocu.getInstance().isState(GameState.PLAYING)) {
            if (itemStack != null && itemStack.getType() == Material.STICK) {

                Vector eyeLoc = player.getEyeLocation().getDirection();
                Vector vec = new Vector(eyeLoc.getX(), eyeLoc.getY(), eyeLoc.getZ());
                vec.multiply(5f);

                player.launchProjectile(Arrow.class, vec);
            }
        } else if (Poulocu.getInstance().isState(GameState.BUY)){
            if (event.getAction() == Action.LEFT_CLICK_AIR
                    || event.getAction() == Action.LEFT_CLICK_BLOCK
                    || event.getAction() == Action.RIGHT_CLICK_AIR
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                if (itemStack != null && itemStack.getType() == Material.ENDER_PORTAL_FRAME){
                    ShopManager.open(player);
                }
            }
        }

    }

}
