package fr.trygames.poulocu.item.iron;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class IronChesplateItem extends CustomItem {

    private static Material material = Material.IRON_CHESTPLATE;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Iron chesplate";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e10 coins",
            ""
    };

    public static IronChesplateItem getInstance(){
        return new IronChesplateItem(material, number, data, name, lore, true);
    }

    private IronChesplateItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
