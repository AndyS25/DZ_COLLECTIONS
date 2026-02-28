package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    //ArrayList<Player> players = new ArrayList<>();
    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {

        //players.add(player);
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {

        //if (findByName(playerName1) == null) {
        if (findByName(playerName1) == false) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован!"
            );
        }

        //if (findByName(playerName2) == null) {
        if (findByName(playerName2) == false) {
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован!"
            );
        }

        //Player player1 = findByName(playerName1);
        //Player player2 = findByName(playerName2);

        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    /*public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
        return players.containsKey(name);
    }*/

    public boolean findByName(String name) {

        return players.containsKey(name);
    }

}
