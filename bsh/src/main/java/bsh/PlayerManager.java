package bsh;

import java.util.HashMap;

public class PlayerManager {
    private static PlayerManager instance = new PlayerManager();

    private HashMap<Integer, Player> playerMap = new HashMap<>();

    private PlayerManager() {
    }

    public void remove(int id) {
        playerMap.remove(id);
    }

    public void add(int id, String name) {
        playerMap.put(id, new Player(id, name));
    }

    @Override
    public String toString() {
        return "PlayerManager{" +
                "playerMap=" + playerMap +
                '}';
    }

    public HashMap<Integer, Player> getPlayerMap() {
        return playerMap;
    }

    public static PlayerManager getInstance() {
        return instance;
    }
}
