package com.zcr.leetcode;

public class SearchInRotatedSortedArray33 {
    public int sarchInRotatedSortedArray(int[] num,int target) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int left = 0;
        int right = num.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == target) {
                return mid;
            }
            if (num[mid] > num[left]) {
                if (num[left] <= target && target <= num[right]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (num[mid] < num[right]){
                if (num[left] <= target && target <= num[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (num[left] == target) {
            return left;
        }
        if (num[right] == target) {
            return right;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] num = {4,5,0,1,2};
        int target = 5;
        SearchInRotatedSortedArray33 searchInRotatedSortedArray33 = new SearchInRotatedSortedArray33();
        int result = searchInRotatedSortedArray33.sarchInRotatedSortedArray(num,target);
        System.out.println(result);

    }

}
