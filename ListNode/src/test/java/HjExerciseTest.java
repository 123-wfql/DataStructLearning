import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class HjExerciseTest {
    @Test
    public void testHexToDec(){
        // 提供输入数据作为参数
        String input = "0x2A\n0xFF\n0x123\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // 调用方法进行测试
        //  new HjExercise.HJ5().hexToDecViaFormat();
        //  new HjExercise.HJ5().hexToDecViaCharToNum();
        new HjExercise.HJ5().hexToDecViaCharNumMap();

        // 清理标准输入
        System.setIn(System.in);
    }

    @Test
    public void testDistinctSortedRandom(){
        // 提供输入数据作为参数
        String input = "6\n2\n2\n5\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // 调用方法进行测试
        new HjExercise.HJ3().distinctSortedRandomViaTreeMap();

        // 清理标准输入
        System.setIn(System.in);
    }

}
