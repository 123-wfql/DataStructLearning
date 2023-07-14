import java.util.*;
import java.util.stream.Collectors;

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
            Scanner sc = new Scanner(System.in);
            //获取个数
            int num = sc.nextInt();
            //创建HashSet进行去重
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0 ; i < num ; i++) {
                if (sc.hasNextInt()){
                    hashSet.add(sc.nextInt());
                }
            }
            List<Integer> sortedNumbers = new ArrayList<>(hashSet);
            Collections.sort(sortedNumbers);

            //输出
            for (Integer integer : sortedNumbers) {
                System.out.println(integer);
            }
        }

        public void distinctSortedRandomViaTag(){
            //由于确定了数据范围是1-500，因此可以创建个容量为500的数组存放1-500，
            //当读取某个数后，在相应位置的val为1，最后读取中数组中val为1的坐标值
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int num = scanner.nextInt();
                int[] arr = new int[501];
                for (int i = 0; i < num; i++) {
                    int n = scanner.nextInt();
                    arr[n] = 1;
                }
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] == 1) {
                        System.out.println(i);
                    }
                }
            }
        }

    }

    public static class HJ17 {
        /**
         * HJ17：坐标移动
         * 难度：中等
         */

        public void moveXYViaRegex() {
            Scanner in = new Scanner(System.in);
            String[] strs = in.nextLine().split(";");
            int x = 0;
            int y = 0;
            for (String s : strs) {
                if (!s.matches("[WASD][0-9]{1,2}")) {
                    continue;
                }
                int val = Integer.parseInt(s.substring(1));
                switch (s.charAt(0)) {
                    case 'W' -> y += val;
                    case 'S' -> y -= val;
                    case 'A' -> x -= val;
                    case 'D' -> x += val;
                }
            }
            System.out.println(x + "," + y);
        }

        public void moveXYViaCharSplit() {
            Scanner in = new Scanner(System.in);
            String[] strings = in.nextLine().split(";");
            int x = 0;
            int y = 0;
            for (String s : strings) {
                if ("".equals(s) || s.length() > 3) continue;
                String di = s.substring(0, 1);
                if (!("A".equals(di) || "D".equals(di) || "W".equals(di) || "S".equals(di))) {
                    continue;
                }
                int val = 0;
                try {
                    val = Integer.parseInt(s.substring(1));
                } catch (Exception e) {
                    continue;
                }
                switch (di) {
                    case "A" -> x -= val;
                    case "D" -> x += val;
                    case "W" -> y += val;
                    case "S" -> y -= val;
                }
            }
            System.out.println(x + "," + y);
        }
    }

    public static class HJ68{
        /**
         * HJ68：成绩排序
         * 难度：较难
         */

        static class Student{
            String name;
            int score;
            public Student(String name,int score){
                this.name = name;
                this.score = score;
            }
        }


        public void sortedScoreViaObjectList() {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                int n = Integer.parseInt(sc.nextLine());
                String order = sc.nextLine();
                LinkedList<Student> arr = new LinkedList<>();
                //判断
                if("0".equals(order)){
                    for(int i=0;i<n;i++) {
                        String[] pair = sc.nextLine().split(" ");   //对每一行进行分离
                        insert0(arr, new Student(pair[0], Integer.parseInt(pair[1])));
                    }
                }else{
                    for(int i=0;i<n;i++) {
                        String[] pair = sc.nextLine().split(" ");
                        insert1(arr, new Student(pair[0], Integer.parseInt(pair[1])));
                    }
                }
                //输出
                for(int i=0;i<arr.size();i++) {
                    System.out.println(arr.get(i).name + " " + arr.get(i).score);
                }
            }
        }
        private static void insert0(LinkedList<Student> list,Student newStu){
            for(int i=0;i<=list.size();i++){
                if(i==list.size() || list.get(i).score<newStu.score){   //在链表中逐一比较，如果在某个位置新插入的值比较大，则插入到这个位置
                    list.add(i,newStu);
                    break;
                }
            }
        }
        private static void insert1(LinkedList<Student> list,Student newStu){
            for(int i=0;i<=list.size();i++){
                if(i==list.size() || list.get(i).score>newStu.score){
                    list.add(i,newStu);
                    break;
                }
            }
        }

        public void sortedScoreViaArray(){
            Scanner in = new Scanner(System.in);
            HashMap<Integer, String> map = new HashMap<>(); //哈希表存编号+名字
            while (in.hasNextLine()) {

                int num = Integer.parseInt(in.nextLine());
                int order = Integer.parseInt(in.nextLine());
                int[][] score = new int[num][2];
                //二维数组存编号+成绩,标号对应姓名的编号
                //读取
                for (int i = 0; i < num; i++) {
                    String[] item = in.nextLine().split(" ");
                    score[i][0] = i;
                    score[i][1] = Integer.parseInt(item[1]);
                    map.put(i, item[0]);
                }
                //排序
                Arrays.sort(score, (o1, o2) -> {
                    if (order == 0) {
                        return o2[1] - o1[1];
                        //按第二列降序排列,如果相等的话，返回0，顺序不变
                    } else {
                        return o1[1] - o2[1];//按第二列升序
                    }
                });
                //输出
                for (int i = 0; i < num; i++) {
                    System.out.println(map.get(score[i][0]) + " " + score[i][1]);
                }
            }
        }

    }

    public static class HJ29{
        /**
         * HJ29：字符串加解密
         * 难度：中等
         */

        //加密函数
        private static String encode(String code) {
            char[] t = code.toCharArray();    //将String对象转换为字符数组
            for (int i = 0; i < t.length; i++) {
                if (t[i] >= 'a' && t[i] < 'z')
                    t[i] = (char)(t[i] - 'a' + 'A' + 1);
                else if (t[i] == 'z')
                    t[i] = 'A';
                else if (t[i] >= 'A' && t[i] < 'Z')
                    t[i] = (char)(t[i] - 'A' + 'a' + 1);
                else if (t[i] == 'Z')
                    t[i] = 'a';
                else if (t[i] >= '0' && t[i] < '9')
                    t[i] = (char)(t[i] + 1);
                else if (t[i] == '9')
                    t[i] = '0';
            }
            return String.valueOf(t);
        }

        //解密函数
        private static String decode(String password) {
            char[] t = password.toCharArray();
            for (int i = 0; i < t.length; i++) {
                if (t[i] > 'a' && t[i] <= 'z')
                    t[i] = (char)(t[i] - 'a' + 'A' - 1);
                else if (t[i] == 'a')
                    t[i] = 'Z';
                else if (t[i] > 'A' && t[i] <= 'Z')
                    t[i] = (char)(t[i] - 'A' + 'a' - 1);
                else if (t[i] == 'A')
                    t[i] = 'z';
                else if (t[i] > '0' && t[i] <= '9')
                    t[i] = (char)(t[i] - 1);
                else if (t[i] == '0')
                    t[i] = '9';
            }
            return String.valueOf(t);
        }


        public void encodedDecodedStringViaIfElse() {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                System.out.println(encode(in.nextLine()));
                System.out.println(decode(in.nextLine()));
            }
        }


        private static char[] decode = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        private static char[] encode = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza1234567890".toCharArray();
        public void encodedDecodedStringViaArray(){
            Scanner in = new Scanner(System.in);
            while(in.hasNext()){
                char[] code1 = in.nextLine().toCharArray();
                StringBuilder encode1 = new StringBuilder();
                for(char c1 : code1){
                    char ec1 = encode[findIndex(decode, c1)];
                    encode1.append(ec1);
                }
                System.out.println(encode1);
                char[] code2 = in.nextLine().toCharArray();
                StringBuilder decode2 = new StringBuilder();
                for(char c2 : code2){
                    char dc2 = decode[findIndex(encode, c2)];
                    decode2.append(dc2);
                }
                System.out.println(decode2);
            }
        }

        private int findIndex(char[] chars, char c) {
            for(int i = 0; i<chars.length; i++){
                if(chars[i] == c){
                    return i;
                }
            }
            return -1;
        }


    }

    public static class HJ10{
        /**
         * HJ10：字符个数统计
         * 难度：简单
         */

        public void characterNumViaHashSet(){
            Scanner in = new Scanner(System.in);
            char[] arr = "".toCharArray();
            while (in.hasNext()) { // 注意 while 处理多个 case
                String str = in.nextLine();
                arr = str.toCharArray();
            }
            Set<Character> set = new HashSet<Character>();
            for (char c: arr){
                set.add(c);
            }
            System.out.println(set.size());
        }

        public void characterNumViaBitSet(){
            Scanner in = new Scanner(System.in);
            String str = "";
            while (in.hasNext()) { // 注意 while 处理多个 case
                str = in.nextLine();
            }
            BitSet bitSet = new BitSet(128);
            for (char c: str.toCharArray()){
                if(!bitSet.get(c)){
                    bitSet.set(c);
                }
            }
            System.out.println(bitSet.cardinality());
        }


    }

}
