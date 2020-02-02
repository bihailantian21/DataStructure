package com.zcr.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. Permutations2
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

/**
 * 47、全排列2
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Permutations247 {

    /**
     * 给一组不包含重复数字的数组，给出所有的排列组合
     *
     * 递归：
     * 初始变量：结果、当前列表的状态、数组、用hashset记录数组中的一个数是否在之前用到过了（或者用boolean array记录数组中某一位是否用过了）
     * 结束条件：退出条件，当前的list的size为3时，说明所有的数已经到放了List中了。
     * 循环：遍历数组中所有的数字，看是否以前已经用过
     * 如果没有用过的话，那么它就是一个有效的数字，就把它加到当前数组中，在也加到set中说明我们用过了，还要记录当前数组中最后一个数字的位置，以便在回溯的时候将这个当前元素进行删除。
     * 例：
     * [1,2,3]
     * clist    res   set
     * []      []   []
     * [1]      []    [1]->[1,2]  []  [1,2]->[1,2,3] [] [1,2,3]
     * ->[1,2] [[1,2,3]] [1,2]->第三层for循环结束，返回到第二层for循环
     * ->[1] [[1,2,3]] [1]->[1,3] [[1,2,3]] [1,3]->[1,3,2] [[1,2,3]] [1,3,2]
     * ->[1,3] [[1,2,3], [1,3,2]] [1,3]->第二层for循环结束，返回到第一层for循环
     * ->[2] [[1,2,3], [1,3,2]] [2] ->[2] [[1,2,3], [1,3,2]] [2]
     *
     *
     * 数组可以包含重复的数字
     * [1,1,2]
     * [1]-1’,2*
     *     2,1
     *
     * [1’]1,2*
     *     2,1
     *
     * [2]1,1’^
     *   1’,1^
     * 如何去重：
     * 当前的数位该填什么数的话，用set来记录了，
     * 如：如果之前的第二位数已经选择了1，那么1’对于第二位数就不是一个有效的数了，那么我们需要再为当前的数位找一个有效的数。
     * 以前：只要set中没有被用过就有效
     * 现在：不仅要在set中没有被用过，还要在当前位置没有被用过。
     *
     * 这里使用boolean array而不是hashset了，因为它区分不出1和1’。
     * 不同之处：
     * 1、	排序
     * 2、	定义当前数之前的数是多少
     * @param nums
     * @return
     */
    public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> cur = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        helper(result,cur,nums,used);
        return result;
    }
    
    public void helper(List<List<Integer>> result,List<Integer> cur,int[] nums,boolean[] used) {
        int len = nums.length;
        if (cur.size() == len) {
            result.add(new LinkedList<>(cur));
        } else {
            int preNum = nums[0] - 1;
            for (int i = 0; i < len; i++) {
                if (used[i] == false && (nums[i] != preNum)) {
                    preNum = nums[i];
                    cur.add(nums[i]);
                    used[i] = true;
                    int last = cur.size() - 1;
                    helper(result,cur,nums,used);
                    cur.remove(last);
                    used[i] = false;
                }
            }
        }
    }
}
