package fr.trygames.poulocu.item.leather;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class LeatherBootsItem extends CustomItem {

    private static Material material = Material.LEATHER_BOOTS;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Leather boots";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e1 coins",
            ""
    };

    public static LeatherBootsItem getInstance(){
        return new LeatherBootsItem(material, number, data, name, lore, true);
    }

    private LeatherBootsItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
