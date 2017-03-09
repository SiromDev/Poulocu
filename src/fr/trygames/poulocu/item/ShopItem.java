package fr.trygames.poulocu.item;

import fr.trygames.poulocu.Poulocu;
import org.bukkit.Material;

public class ShopItem extends CustomItem {

    private static Material material = Material.ENDER_PORTAL_FRAME;
    private static int number = 1;
    private static byte data = 0;
    private static String name = Poulocu.prefix + "§7Boutique";
    private static String[] lore = new String[]{
            "",
            "§6§l▶ §7Ici vous pourez acheter du stuff",
            "§6§l▶ §7Avec l'est coins gagniez au cours de",
            "§6§l▶ §7Votre partie! §6Bon achat(s) ✅",
            ""
    };

    public static ShopItem getInstance(){
        return new ShopItem(material, number, data, name, lore, true);
    }

    private ShopItem(Material material, int number, byte data, String name, String[] lore, boolean create) {
        super(material, number, data, name, lore, create);
    }

}
