package com.zcr.leetcode;

public class ZigZagConversion6 {

    public String convert(String s,int numRows) {
        char[] sChar = s.toCharArray();
        int len = s.length();
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                stringBuilders[idx].append(sChar[i]);
                i++;
            }
            for (int idx = numRows - 2; idx > 0 && i < len; idx--) {
                stringBuilders[idx].append(sChar[i]);
                i++;
            }
        }
        for (int j = 1; j < numRows; j++) {
            stringBuilders[0].append(stringBuilders[j]);
        }
        return stringBuilders[0].toString();
    }

    public static void main(String[] args) {
        ZigZagConversion6 zigZagConversion6 = new ZigZagConversion6();
        String s = "abcdefgh";
        int numsRos = 4;
        String result = zigZagConversion6.convert(s,numsRos);
        System.out.println(result);
    }
}
