package game;

public class Main {
    public static void main(String[] args) {
        GameSystem gameSystem = new GameSystem();

        // プレイヤを追加する。
        gameSystem.addPlayer(new Player("プレイヤー1"));
        gameSystem.addPlayer(new Player("プレイヤー2"));

        gameSystem.StartGame();

        while (!gameSystem.isFinishGame()) {
            gameSystem.takeTurn();
        }

        System.out.println("ゲーム終了！お疲れ様でした！");
    }
}