package e245742_e245745_e245750;

class Judgement {
    // private int hit;
    // private int blow;

    // public Judgement(int hit, int blow) {
    // this.hit = hit;
    // this.blow = blow;
    // }

    // @Deprecated
    // public String toString() {
    // return "正解位置と数字の一致: " + hit + ", 数字のみ一致: " + blow;
    // }

    // @Deprecated
    // // hitが 3(すべての桁が完全一致)であればtrueを返す。そうでなければfalseを返す。
    // public boolean isTriplehit() {
    // return hit == 3;
    // }

    public static JudgementResult checkGuess(int[] guess, Player current, Player opponent) {
        int hit = 0;
        int blow = 0;

        int[] guesses = current.getGuesses();
        int[] numbers = opponent.getNumbers();

        boolean[] usedInTarget = new boolean[3];
        boolean[] usedInGuess = new boolean[3];

        // hitの個数を確かめるループ。
        for (int i = 0; i < 3; i++) {
            if (guesses[i] == numbers[i]) {
                hit++;
                usedInTarget[i] = true;
                usedInGuess[i] = true;
            }
        }

        // blowの個数を確かめるループ。
        for (int i = 0; i < 3; i++) {
            if (usedInGuess[i] == false) {
                for (int j = 0; j < 3; j++) {
                    if (!usedInTarget[j] && guesses[i] == numbers[j]) {
                        blow++;
                        usedInTarget[j] = true;
                        break;
                    }
                }
            }
        }
        return new JudgementResult(hit, blow);
    }
}