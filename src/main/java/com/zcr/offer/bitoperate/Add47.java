package com.zcr.offer.bitoperate;

/**
 * 47.不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add47 {

    /**
     * 分析如何做十进制加法：
     * 如：5+17=22这个运算是分三步进行的
     * 1.只做各位相加不进位12（个位：5+7=12取2，十位：取1）
     * 2.做进位10（个位到十位进位：5+7=12取10）
     * 3.把前面两个结果加起来22
     *
     * 对数字来说做运算，除了四则运算就是位运算了
     * 位运算是针对二进制的，我们再来看一下针对上面的三步策略还有没有效
     * 5：101  17：10001
     * 1.各位相加但不进位10100（个位：1+1=10取0，十位0+0=0，百位1+0=1，..0,1）
     * 2.记下进位10（最后一位相加时产生进位10）
     * 3.加起来10110=22（10100+10=10110）
     *
     * 接下来我们把二进制的加法用位来代替
     * 1.如果在不考虑进位的情况下，a ^ b就是正确结果。
     * 因为0+0、1+1都是0，1+0、0+1都是1，所以结果可以用异或（一样为0不一样为1）来表达。
     * 因为0 + 0 = 0(0 ^ 0)，1 + 0 = 1(1 ^ 0)，0 + 1 = 1(0 ^ 1)，1 + 1 = 0 (1 ^ 1)。
     * 例如:
     * a : 001010101
     * b : 000101111
     *     001111010
     * 2.在只考虑进位的情况下，也就是只考虑a + b中进位产生的值的情况下，(a & b) << 1就是结果。
     * 因为0+0、0+1、1+0来说都不会产生进位，只有1+1会向前产生一个进位，所以结果可以用两个数先做与运算，然后再向左移动一位来表示。
     * 因为第i位的结果只有可能是i - 1位都为1的情况下才会产生进位。
     * 例如:
     * a : 001010101
     * b : 000101111
     *     000001010
     * 3.把完全不考虑进位和考虑进位的两种情况相加，就是最终的结果。
     * 也就是说一直重复这样的过程，直到最后的进位为0则说明完成了相加。
     *
     *
     *
     *
     *
     *
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int sum = num1;
        int carry;
        while (num2 != 0) {
            sum = num1 ^ num2;
            carry = (num1&num2)<<1;
            num1 = sum;
            num2 = carry;
        }
        return sum;
    }
}
