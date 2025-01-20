package e245742_e245745_e245750;

import java.util.Scanner;
import java.io.InputStream;

public class Player {
    private String name;
    private int[] numbers;
    private int[] guesses;
    private boolean isWinner;
    private boolean isCheated; // テストコードのために設定。
    private Scanner scanner;
    private InputStream in;

    public Player(String name) {
        this.name = name;
        isWinner = false; // trueになったら勝利する。
        isCheated = false; // テストコードのために設定。
    }

    public String getName() {
        return name;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int[] getGuesses() {
        return guesses;
    }

    public boolean getIsWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    // 自分のナンバーを設定するメソッド。
    public void setNumber(InputStream in) {
        String input = "";
        scanner = new Scanner(in);
        numbers = new int[3];

        System.out.println(name + "の三桁のナンバーを設定してください。");

        input = scanner.nextLine();
        if (input.length() != 3) { // 3桁じゃない数字が入力された時のフェイルセーフ
            System.out.println("3桁の数字を入力してください。");
            numbers = null;
            return;
        }
        for (int i = 0; i < 3; i++) { // 文字列を数値に変換して配列に格納
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }

        System.out.println(name + "のナンバーが設定されました。");
        // System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
        // scanner.close();
    }

    // 予想ナンバーを設定するメソッド。
    public int[] GuessNumber(InputStream in) {
        String input = "";
        scanner = new Scanner(in);
        guesses = new int[3];

        System.out.println("相手のナンバーを予想してください。");

        input = scanner.nextLine();
        if (input.length() != 3) { // 3桁じゃない数字が入力された時のフェイルセーフ
            System.out.println("3桁の数字を入力してください。");
            guesses = null;
            return null;
        }
        for (int i = 0; i < 3; i++) { // 文字列を数値に変換して配列に格納
            guesses[i] = Character.getNumericValue(input.charAt(i));
        }
        return guesses;
    }

    // 自分のナンバーをテスト用に設定するメソッド。
    public void setNumber(int[] numbers) {
        this.numbers = numbers;
    }

    // 予想ナンバーをテスト用に設定するメソッド。
    public void setGuesses(int[] guesses) {
        this.guesses = guesses;
        this.isCheated = true;
    }

    public boolean getIsCheated() {
        return isCheated;
    }
}
