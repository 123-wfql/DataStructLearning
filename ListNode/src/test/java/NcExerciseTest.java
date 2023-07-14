import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NcExerciseTest {
    @Test
    public void testHasCycle() {
        //测试数据
        NcExercise.ListNode listNode1 = new NcExercise.ListNode(1);
        NcExercise.ListNode listNode2 = new NcExercise.ListNode(2);
        NcExercise.ListNode listNode3 = new NcExercise.ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;

        //快慢指针法
        boolean hasCycleViaDoublePointer = new NcExercise.NC4().hasCycleViaDoublePointer(listNode1);
        System.out.println(hasCycleViaDoublePointer);
        //使用断言Assertions验证结果
        Assertions.assertTrue(hasCycleViaDoublePointer);  //验证链表是否有环

        //哈希表法
        boolean hasCycleViaHash = new NcExercise.NC4().hasCycleViaHash(listNode1);
        System.out.println(hasCycleViaHash);
        //使用断言Assertions验证结果
        Assertions.assertTrue(hasCycleViaHash);


    }

    @Test
    public void testMaxProfit(){
        int[] prices = {8,9,2,5,4,7,1,8,9,6,5,3,7};
        //暴力法
        int maxProfitViaBF = new NcExercise.NC7().maxProfitViaBF(prices);
        System.out.println(maxProfitViaBF);
        //一次遍历法
        int maxProfitViaOnceTraversal = new NcExercise.NC7().maxProfitViaOnceTraversal(prices);
        System.out.println(maxProfitViaOnceTraversal);
        //动态规划法
        int maxProfitViaDP = new NcExercise.NC7().maxProfitViaDP(prices);
        System.out.println(maxProfitViaDP);
    }

    @Test
    public void testTwoSum(){
        //测试数据定义
        int[] numbers = {3,2,4};
        int target = 6;
        //哈希表存储
        int[] twoSumViaHashMap = new NcExercise.NC61().twoSumViaHashMap(numbers, target);
        System.out.println(Arrays.toString(twoSumViaHashMap));
        //暴力算法
        int[] twoSumViaBF = new NcExercise.NC61().twoSumViaBF(numbers, target);
        System.out.println(Arrays.toString(twoSumViaBF));
    }

}
