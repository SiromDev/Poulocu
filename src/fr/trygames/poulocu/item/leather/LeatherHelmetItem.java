package fr.trygames.poulocu.item.leather;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class LeatherHelmetItem extends CustomItem {

    private static Material material = Material.LEATHER_HELMET;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Leather helmet";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e1 coins",
            ""
    };

    public static LeatherHelmetItem getInstance(){
        return new LeatherHelmetItem(material, number, data, name, lore, true);
    }

    private LeatherHelmetItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
