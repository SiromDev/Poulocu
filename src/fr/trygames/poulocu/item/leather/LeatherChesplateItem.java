package fr.trygames.poulocu.item.leather;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class LeatherChesplateItem extends CustomItem {

    private static Material material = Material.LEATHER_CHESTPLATE;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Leather chesplate";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e2 coins",
            ""
    };

    public static LeatherChesplateItem getInstance(){
        return new LeatherChesplateItem(material, number, data, name, lore, true);
    }

    private LeatherChesplateItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
