package fr.trygames.poulocu.item.iron;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class IronHelmetItem extends CustomItem {

    private static Material material = Material.IRON_HELMET;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Iron helmet";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e5 coins",
            ""
    };

    public static IronHelmetItem getInstance(){
        return new IronHelmetItem(material, number, data, name, lore, true);
    }

    private IronHelmetItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
