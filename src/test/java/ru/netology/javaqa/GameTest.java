package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Hulk", 150);
    Player player2 = new Player(2, "SpiderMan", 50);
    Player player3 = new Player(3, "Batman", 90);
    Player player4 = new Player(4, "IranMan", 150);
    Player player5 = new Player(5, "SuperMan", 200);
    Player player6 = new Player(6, "LedyBug", 30);

    @Test
    public void shouldFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);

        Assertions.assertEquals(player3, game.findByName(player3.getName()));
    }

    @Test
    public void shouldNotRegisterPlayer1() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Noname", player2.getName());
        });
    }

    @Test
    public void shouldNotRegisterPlayer2() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), "Noname");
        });
    }

    @Test
    public void shouldWinFirstPlayer() {
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round(player1.getName(), player2.getName()));
    }

    @Test
    public void shouldWinSecondPlayer() {
        game.register(player5);
        game.register(player6);

        Assertions.assertEquals(2, game.round(player6.getName(), player5.getName()));
    }

    @Test
    public void shouldDrawRound() {
        game.register(player1);
        game.register(player4);

        Assertions.assertEquals(0, game.round(player1.getName(), player4.getName()));
    }


}
