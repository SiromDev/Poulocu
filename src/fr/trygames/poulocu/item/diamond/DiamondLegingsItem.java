package fr.trygames.poulocu.item.diamond;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class DiamondLegingsItem extends CustomItem {

    private static Material material = Material.DIAMOND_LEGGINGS;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Diamond leggings";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e14 coins",
            ""
    };

    public static DiamondLegingsItem getInstance(){
        return new DiamondLegingsItem(material, number, data, name, lore, true);
    }

    private DiamondLegingsItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
