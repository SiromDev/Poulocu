package fr.trygames.poulocu.item.leather;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class LeatherLegingsItem extends CustomItem {

    private static Material material = Material.LEATHER_LEGGINGS;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Leather leggings";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e2 coins",
            ""
    };

    public static LeatherLegingsItem getInstance(){
        return new LeatherLegingsItem(material, number, data, name, lore, true);
    }

    private LeatherLegingsItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
