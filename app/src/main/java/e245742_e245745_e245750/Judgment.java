package game;

class Judgiment {
    private int hit;
    private int blow;

    public Judgiment(int hit, int blow) {
        this.hit = hit;
        this.blow = blow;
    }
    
    public String toString() {
        return "正解位置と数字の一致: " + hit + ", 数字のみ一致: " + blow;
    }
    
    //hitが 3(すべての桁が完全一致)であればtrueを返す。そうでなければfalseを返す。
    public boolean isTriplehit() {
        return hit == 3;
    }
}