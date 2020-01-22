package com.zcr.leetcode;

public class RemoveDuplicatesFromSortedArray26 {

    public int removeDuplicates(int[] array) {
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[fast - 1]) {
                array[slow] = array[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray26 re = new RemoveDuplicatesFromSortedArray26();
        int[] array = {1,1,2,2,3,4,5};
        int result = re.removeDuplicates(array);
        System.out.println(result);
    }
}
