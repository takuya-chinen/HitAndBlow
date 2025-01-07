package game;

import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players;
    private int currentPlayerIndex; //プレイヤーのターンを管理するインデックス。

    public GameSystem(){
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void StartGame(){
        for (Player player : players) {
            player.setNumber();  //プレイヤーがそれぞれのナンバーを設定する。
        }
    }

    public boolean isFinishGame() {
        for (Player player : players) {
            if (player.isWinner()) { // 三つhitしたプレイヤーの確認。
                return true;
            }
        }
        return false;
    }
    
    public void takeTurn(){
        Player currentPlayer = players.get(currentPlayerIndex);
        Player opponent = players.get((currentPlayerIndex + 1) % players.size());

        System.out.println(currentPlayer.getName() + "は" + opponent.getName() + "のナンバーを予想してください！");

        int[] guess = currentPlayer.GuessNumber();
        Judgiment result = opponent.checkGuess(guess);

        System.out.println("結果: " + result);
        if (result.isTriplehit()) {
            currentPlayer.setWinner(true);
            System.out.println(currentPlayer.getName() + "が勝利しました！");
        } else {
            System.out.println("次のターンに進みます。");
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}

