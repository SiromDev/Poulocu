package fr.trygames.poulocu.item.sword;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class DiamondSwordItem extends CustomItem {

    private static Material material = Material.DIAMOND_SWORD;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Diamond sword";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e50 coins",
            ""
    };

    public static DiamondSwordItem getInstance(){
        return new DiamondSwordItem(material, number, data, name, lore, true);
    }

    private DiamondSwordItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
