package game;

import java.util.Scanner;

public class Player {
    String name;
    int[] number;
    int[] guess;
    boolean isWinner;

    public String getName() {
        return name;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public Player(String name) {
        this.name = name;
        isWinner = false; // trueになったら勝利する。
    }

    // 自分のナンバーを設定するメソッド。
    public void setNumber() {
        Scanner scanner = new Scanner(System.in);
        number = new int[3];

        System.out.println("あなたの三桁のナンバーを設定してください。");

        for (int i = 0; i < 3; i++) {
            number[i] = scanner.nextInt();
        }

        System.out.println("あなたのナンバーが設定されました。");
    }

    // 相手のナンバーを予想するメソッド。
    public int[] GuessNumber() {
        Scanner scanner = new Scanner(System.in);
        guess = new int[3];

        System.out.println("相手のナンバーを予想してください。");

        for (int i = 0; i < 3; i++) {
            guess[i] = scanner.nextInt();
        }
        return guess;
    }

    // 判定メソッド(9.8割GPT頼り)
    public Judgiment checkGuess(int[] guess) {
        int hit = 0;
        int blow = 0;
        boolean[] usedInTarget = new boolean[3];
        boolean[] usedInGuess = new boolean[3];

        // hitの個数を確かめるループ。
        for (int i = 0; i < 3; i++) {
            if (guess[i] == number[i]) {
                hit++;
                usedInTarget[i] = true;
                usedInGuess[i] = true;
            }
        }

        // blowの個数を確かめるループ。
        for (int i = 0; i < 3; i++) {
            if (usedInGuess[i] == false) {
                for (int j = 0; j < 3; j++) {
                    if (!usedInTarget[j] && guess[i] == number[j]) {
                        blow++;
                        usedInTarget[j] = true;
                        break;
                    }
                }
            }
        }
        return new Judgiment(hit, blow);
    }
}
