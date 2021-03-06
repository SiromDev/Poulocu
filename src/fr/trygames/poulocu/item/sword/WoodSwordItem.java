package fr.trygames.poulocu.item.sword;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class WoodSwordItem extends CustomItem {

    private static Material material = Material.WOOD_SWORD;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Wood sword";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e5 coins",
            ""
    };

    public static WoodSwordItem getInstance(){
        return new WoodSwordItem(material, number, data, name, lore, true);
    }

    private WoodSwordItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
