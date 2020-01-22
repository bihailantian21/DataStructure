package com.zcr.leetcode;

public class ReverseInteger7 {

    public int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            int newrev = rev * 10 + num % 10;
            //处理overflow的情况
            if ((newrev - num % 10) / 10 != rev) {
                return 0;
            }
            rev = newrev;
            num = num / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger7 reverseInteger7 = new ReverseInteger7();
        int num = (int) Math.pow(2,31) - 1;
        System.out.println(num);
        int result = reverseInteger7.reverse(num);
        System.out.println(result);
    }
}
