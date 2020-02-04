package com.zcr.offer.recursionandloop;

/**
 * 计算1+2+...+100
 */
public class RecursionandLoop {

    public int recursion(int n) {
        return n <= 0 ? 0 : n + recursion(n - 1);
    }

    public int loop(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
