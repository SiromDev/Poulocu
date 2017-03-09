package fr.trygames.poulocu;

import fr.trygames.poulocu.listener.ListenerManager;
import fr.trygames.poulocu.manager.GameManager;
import fr.trygames.poulocu.runnable.StartingRunnable;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poulocu extends JavaPlugin {

    private static Poulocu instance;

    public static final int maxPlayers = 8;
    public static final int minPlayers = 1;
    public static final int roundNumbers = 1;
    public static final String prefix = "§c§l(§aPoulocu§c§l) §c§l● ";
    public static Location waiting;
    public static final Location[] bases = new Location[maxPlayers];

    private GameState state = GameState.WAITING;
    public GameManager gameManager;
    public Location[] pop = new Location[maxPlayers];
    public Map<Player, Location> pLoc = new HashMap<>();
    public Map<Player, Location> basePlayers = new HashMap<>();
    public Map<Player, Integer> point = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        new ListenerManager(this).registerListeners();
        gameManager = new GameManager();

        waiting = new Location(Bukkit.getWorlds().get(0), 624.5, 9, 1847);

        bases[0] = new Location(Bukkit.getWorlds().get(0), 646.5, 9, 1853.5);
        bases[1] = new Location(Bukkit.getWorlds().get(0), 668.5, 9, 1853.5);
        bases[2] = new Location(Bukkit.getWorlds().get(0), 690.5, 9, 1853.5);
        bases[3] = new Location(Bukkit.getWorlds().get(0), 712.5, 9, 1853.5);
        bases[4] = new Location(Bukkit.getWorlds().get(0), 734.5, 9, 1853.5);
        bases[5] = new Location(Bukkit.getWorlds().get(0), 756.5, 9, 1853.5);
        bases[6] = new Location(Bukkit.getWorlds().get(0), 778.5, 9, 1853.5);
        bases[7] = new Location(Bukkit.getWorlds().get(0), 800.5, 9, 1853.5);

        double v = 1853.5 + 40;

        pop[0] = new Location(Bukkit.getWorlds().get(0), 646.5, 9, v);
        pop[1] = new Location(Bukkit.getWorlds().get(0), 668.5, 9, v);
        pop[2] = new Location(Bukkit.getWorlds().get(0), 690.5, 9, v);
        pop[3] = new Location(Bukkit.getWorlds().get(0), 712.5, 9, v);
        pop[4] = new Location(Bukkit.getWorlds().get(0), 734.5, 9, v);
        pop[5] = new Location(Bukkit.getWorlds().get(0), 756.5, 9, v);
        pop[6] = new Location(Bukkit.getWorlds().get(0), 778.5, 9, v);
        pop[7] = new Location(Bukkit.getWorlds().get(0), 800.5, 9, v);


        if (isState(GameState.WAITING) || isState(GameState.STARTING)){
            Bukkit.getWorlds().get(0).setDifficulty(Difficulty.PEACEFUL);
            Bukkit.getWorlds().get(0).setPVP(false);
        }
    }

    @Override
    public void onDisable() {

    }

    public void debug(String name, String result){
        Bukkit.broadcastMessage("§b§l" + name + "§8: §7" + result);
    }

    public GameState getState(){
        return state;
    }

    public void setState(GameState state){
        this.state = state;
    }

    public boolean isState(GameState state){
        return this.state == state;
    }

    /**
     * getter de l'instance
     * @return Instance du plugin
     */
    public static Poulocu getInstance() {
        return instance;
    }
}
