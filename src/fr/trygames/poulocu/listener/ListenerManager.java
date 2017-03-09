package fr.trygames.poulocu.listener;

import fr.trygames.poulocu.listener.entity.EntityDamageListener;
import fr.trygames.poulocu.listener.inventory.InventoryClickListener;
import fr.trygames.poulocu.listener.player.*;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {

    private Plugin plugin;
    private PluginManager pluginManager;

    /**
     * Constructor de ListenerManager
     * @param plugin Instance du plugin
     */
    public ListenerManager(Plugin plugin){
        this.plugin = plugin;
        this.pluginManager = Bukkit.getPluginManager();
    }

    /**
     * Register des listeners
     */
    public void registerListeners(){
        // PLAYER
        pluginManager.registerEvents(new PlayerJoinListener(), plugin);
        pluginManager.registerEvents(new PlayerMoveListener(), plugin);
        pluginManager.registerEvents(new PlayerDropItemListener(), plugin);
        pluginManager.registerEvents(new PlayerInteractListener(), plugin);
        pluginManager.registerEvents(new PlayerDeathListener(), plugin);

        // INVENTORY
        pluginManager.registerEvents(new InventoryClickListener(), plugin);

        // ENTITY
        pluginManager.registerEvents(new EntityDamageListener(), plugin);
    }

}
