package com.zcr.leetcode;

public class IsPalindromeNumber8 {

    public boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        int divs = 1;
        int numcopy = num;
        while (numcopy / divs >= 10) {
            divs *= 10;
        }
        while (num != 0 ){
            int left = num / divs;
            int right = num % 10;
            if (left != right) {
                return false;
            }
            num = (num - left * divs) / 10;
            divs /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindromeNumber8 isPalindromeNumber8 = new IsPalindromeNumber8();
        int num = 1232102321;
        boolean result = isPalindromeNumber8.isPalindrome(num);
        System.out.println(result);
    }
}
