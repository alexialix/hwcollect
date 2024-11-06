package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void shouldReturn1WhenFirstPlayerWins() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 20);
        Player player2 = new Player(2, "Bob", 10);

        game.register(player1);
        game.register(player2);

        int result = game.round("Alice", "Bob");
        assertEquals(1, result); // Ожидаем, что первый игрок выиграет
    }

    @Test
    public void shouldReturn2WhenSecondPlayerWins() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 10);
        Player player2 = new Player(2, "Bob", 20);

        game.register(player1);
        game.register(player2);

        int result = game.round("Alice", "Bob");
        assertEquals(2, result); // Ожидаем, что второй игрок выиграет
    }

    @Test
    public void shouldReturn0WhenPlayersTie() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 15);
        Player player2 = new Player(2, "Bob", 15);

        game.register(player1);
        game.register(player2);

        int result = game.round("Alice", "Bob");
        assertEquals(0, result); // Ожидаем ничью
    }

    @Test
    public void shouldThrowNotRegisteredExceptionForFirstPlayer() {
        Game game = new Game();
        Player player2 = new Player(2, "Bob", 20);

        game.register(player2);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Alice", "Bob");
        });
    }

    @Test
    public void shouldThrowNotRegisteredExceptionForSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 20);

        game.register(player1);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Alice", "Bob");
        });
    }

    @Test
    public void shouldReturnRegisteredPlayers() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 20);
        Player player2 = new Player(2, "Bob", 10);

        game.register(player1);
        game.register(player2);

        assertEquals(2, game.getRegisteredPlayers().size()); // Проверяем количество зарегистрированных игроков
    }

    @Test
    public void shouldTestPlayerEqualsAndHashCode() {
        Player player1 = new Player(1, "Alice", 20);
        Player player2 = new Player(1, "Alice", 20);
        Player player3 = new Player(2, "Bob", 30);

        assertEquals(player1, player2); // Проверяем равенство двух одинаковых игроков
        assertNotEquals(player1, player3); // Проверяем, что разные игроки не равны
        assertEquals(player1.hashCode(), player2.hashCode()); // Проверяем, что одинаковые игроки имеют одинаковый hashCode
    }

    @Test
    public void shouldReturnPlayerId() {
        Player player = new Player(1, "Alice", 20);
        assertEquals(1, player.getId()); // Проверяем, что возвращается правильный id
    }
}
