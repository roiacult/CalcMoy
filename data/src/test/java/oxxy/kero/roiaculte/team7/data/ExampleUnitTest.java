package oxxy.kero.roiaculte.team7.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void littleBigTest(){
        String string = "(رياضيات و إعلام آلي السنة الأولى (الفيزياء1";
     assertTrue(string.contains("رياضيات و إعلام"));
    }
}