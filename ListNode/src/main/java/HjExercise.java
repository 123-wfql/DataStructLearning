import java.util.*;

public class HjExercise {
    /**
     * 题库：牛客 - 华为机试
     */

    public static void main(String[] args) {
    }
    static class ListNode {
        //链表结点定义
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class HJ5 {
        /**
         * HJ5:进制转换
         * 难度：简单
         */
        public void hexToDecViaFormat(){
            //使用现成轮子：直接通过工厂方法，考查Java基础
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) { //注意 while 处理多个 case
                String s = in.nextLine();
                System.out.println(Integer.parseInt(s.substring(2),16));
            }
            in.close();
        }

        public void hexToDecViaCharToNum(){
            //可以根据进制转换原理进行字符到数字的转换
            Scanner in = new Scanner(System.in);
            while(in.hasNextLine()){
                String s = in.nextLine();    //读入数字

                int count = 0;    //记录转换后的数字

                for(int i=0; i < s.length()-2; i++){
                    //由于前面两位是'0x'，故从第三位开始
                    char tc = s.charAt(i+2);
                    int t = 0;  //记录字母转换成的数值
                    //将字母转换为数值
                    //使用字符相减法
                    if(tc>='0' && tc<='9')
                        t = tc - '0';
                    //字母'A'/'a'~'F''f'对应数字10~15
                    else if(tc>='A' && tc<='F')
                        t = tc - 'A' + 10;
                    else if(tc>='a' && tc<='f')
                        t = tc - 'a' +10;

                    //计算加和
                    //对各个位置加权后计算，但这样乘法计算很多，效率较低
                    count += t * Math.pow(16, s.length()-i-3);

                }
                System.out.println(count);
            }
        }

        public void hexToDecViaCharNumMap(){
            //可以根据进制转换原理进行字符到数字的转换
            //使用Map存储
            Map<Character, Integer> map = new HashMap<Character, Integer>()
            {{
                put('0', 0);
                put('1', 1);
                put('2', 2);
                put('3', 3);
                put('4', 4);
                put('5', 5);
                put('6', 6);
                put('7', 7);
                put('8', 8);
                put('9', 9);
                put('A', 10);
                put('B', 11);
                put('C', 12);
                put('D', 13);
                put('E', 14);
                put('F', 15);
                put('a', 10);
                put('b', 11);
                put('c', 12);
                put('d', 13);
                put('e', 14);
                put('f', 15);
            }};

            Scanner in = new Scanner(System.in);
            while(in.hasNextLine()){
                String s = in.nextLine();    //读入数字
                int count = 0;    //记录转换后的数字
                for(int i=0; i < s.length()-2; i++){
                    //由于前面两位是'0x'，故从第三位开始
                    char tc = s.charAt(i+2);
                    int t = 0;  //记录字母转换成的数值
                    //将字母转换为数值
                    //使用Map存储并获取，提高效率
                    t = map.get(tc);

                    //计算加和
                    //对每一位都进行乘加操作，每一位只需要进行一次乘法和一次加法
                    count = count * 16 + t;
                }
                System.out.println(count);
            }
        }
    }

    public static class HJ3{
        /**
         * HJ3：明明的随机数
         * 难度：较难
         */
        public void distinctSortedRandomViaTreeMap(){
            Scanner sc = new Scanner(System.in);
            //获取个数
            int num = sc.nextInt();
            //创建TreeSet进行去重排序
            TreeSet<Integer> treeSet = new TreeSet<>();
            //输入

            for (int i = 0 ; i < num ; i++) {
                if (sc.hasNextInt()){
                    treeSet.add(sc.nextInt());
                }
            }
            //输出
            for (Integer integer : treeSet) {
                System.out.println(integer);
            }
        }
        public void distinctSortedRandomViaHashMap(){

        }

    }
}
