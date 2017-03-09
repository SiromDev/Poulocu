package fr.trygames.poulocu.item.sword;

import fr.trygames.poulocu.item.CustomItem;
import org.bukkit.Material;

public class StoneSwordItem extends CustomItem {

    private static Material material = Material.STONE_SWORD;
    private static int number = 1;
    private static byte data = 0;
    private static String name = "§6Stone sword";
    private static String[] lore = new String[]{
            "",
            "§b§l➺ §aPrix: §e10 coins",
            ""
    };

    public static StoneSwordItem getInstance(){
        return new StoneSwordItem(material, number, data, name, lore, true);
    }

    private StoneSwordItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
