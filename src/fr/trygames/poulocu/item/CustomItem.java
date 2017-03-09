package fr.trygames.poulocu.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItem {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    private Material material;
    private int number;
    private byte data;
    private String name;
    private String[] lore;
    private List<String> loreList = new ArrayList<>();

    public CustomItem(Material material, int number, byte data, String name, String[] lore, boolean create){
        this.material = material;
        this.number = number;
        this.data = data;
        this.name = name;
        this.lore = lore;

        if (create) create();
    }

    public void create(){
        itemStack = new ItemStack(material, number, data);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        for (String line : lore) {
            loreList.add(line);
        }
        itemMeta.setLore(loreList);
        itemStack.setItemMeta(itemMeta);
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setData(byte data) {
        this.data = data;
    }

    public byte getData() {
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLore(String[] lore) {
        this.lore = lore;
    }

    public String[] getLore() {
        return lore;
    }

}
