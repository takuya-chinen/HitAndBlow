package e245742_e245745_e245750;

import java.util.Scanner;
import java.io.InputStream;

public class Player {
    private String name;
    private int[] numbers;
    private int[] guesses;
    private boolean isWinner;
    private int numberOfDigits = 3; // 3桁の数字であることを示す。

    private boolean isCheated; // テストコードのために設定。
    private Scanner scanner; // 再利用すると予期せぬバグに繋がるかも

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
        numbers = new int[numberOfDigits];

        System.out.println(name + "の三桁のナンバーを設定してください。");

        input = scanner.nextLine();
        if (input.length() != 3 || !input.matches("\\d{3}")) { // 3桁じゃない数字または文字が入力された時の対策
            System.out.println("3桁の数字を入力してください。");
            numbers = null;
            return;
        }
        for (int i = 0; i < numbers.length; i++) { // 文字列を数値に変換して配列に格納
            numbers[i] = Character.getNumericValue(input.charAt(i));
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) { // 同じ数字が入力された時の対策
                    System.out.println("数字が重複してはいけません。入力し直してください。");
                    numbers = null;
                    return;
                }
            }
        }

        System.out.println(name + "のナンバーが設定されました。");
        // System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
        // scanner.close();
    }

    // 予想ナンバーを設定するメソッド。
    public int[] GuessNumber(InputStream in) {
        String input = "";
        scanner = new Scanner(in);
        guesses = new int[numberOfDigits];

        System.out.println("相手のナンバーを予想してください。");

        input = scanner.nextLine();
        if (input.length() != 3 || !input.matches("\\d{3}")) { // 3桁じゃない数字または文字が入力された時の対策
            System.out.println("3桁の数字を入力してください。");
            guesses = null;
            return null;
        }
        for (int i = 0; i < guesses.length; i++) { // 文字列を数値に変換して配列に格納
            guesses[i] = Character.getNumericValue(input.charAt(i));
            for (int j = 0; j < i; j++) {
                if (guesses[i] == guesses[j]) { // 同じ数字が入力された時の対策
                    System.out.println("数字が重複してはいけません。入力し直してください。");
                    guesses = null;
                    return guesses;
                }
            }
        }
        return guesses;
    }

    // 自分のナンバーをテスト用に設定するメソッド。オーバーロードメソッド。
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
