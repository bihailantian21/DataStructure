package com.zcr.leetcode.dynamicplan.fibonaccinumbers;

/**
 * 母牛生产
 * 程序员代码面试指南-P181
 *
 * 题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。
 * 第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。
 * 每只小母牛 3 年之后成熟又可以生小母牛。
 * 给定整数 N，求 N 年后牛的数量。
 *
 * 1  1
 * 2  1+1
 * 3  1+1
 *   +1
 * 4 +1+1
 *
 * 第 i 年成熟的牛的数量为：dp[i] = dp[i-1] + dp[i-3]
 */
public class CowProduction {
}
