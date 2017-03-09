package fr.trygames.poulocu.item;

import fr.trygames.poulocu.Poulocu;
import org.bukkit.Material;

public class SepaItem extends CustomItem {

    private static Material material = Material.STAINED_GLASS_PANE;
    private static int number = 1;
    private static byte data = 3;
    private static String name = " ";
    private static String[] lore = new String[]{
            "",
    };

    public static SepaItem getInstance(){
        return new SepaItem(material, number, data, name, lore, true);
    }

    private SepaItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }
}
