package com.zcr.leetcode;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring5 {
    /**
     *
     * @param s
     * @return
     */
    public String longestPalindromicSubstring(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        int start = 0;
        int length = 1;
        boolean[][] isPalindromic = new boolean[len][len];
        char[] sChar = s.toCharArray();
        //定义数组的两种方式int[] array = {};或int[] array1 = new int[];
        for (int i = 0; i < len; i++) {
            isPalindromic[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (sChar[i] == sChar[i + 1]) {
                isPalindromic[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }
        for (int i = 3; i < len + 1; i++) {// length of the current sustring
            for (int j = 0; j + i - 1 < len; j++) {
                if (sChar[j] == sChar[j + i - 1] && isPalindromic[j + 1][j + i - 2]) {
                    isPalindromic[j][j + i - 1] = true;
                    start = j;
                    length = i;
                }
            }
        }
        return s.substring(start,start + length);
    }

    /*//如果题目要求找到所有的回文字符串，那么就记录一个列表
    public String allPalindromicSubstring(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        int start = 0;
        int length = 1;
        boolean[][] isPalindromic = new boolean[len][len];
        char[] sChar = s.toCharArray();
        int reslut_len = (int) Math.pow(2,len);
        String[] result = new String[reslut_len];
        //int[] array = {};
        //int[] array1 = new int[];
        String result_string = "";
        char[] result_char = new char[len];
        for (int i = 0; i < len; i++) {
            isPalindromic[i][i] = true;
            result_char.sChar[i];
            result_string = Arrays.toString();
        }
        for (int i = 0; i < len - 1; i++) {
            if (sChar[i] == sChar[i + 1]) {
                isPalindromic[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }
        for (int i = 3; i < len + 1; i++) {// length of the current sustring
            for (int j = 0; j + i - 1 < len; j++) {
                if (sChar[j] == sChar[j + i - 1] && isPalindromic[j + 1][j + i - 2]) {
                    isPalindromic[j][j + i - 1] = true;
                    start = j;
                    length = i;
                }
            }
        }
        return s.substring(start,start + length);
    }*/


    public static void main(String[] args) {
        LongestPalindromicSubstring5 zong = new LongestPalindromicSubstring5();
        String s = "abbafffff";
        String result = zong.longestPalindromicSubstring(s);
        System.out.println(result);
    }
}
