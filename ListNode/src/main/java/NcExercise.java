import java.util.*;
public class NcExercise {
    /**
     *
     * 所在题库：面试笔刷TOP101
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

    public static class NC4 {
        /**
         * NC4：判断链表中是否有环
         * 难度：简单
         */
        public boolean hasCycleViaDoublePointer(ListNode head) {
            //双指针法，使用快慢指针进行遍历，若有null结束则没有环，否则快慢指针将相遇
            if (head == null) {
                return false;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasCycleViaHash(ListNode head) {
            ListNode pos = head;
            //哈希表记录访问过的结点
            Set<ListNode> visited = new HashSet<ListNode>();
            while (pos != null) {
                //判断结点是否被访问
                if (visited.contains(pos)) {
                    return true;
                } else {
                    //结点记录添加到哈希表中
                    visited.add(pos);
                }
                //遍历
                pos = pos.next;
            }
            return false;
        }
    }

    public static class NC7{
        /**
         * NC7：买卖股票的最好时机(一)
         * 难度：简单
         */
        public int maxProfitViaBF (int[] prices) {
            //暴力算法：寻找数组中后项-前项的最大值
            int length = prices.length;
            int max = 0;
            int i, j;
            if (length != 0) {
                for (i = 0; i < length-1; i++) {
                    for (j = i; j < length; j++) {
                        if (prices[j] - prices[i] > max) {
                            max = prices[j] - prices[i];
                        }
                    }
                }
            }
            return max;
        }

        public int maxProfitViaOnceTraversal (int[] prices) {
            //一次遍历法：在第i天卖出所得利润为当前股价-历史最低价
            int minPrice = 10000;
            int maxProfit = 0;
            for (int price : prices) {
                minPrice = Math.min(minPrice, price);
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
            return maxProfit;
        }

        public int maxProfitViaDP (int[] prices) {
            //动态规划解决
            int len = prices.length;
            //特殊判断
            if (len < 2) {
                return 0;
            }
            int[][] dp = new int[len][2];

            //dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
            //dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

            //初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
            dp[0][0] = 0;
            //dp[0][1] = -prices[0];
            dp[0][1] = prices[0];

            //从第 2 天开始遍历
            //其实本质上和一次遍历法计算的过程相同：不持股找最大其实是找最大的卖出利润，持股找最大是找历史买入的最低价格
            //所以下文中dp[i][1]可以计算极小值
            for (int i = 1; i < len; i++) {
                //使用状态转移法：
                //dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                //将dp[i][1]变为求极小值后，其理解方式与一次遍历法无异。
                dp[i][0] = Math.max(dp[i - 1][0], prices[i] - dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i - 1][1], prices[i]);
            }
            return dp[len - 1][0];
        }
    }

    public static class NC61{
        /**
         * NC61：两数之和
         * 难度：简单
         */
        public int[] twoSumViaHashMap (int[] numbers, int target) {
            //write code here
            HashMap<Integer, Integer> map = new HashMap<>();
            //遍历数组
            for (int i = 0; i < numbers.length; i++) {
                //将不包含target - numbers[i]，装入map中，包含的话直接返回下标
                if(map.containsKey(target - numbers[i]))
                    return new int[]{map.get(target - numbers[i])+1, i+1};
                else
                    map.put(numbers[i], i);
            }
            throw new IllegalArgumentException("No solution");
        }

        public int[] twoSumViaBF (int[] numbers, int target) {
            //write code here
            int n = numbers.length;
            int[] res = {-1, -1};
            //遍历数组
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    //判断相加值是否为target
                    if (numbers[i] + numbers[j] == target) {
                        res[0] = i+1;
                        res[1] = j+1;
                        //返回值
                        return res;
                    }
                }
            }
            return res;
        }


    }
}
