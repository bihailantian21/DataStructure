package com.zcr.leetcode;

public class ImplementstrStr28 {

    public int implementstrStr(String haystack,String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i < m - n + 1; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementstrStr28 implementstrStr28 = new ImplementstrStr28();
        String haystack = "aaaabcddd";
        String needle = "abc";
        int result = implementstrStr28.implementstrStr(haystack,needle);
        System.out.println(result);
    }
}
