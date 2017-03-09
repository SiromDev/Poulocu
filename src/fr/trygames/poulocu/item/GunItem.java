package fr.trygames.poulocu.item;

import fr.trygames.poulocu.Poulocu;
import org.bukkit.Material;

public class GunItem extends CustomItem {

    private static Material material = Material.STICK;
    private static int number = 1;
    private static byte data = 0;
    private static String name = Poulocu.prefix + "§7Gun";
    private static String[] lore = new String[]{
            "",
            "§6Puissance: §b§l1",
            "§6Portée: §b§l1",
            ""
    };

    public static GunItem getInstance(){
        return new GunItem(material, number, data, name, lore, true);
    }

    private GunItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
