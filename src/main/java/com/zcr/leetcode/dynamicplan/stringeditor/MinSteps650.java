package com.zcr.leetcode.dynamicplan.stringeditor;


/**
 * 650. 只有两个键的键盘
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 示例 1:
 * 输入: 3
 * 输出: 3
 * 解释:
 * 最初, 我们只有一个字符 'A'。
 * 第 1 步, 我们使用 Copy All 操作。
 * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
 * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 * 说明:
 *
 * n 的取值范围是 [1, 1000] 。
 */
public class MinSteps650 {

    /**
     * dp[i]表示，通过复制粘贴操作，得到 i 个字符，最少需要几步操作。
     * 如果一个数是素数，那么最少操作就是一开始复制一个，最后一个个粘贴；
     * 如果一个数不是素数，那么最少操作就可以按它的因数分解一下，简化操作。
     * 举个例子，比如12，可以分解为 以下几种情况：
     * 12 = 2*6, 需要操作CPCPPPPP总共8步
     * 12 = 3*4, 需要操作CPPCPPP总共7步
     * 12 = 4*3, 需要操作CPPPCPP总共7步
     * 12 = 6*2, 需要操作CPPPPPCP总共8步
     * 其实可以发现，因子相同的情况下，交换因子相乘的顺序，需要的步骤是一样的。所以我们可以简化一下分解的步骤，只需要找到小于sqrt(n)的因子即可。
     *
     * 假设找到的因子是 j ，那么需要的最小步骤就是 dp[j] + dp[i/j]，
     * 其中，dp[j]表示需要多少步生成这个因子，dp[i/j]表示需要多少步基于这个因子得到 i。
     *
     *
     *
     *
     *
     * 高大上的dp都有答案了，我出一个暴力dp。
     * 通常，对于DP问题，我们需要确定原问题的最优子结构，并将其解与子问题联系起来。
     * 首先，那么原来的问题是dp(n)，我们定义dp(i)为在记事本上得到i个 A的最小步数。
     * 我们有以下base case:dp(1) =0，因为最初在记事本上已经有一个“A”。
     * 现在关键的部分是如何把dp(i)和它的子问题联系起来。
     * 显然，dp(i)取决于在记事本上获得i 'A的取决于子问题。现在问问你自己这些问题:
     *
     * 1. 子序列的操作能以复制结束吗?显然不行。因为复制没有改变“A”的数量，这个步骤可以删除，所以以复制结束肯定不是最小步骤。
     * 2. 子序列的操作只能包含粘贴吗？答案仍然是否定的，因为在开始时没有复制字符，所以粘贴不会改变记事本上的“A”的数量(一个特殊情况是当n = 1时，但我们甚至不需要任何操作)。
     * 因此，我们得出结论，子序列的操作必须以粘贴结束，并且存在至少一个拷贝操作。
     * 但是，从最后一次粘贴的角度来看，它只关心上次复制的字符，即已经复制子序列的”A”的个数，我们假设他的长度为j，之后每次复制长度都是增加j。
     *
     * 所以从j 个A到i 个A的总步数是i /j。因为我们的目标是最小化得到i 'A'的步数，所以我们假设从1个A到j个A为dp(j)，因此在这种情况下得到i 'A'的步数dp(i)等于dp(j) + i/j。
     * 上面论述了从j 个A到i 个A的总步数是i /j， 因为步数必须为整数，所以i/j必须为整数，所以i%j 必须等于0。
     * 最后，状态方程：
     * dp(i) = min(dp(j) + i/j) where 1 <= j < i && i % j == 0.
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        int h = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= h; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
