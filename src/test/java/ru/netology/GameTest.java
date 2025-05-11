package ru.netology;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class GameTest {
    @Test
    public void whenFirstPlayerWin() {
        Player Misha = new Player(1, "Миша", 100);
        Player Anya = new Player(2, "Аня", 50);

        Game game = new Game();

        game.register(Misha);
        game.register(Anya);

        int actual = game.round("Миша", "Аня");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenSecondPlayerWin() {
        Player Misha = new Player(1, "Миша", 100);
        Player Anya = new Player(2, "Аня", 150);

        Game game = new Game();

        game.register(Misha);
        game.register(Anya);

        int actual = game.round("Аня","Миша");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenDraw() {
        Player Misha = new Player(1, "Миша", 150);
        Player Anya = new Player(2, "Аня", 150);

        Game game = new Game();

        game.register(Misha);
        game.register(Anya);

        int actual = game.round("Аня","Миша");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotExist() {
        Player Misha = new Player(1, "Миша", 100);
        Player Anya = new Player(2, "Аня", 50);

        Game game = new Game();

        game.register(Misha);
        game.register(Anya);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Света", "Аня")
        );
    }
    @Test
    public void whenSecondPlayerNotExist() {
        Player Misha = new Player(1, "Миша", 100);
        Player Anya = new Player(2, "Аня", 50);

        Game game = new Game();

        game.register(Misha);
        game.register(Anya);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Миша", "Рома")
        );
    }

}