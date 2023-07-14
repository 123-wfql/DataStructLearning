import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class HjExerciseTest {
    @Test
    public void testHexToDec(){
        //提供输入数据作为参数
        String input = "0x2A\n0xFF\n0x123\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //调用方法进行测试
        // new HjExercise.HJ5().hexToDecViaFormat();
        // new HjExercise.HJ5().hexToDecViaCharToNum();
        new HjExercise.HJ5().hexToDecViaCharNumMap();

        //清理标准输入
        System.setIn(System.in);
    }

    @Test
    public void testDistinctSortedRandom(){
        //提供输入数据作为参数
        String input = "17\n12\n275\n482\n49\n191\n12\n406\n85\n374\n167\n49\n410\n299\n87\n431\n85\n53";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //调用方法进行测试
        //new HjExercise.HJ3().distinctSortedRandomViaTreeMap();
        //new HjExercise.HJ3().distinctSortedRandomViaHashMap();
        new HjExercise.HJ3().distinctSortedRandomViaTag();

        //清理标准输入
        System.setIn(System.in);
    }

    @Test
    public void testMoveXY(){
        //提供输入数据作为参数
        String input = "A10;S20;W10;D30;X;A1A;B10A11;;A10;";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //调用方法进行测试
        new HjExercise.HJ17().moveXYViaCharSplit();
        //new HjExercise.HJ17().moveXYViaRegex();

        //清理标准输入
        System.setIn(System.in);
    }

    @Test
    public void testSortedScore(){
        //提供输入数据作为参数
        String input = "3\n0\nfang 90\nyang 50\nning 70";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //调用方法进行测试
        //new HjExercise.HJ68().sortedScoreViaArray();
        new HjExercise.HJ68().sortedScoreViaObjectList();

        //清理标准输入
        System.setIn(System.in);
    }

    @Test
    public void testEncodedDecodedString(){
        //提供输入数据作为参数
        String input = "dfjk513\n45315djkf";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //调用方法进行测试
        new HjExercise.HJ29().encodedDecodedStringViaIfElse();
        //new HjExercise.HJ29().encodedDecodedStringViaArray();

        //清理标准输入
        System.setIn(System.in);
    }

    @Test
    public void testCharacterNum(){
        //提供输入数据作为参数
        String input = "I love you, HuiJuan";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        //调用方法进行测试
        new HjExercise.HJ10().characterNumViaBitSet();
        //new HjExercise.HJ10().characterNumViaHashSet();

        //清理标准输入
        System.setIn(System.in);
    }

}
