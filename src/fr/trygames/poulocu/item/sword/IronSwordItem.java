package fr.trygames.poulocu.item.sword;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class IronSwordItem extends CustomItem {

    private static Material material = Material.IRON_SWORD;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Iron sword";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e25 coins",
            ""
    };

    public static IronSwordItem getInstance(){
        return new IronSwordItem(material, number, data, name, lore, true);
    }

    private IronSwordItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
