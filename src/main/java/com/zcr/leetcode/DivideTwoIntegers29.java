package com.zcr.leetcode;

public class DivideTwoIntegers29 {

    public int divideTwoIntegers(int dividend,int divisor){
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if(divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }
        long divd = (long)dividend;
        long divs = (long)divisor;
        int sign = 1;
        if (divd < 0) {
            divd = -divd;
            sign = -sign;
        }
        if (divs < 0) {
            divs = -divs;
            sign = -sign;
        }
        int res = 0;
        while (divd >= divs) {
            int shift = 0;
            while (divd >= divs << shift) {
                shift++;
            }
            res += (1 << (shift - 1));
            divd -= (divs << (shift - 1));
        }
        return sign * res;
    }

    public static void main(String[] args) {
        DivideTwoIntegers29 divideTwoIntegers29 = new DivideTwoIntegers29();
        int result = divideTwoIntegers29.divideTwoIntegers(32,3);
        System.out.println(result);
    }
}
