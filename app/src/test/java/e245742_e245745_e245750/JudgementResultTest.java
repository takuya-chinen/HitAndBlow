package e245742_e245745_e245750;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class JudgementResultTest {
    @Test
    void testConstructorAndGetter() {
        // 準備: ヒットとブローを設定
        int hit = 3;
        int blow = 2;
        // 実行: JudgementResult オブジェクトを生成
        JudgementResult result = new JudgementResult(hit, blow);
        // 検証: 正しく値が設定されているか確認
        assertEquals(hit, result.getHit(), "Hitの値が正しくありません");
        assertEquals(blow, result.getBlow(), "Blowの値が正しくありません");
    }
    @Test
    void testToString() {
        // 準備: テスト用のヒットとブローを設定
        int hit = 1;
        int blow = 4;
        JudgementResult result = new JudgementResult(hit, blow);
        // 実行: toString() メソッドの出力を取得
        String expectedOutput = "正解位置と数字の一致: 1, 数字のみ一致: 4";
        // 検証: 期待される文字列が正しく出力されるか確認
        assertEquals(expectedOutput, result.toString(), "toString()の出力が正しくありません");
    }
}
