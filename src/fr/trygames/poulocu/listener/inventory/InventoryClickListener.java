package fr.trygames.poulocu.listener.inventory;

import fr.trygames.poulocu.GameState;
import fr.trygames.poulocu.Poulocu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if (!Poulocu.getInstance().isState(GameState.PVP) && !Poulocu.getInstance().isState(GameState.BUY)) {
            event.setCancelled(true);
        }
        if (Poulocu.getInstance().isState(GameState.BUY)){

            ItemStack itemStack = event.getCurrentItem();

            if(itemStack != null && itemStack.getType() != Material.AIR) {
                if (event.getInventory().getTitle().contains("§b§lShop §c- §b§lCoins:")){

                    Player player = (Player) event.getWhoClicked();

                    if (itemStack.getType() != Material.STAINED_GLASS_PANE){

                        List<String> lore = itemStack.getItemMeta().getLore();
                        String line = lore.get(1);
                        String[] lineSplit = line.split(" ");

                        int price = Integer.parseInt(lineSplit[2].replace("§", "").replace("e", ""));

                        if ((Poulocu.getInstance().point.get(player) - price) < 0) {
                            player.sendMessage(Poulocu.prefix + "§7Vous n'avez pas assez de coins pour acheter: " + itemStack.getItemMeta().getDisplayName());
                            player.closeInventory();
                        } else {
                            player.sendMessage(Poulocu.prefix + "§7Vous venez d'acheter: " + itemStack.getItemMeta().getDisplayName());

                            int coins = Poulocu.getInstance().point.get(player);
                            Poulocu.getInstance().point.remove(player);
                            Poulocu.getInstance().point.put(player, coins - price);

                            player.closeInventory();

                            player.getInventory().addItem(itemStack);
                            player.updateInventory();
                        }

                    }

                    event.setCancelled(true);
                }
            }
        }
    }

}
