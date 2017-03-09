package fr.trygames.poulocu.item.iron;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class IronLegingsItem extends CustomItem {

    private static Material material = Material.IRON_LEGGINGS;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Iron leggings";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e7 coins",
            ""
    };

    public static IronLegingsItem getInstance(){
        return new IronLegingsItem(material, number, data, name, lore, true);
    }

    private IronLegingsItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
