package fr.trygames.poulocu.manager;

import fr.trygames.poulocu.Poulocu;
import fr.trygames.poulocu.item.*;
import fr.trygames.poulocu.item.diamond.DiamondBootsItem;
import fr.trygames.poulocu.item.diamond.DiamondChesplateItem;
import fr.trygames.poulocu.item.diamond.DiamondHelmetItem;
import fr.trygames.poulocu.item.diamond.DiamondLegingsItem;
import fr.trygames.poulocu.item.iron.IronBootsItem;
import fr.trygames.poulocu.item.iron.IronChesplateItem;
import fr.trygames.poulocu.item.iron.IronHelmetItem;
import fr.trygames.poulocu.item.iron.IronLegingsItem;
import fr.trygames.poulocu.item.leather.LeatherBootsItem;
import fr.trygames.poulocu.item.leather.LeatherChesplateItem;
import fr.trygames.poulocu.item.leather.LeatherHelmetItem;
import fr.trygames.poulocu.item.leather.LeatherLegingsItem;
import fr.trygames.poulocu.item.sword.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ShopManager {

    public static void open(Player player){
        Inventory inventory = Bukkit.createInventory(null, 6*9, "§b§lShop §c- §b§lCoins: §c§l" + Poulocu.getInstance().point.get(player));

        inventory.setItem(0, SepaItem.getInstance().getItemStack());
        inventory.setItem(1, SepaItem.getInstance().getItemStack());
        inventory.setItem(2, SepaItem.getInstance().getItemStack());
        inventory.setItem(3, SepaItem.getInstance().getItemStack());
        inventory.setItem(4, SepaItem.getInstance().getItemStack());
        inventory.setItem(5, SepaItem.getInstance().getItemStack());
        inventory.setItem(6, SepaItem.getInstance().getItemStack());
        inventory.setItem(7, SepaItem.getInstance().getItemStack());
        inventory.setItem(8, SepaItem.getInstance().getItemStack());

        inventory.setItem(9, LeatherHelmetItem.getInstance().getItemStack());
        inventory.setItem(18, LeatherChesplateItem.getInstance().getItemStack());
        inventory.setItem(27, LeatherLegingsItem.getInstance().getItemStack());
        inventory.setItem(36, LeatherBootsItem.getInstance().getItemStack());

        inventory.setItem(10, IronHelmetItem.getInstance().getItemStack());
        inventory.setItem(19, IronChesplateItem.getInstance().getItemStack());
        inventory.setItem(28, IronLegingsItem.getInstance().getItemStack());
        inventory.setItem(37, IronBootsItem.getInstance().getItemStack());

        inventory.setItem(11, DiamondHelmetItem.getInstance().getItemStack());
        inventory.setItem(20, DiamondChesplateItem.getInstance().getItemStack());
        inventory.setItem(29, DiamondLegingsItem.getInstance().getItemStack());
        inventory.setItem(38, DiamondBootsItem.getInstance().getItemStack());

        inventory.setItem(12, SepaItem.getInstance().getItemStack());
        inventory.setItem(21, SepaItem.getInstance().getItemStack());
        inventory.setItem(30, SepaItem.getInstance().getItemStack());
        inventory.setItem(39, SepaItem.getInstance().getItemStack());

        inventory.setItem(40, WoodSwordItem.getInstance().getItemStack());
        inventory.setItem(41, GoldSwordItem.getInstance().getItemStack());
        inventory.setItem(42, StoneSwordItem.getInstance().getItemStack());
        inventory.setItem(43, IronSwordItem.getInstance().getItemStack());
        inventory.setItem(44, DiamondSwordItem.getInstance().getItemStack());

        inventory.setItem(45, SepaItem.getInstance().getItemStack());
        inventory.setItem(46, SepaItem.getInstance().getItemStack());
        inventory.setItem(47, SepaItem.getInstance().getItemStack());
        inventory.setItem(48, SepaItem.getInstance().getItemStack());
        inventory.setItem(49, SepaItem.getInstance().getItemStack());
        inventory.setItem(50, SepaItem.getInstance().getItemStack());
        inventory.setItem(51, SepaItem.getInstance().getItemStack());
        inventory.setItem(52, SepaItem.getInstance().getItemStack());
        inventory.setItem(53, SepaItem.getInstance().getItemStack());

        player.openInventory(inventory);
    }

}
