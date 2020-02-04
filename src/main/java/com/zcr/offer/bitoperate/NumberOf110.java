package com.zcr.offer.bitoperate;

/**
 * 10、二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

/**
 * 本题考察位运算。
 *
 * 左移运算符 m << n 表示把 m 左移n 位。左移n位的时候，最左边的n位将被丢弃，同时在最右边补上n个 0。比如:
 * 00001010 << 2 = 00101000
 * 10001010 << 3 = 01010000
 *
 * 右移运算符 m >> n 表示把 m 右移n 位。右移n 位的时候，最右边的n位将被丢弃。
 * 但右移时处理最左边位的情形要稍微复杂一点。
 * 如果数字是一个无符号数值，则用 0 填补最左边的 n 位。
 * 如果数字是一个有符号数值，则用数字的符号位填补最左边的n位。
 * 也就是说如果数字原先是一个正数，则右移之后在最左边补n个 0；如果数字原先是负数，则右移之后在最左边补n个1。
 * 比如对两个 8 位有符号数作右移的例子:
 * 00001010 >> 2= 00000010
 * 10001010 >> 3 = 11110001 // 负
 */
public class NumberOf110 {

    /**
     * 思路一(不能处理负数-wrong answer)
     * 简单的想法：
     * 就是使用位运算，直接将n每次右移一位；
     * 并且每次移动之后最后一位和1做与运算，然后此时统计1的个数；
     * 但是这种方法不能处理负数，因为负数右移在左边补1，有不同，所以wrong answer；
     *
     * 对于负数的问题：负数向右移动，左边的高位要补1，所以一直补1的话，一直退出不while循环。
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int sum = 0;
        while (n > 0) {
            if ((n & 1) != 0) {//与运算，都为1时结果才为1
                sum++;
            }
            n >>= 1;
        }
        return sum;

    }

    /**
     * 思路二
     * 为了解决死循环的问题，我们可以不用右移输入的数字n。
     * 首先把n和1做与运算，判断n的最低位是不是为1；然后把1左移一位得到2（10），再与n做与运算，判断n的次低位是不是为1；
     * 这样反复左移，每次都能判定n中的一位是否为1.
     *
     * 使用另一个变量another：
     * another一开始初始化为1，然后每次和n做与运算，这样也可以判断n的每一位是不是1；
     * 这种做法another左移32次，终止条件为another = 0；
     * @param n
     * @return
     */
    public int NumberOf12(int n) {
        int sum = 0;
        int another = 1;
        while (another != 0) {
            if ((n & another) != 0) {
                sum++;
            }
            another <<= 1;
        }
        return sum;
    }

    /**
     * 1、一个数和比自己小1的数做与运算，会把这个数最右边的1变成0；
     * 2、然后看能做几次这样的运算，这个数就有多少个1；
     * 3、这个方法有多少个1，就只需要循环多少次，是最优解法；
     *
     * 在分析这个算法之前，我们先来分析把一个数减去1的情况：
     * 情况一：如果一个整数不等于0，那么该整数的二进制表示中至少有一位是 1。先假设这个数的最右边一位是 1，那么减去 1 时，
     * 最后一位变成 0 而其他所有位都保持不变。也就是最后一位相当于做了取反操作，由 1 变成了 0。
     *   x x x 1
     * -       1
     *   x x x 0
     *
     * 情况二：接下来假设最后一位不是 1 而是 0 的情况。如果该整数的二进制表示中最右边 1 位于第 m 位，
     * 那么减去1时，第m 位由1 变成0，而第 m 位之后的所有 0 都变成 1,整数中第 m 位之前的所有位都保持不变。
     * 举个例子，一个二进制数 1100，它的第二位是从最右边数起的一个 1。减去 1 后，第二位变成0，它后面的两位 0 变成 1，
     * 而前面的 1 保持不变，因此得到的结果是 1011。
     *     m
     *   x 1 x 0
     * -       1
     *   x 0 x 1
     *
     *   1 1 0 0
     * -       1
     *   1 0 1 1
     *
     *
     *
     * 情况三：在前面两种情况中, 我们发现把一个整数减去 1，都是把最右边的 1 变成0。
     * 如果它的右边还有 0 的话，所有的 0 都变成 1，而它左边所有位都保持不变。
     * 接下来我们把一个整数和它减去 1 的结果做位与运算，相当于把它最右边的 1 变成 0。
     * 还是以前面的 1100 为例，它减去 1 的结果是 1011。我们再把 1100和 1011 做位与运算，得到的结果是 1000。
     * 我们把 1100 最右边的 1 变成了0，结果刚好就是 1000。
     *   1 1 0 0
     * -       1
     *   1 0 1 1
     *
     *   1 1 0 0
     * & 1 0 1 1
     *   1 0 0 0
     *
     *
     * 总结: 把一个整数减去 1 再和原整数做与运算，会把该整数最右边一个 1 变成 0。那么一个整数的二进制表示中有多少个 1，
     * 就可以进行多少次这样的操作。
     *
     * n&(n-1)
     * 该位运算去除 n 的位级表示中最低的那一位。
     * n       : 10110100
     * n-1     : 10110011
     * n&(n-1) : 10110000
     * @param n
     * @return
     */
    public int NumberOf13(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }
}
