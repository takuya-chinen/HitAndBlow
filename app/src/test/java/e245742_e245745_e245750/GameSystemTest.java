package e245742_e245745_e245750;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class GameSystemTest {

    @Test
    public void addPlayerTest() {
        GameSystem gameSystem = new GameSystem();
        Player player1 = new Player("プレイヤー1");
        Player player2 = new Player("プレイヤー2");

        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);

        List<Player> players = gameSystem.getPlayers();

        //playersに格納されたプレイヤーの名前を確認して正常に動作しているかをテストする。
        assertEquals("プレイヤー1", players.get(0).getName());   
        assertEquals("プレイヤー2", players.get(1).getName());
    }

    @Test
    public void isFinishGameTest() {
        GameSystem gameSystem = new GameSystem();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);

        player1.setWinner(true);

        //プレイヤー1が持つisWinnerがtrueを返すとき、ゲームが終了するかをテストする。
        assertTrue(gameSystem.isFinishGame());
    }

    @Test
    void testStartGame() {
        GameSystem gameSystem = new GameSystem();
        Player player1 = new Player("プレイヤー1");
        Player player2 = new Player("プレイヤー2");

        // プレイヤーにナンバーを直接設定
        player1.setNumber(new int[]{1, 2, 3});
        player2.setNumber(new int[]{4, 5, 6});

        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);

        gameSystem.StartGame();

        assertNotNull(player1.getNumbers());
        assertNotNull(player2.getNumbers());
    }

    @Test
    public void takeTurntest() {
        GameSystem gameSystem = new GameSystem();
        Player player1 = new Player("プレイヤー1");
        Player player2 = new Player("プレイヤー2");

        // プレイヤーにナンバーを直接設定
        player1.setNumber(new int[]{1, 2, 3});
        player2.setNumber(new int[]{4, 5, 6});
        
        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);

        player1.setGuesses(new int[]{4, 5, 6});
        player2.setGuesses(new int[]{7, 8, 9});
        
        gameSystem.takeTurn();
        
        assertTrue(player1.getIsWinner());
    }
}
