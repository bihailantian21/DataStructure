package com.zcr.leetcode;

/**
 * 70. Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

/**
 * 70、爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbingStairs70 {

    /**
     * 动态规划
     * N个台阶，从最底下开始走，走多少步能到最上面。
     * 每一步只能迈一个台阶或者两个台阶。
     * 2个台阶：1 1、2  3：1 1 1、1 2、2
     * State:[i]到第i个台阶有多少种走法
     * Init:[0]=1 [1]=1
     * [2]=[1]+[0]=2
     * Func:[i]=[i-1]+[i-2]等于之前一个台阶的数目（再爬两个）、之前两个台阶的数目（再爬一个）。
     * Re:[n]
     * 时间：O(n)
     * 空间：O(n)
     *
     *
     * 优化空间
     * State:pre cur
     * Init:1 1
     * Fuc:cur=cur+pre
     * Res:cur
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbingStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int cur = 1;
        int pre = 1;
        for(int i = 2; i <= n; i++) {
            cur += pre;
            pre = cur - pre;
        }
        return cur;
    }
}
