package com.zcr.leetcode;

/**
 * 50. Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */

/**
 * 50、实现 pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class PowXY50 {

    /**
     * 2^4=4^2=16
     * 把pow/2，number做一个二次方。
     *
     * 奇偶的问题：
     * 2^9=2*2^8=2*4^4=2*16^2
     * Res 1 1*2 2   2   2*256=512
     * Num 2 4   16  256
     * Pow 9 4   2   1
     * 如果pow是奇数的话，让result变量先乘当前的number。
     *
     * 正负的问题：
     * 2^-2= 1/2^2
     * 遇到负数，用1除以。
     *
     * 因为负数的最小值没有办法通过取证直接得到最大值，所以面对所有的负数我们做一个特殊处理。
     * 正数的Interger.maxvalue要比负数的绝对值要小一个
     * 所以：要把负数先加1，再取负。
     * 因为pow的负数进行了加1，则变成正数后就少了一个，所以我们再额外乘一个num。
     * 如：2^-3
     * 1/2*2^2=1/2^3
     *
     * @param x
     * @param y
     * @return
     */
    public double pow(double x,int y) {
        if (y == 0 || x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (y < 0) {
            return 1 / (y * pow(x,-(y+1)));
        }
        double result = 1;
        while (y > 1) {
            if (y % 2 != 0) {
                result *= x;
            }
            y /= 2;
            x = x * x;
        }
        result *= x;
        return result;
    }
}
