package fr.trygames.poulocu.item.diamond;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class DiamondChesplateItem extends CustomItem {

    private static Material material = Material.DIAMOND_CHESTPLATE;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Diamond chesplate";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e20 coins",
            ""
    };

    public static DiamondChesplateItem getInstance(){
        return new DiamondChesplateItem(material, number, data, name, lore, true);
    }

    private DiamondChesplateItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
