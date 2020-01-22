package com.zcr.leetcode;

public class RegularExpressionMatching10 {

    public boolean isMatchDFS(String a,String b) {
        if (a == null || b == null) {
            return false;
        }
        int alen = a.length();
        int blen = b.length();
        return true;

    }
    public boolean isMatch(String a,String b) {
        if (a == null || b == null) {
            return false;
        }
        int alen = a.length();
        int blen = b.length();
        boolean[][] match = new boolean[alen + 1][blen + 1];
        match[0][0] = true;//基底
        //case0:就是说a为""空时，看b中含有*的能否与空匹配 ""-"a"  ""-"a*"  ""-"ab*"  ""-"a*b*"
        for (int bi = 1; bi <= blen; bi++) {//先要把*代表0次的初始化一下 ""  "a*"是匹配的
            if (b.charAt(bi - 1) == '*') {
                match[0][bi] = match[0][bi - 2];
            }
        }
        for (int ai = 1; ai <= alen; ai++) {
            for (int bi = 1; bi <= blen; bi++) {
                //case1:一一匹配的情况
                if (b.charAt(bi - 1) == '.' || b.charAt(bi - 1) == a.charAt(ai - 1)) {
                    match[ai][bi] = match[ai - 1][bi - 1];
                } else if (b.charAt(bi - 1) == '*') {//是*的话也有可能匹配，所以要分情况讨论
                    // case2:有*出现的情况---不等于
                    //*是以它前面的字符的存在而存在的，所以要看它前面的字符
                    if (b.charAt(bi - 2) != a.charAt(ai - 1) && b.charAt(bi - 2) != '.') {
                        //这种情况下，只有它代表0个字符串时有可能匹配，所以就要看它前面的   "sa"  "sb*"只有b*代表0个字符时匹配，要看"sa" "s"是否匹配
                        match[ai][bi] = match[ai][bi - 2];
                    } else {
                        //case3:有*出现的情况---等于
                        //b.charAt(bi - 2) == a.charAt(ai - 1) || b.charAt(bi - 2) == '.'
                        match[ai][bi] = (match[ai][bi - 2]  //a*有0个a
                                || match[ai - 1][bi]        //a*有多个a
                                || match[ai][bi - 1]);      //a*有单个a
                    }
                }
            }
        }
        return match[alen][blen];
    }

    public static void main(String[] args) {
        RegularExpressionMatching10 regularExpressionMatching10 = new RegularExpressionMatching10();
        String a = "";
        String b = "ab*";
        boolean result = regularExpressionMatching10.isMatch(a,b);
        System.out.println(result);
    }
}
