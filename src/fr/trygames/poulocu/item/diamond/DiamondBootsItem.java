package fr.trygames.poulocu.item.diamond;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class DiamondBootsItem extends CustomItem {

    private static Material material = Material.DIAMOND_BOOTS;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Diamond boots";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e10 coins",
            ""
    };

    public static DiamondBootsItem getInstance(){
        return new DiamondBootsItem(material, number, data, name, lore, true);
    }

    private DiamondBootsItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
