package e245742_e245745_e245750;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;

public class PlayetTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("テストプレイヤー");
    }

    @Test
    public void testSetNumberWithInvalidLength() {
        String input = "12"; // 2桁の数字
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        player.setNumber(in);

        assertNotNull(player.getNumbers(), "3桁の数字が入力されているのでnullではない");
    }

    @Test
    public void testSetNumberWithValidLength() {
        String input = "123"; // 3桁の数字
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        player.setNumber(in);

        assertNotNull(player.getNumbers(), "3桁の数字が入力されていないのでnullです");
        assertEquals(3, player.getNumbers().length, "numbersの長さが3ではないので失敗です");

    }
}