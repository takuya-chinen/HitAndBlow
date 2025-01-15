package e245742_e245745_e245750;

public class JudgementResult {
    private int hit;
    private int blow;

    public JudgementResult(int hit, int blow) {
        this.hit = hit;
        this.blow = blow;
    }

    public int getHit() {
        return hit;
    }

    public int getBlow() {
        return blow;
    }

    @Override
    public String toString() {
        return "正解位置と数字の一致: " + hit + ", 数字のみ一致: " + blow;
    }
}
