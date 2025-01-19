package e245742_e245745_e245750;

import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private List<Player> players;
    private int currentPlayerIndex; // プレイヤーのターンを管理するインデックス。

    public GameSystem() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void StartGame() {
        for (Player player : players) {
            while (player.getNumbers() == null) {
                player.setNumber(System.in); // プレイヤーがそれぞれのナンバーを設定する。
            }
        }
    }

    public boolean isFinishGame() {
        for (Player player : players) {
            if (player.getIsWinner()) { // 三つhitしたプレイヤーの確認。
                return true;
            }
        }
        return false;
    }

    public void takeTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        Player opponent = players.get((currentPlayerIndex + 1) % players.size());
        int[] guess = null;
        // Judgement result = new Judgement(currentPlayerIndex, currentPlayerIndex)

        System.out.println(currentPlayer.getName() + "は" + opponent.getName() + "のナンバーを予想してください！");

        // int[] guess = currentPlayer.GuessNumber();
        if (currentPlayer.getIsCheated() == false) {
            while (guess == null) {
                guess = currentPlayer.GuessNumber(); // 3桁の数字を入力するまで繰り返す。
            }
        } else {
            guess = currentPlayer.getGuesses();
        }

        // while (guess == null) {
        // guess = currentPlayer.GuessNumber(); // 3桁の数字を入力するまで繰り返す。
        // }
        JudgementResult result = Judgement.checkGuess(guess, currentPlayer, opponent);

        System.out.println("結果: " + result);
        if (result.getHit() == 3) {
            currentPlayer.setWinner(true);
            System.out.println(currentPlayer.getName() + "が勝利しました！");
        } else {
            System.out.println("次のターンに進みます。");
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }
}
