package com.zcr.sort;

import java.util.Arrays;

/**
 * @author zcr
 * @date 2019/7/7-8:59
 */
public class SelectSort {

    public static void main(String[] args) {
        //int[] arr = {101,34,119,1};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);//会生成一个0~80000的随机数
        }

        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        long l1 = System.currentTimeMillis();
        selectSort(arr);
        long l2  = System.currentTimeMillis();
        System.out.println(l2 - l1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));

    }

    //选择排序
    public static void selectSort(int[] arr) {

        //使用逐步推导的方式。可以把一个复杂的算法拆分成简单的问题，然后逐步解决。最后综合
        //第一轮
        //原始数组：101,34,119,1
        //第一轮排序：1,34,119,101
        /*int minIndex = 0;
        int min = arr[minIndex];
        for (int i = 0 + 1; i < arr.length; i++) {//从下标为1的开始一直到最后（下标为0的为最小值）
            if (min > arr[i]) {//说明我们假定的最小值并不是最小
                min = arr[i];//重置最小值
                minIndex = i;//重置最小的的下标值
            }
        }
        //将最小值放在arr[0]，把arr[0]放在最小值的位置
        if (minIndex != 0){
            arr[minIndex] = arr[0];//把arr[0]放在最小值的位置
            arr[0] = min;//将最小值放在arr[0]
        }
        System.out.println("第一轮后：");
        System.out.println(Arrays.toString(arr));//1,34,119,101

        //第二轮
        minIndex = 1;
        min = arr[1];
        for (int i = 1 + 1; i < arr.length; i++) {//从下标为2的 开始一直到最后（下标为1的为最小值）
            if (min > arr[i]) {//说明我们假定的最小值并不是最小
                min = arr[i];//重置最小值
                minIndex = i;//重置最小的的下标值
            }
        }
        //将最小值放在arr[0]，把arr[0]放在最小值的位置
        if (minIndex != 1){
            arr[minIndex] = arr[1];//把arr[0]放在最小值的位置
            arr[1] = min;//将最小值放在arr[0]
        }
        System.out.println("第二轮后：");
        System.out.println(Arrays.toString(arr));//1,34,119,101

        //第三轮
        minIndex = 2;
        min = arr[2];
        for (int i = 2 + 1; i < arr.length; i++) {//从下标为3的开始一直到最后（下标为2的为最小值）
            if (min > arr[i]) {//说明我们假定的最小值并不是最小
                min = arr[i];//重置最小值
                minIndex = i;//重置最小的的下标值
            }
        }
        //将最小值放在arr[0]，把arr[0]放在最小值的位置
        if (minIndex != 2){
            arr[minIndex] = arr[2];//把arr[0]放在最小值的位置
            arr[2] = min;//将最小值放在arr[0]
        }
        System.out.println("第三轮后：");
        System.out.println(Arrays.toString(arr));//1,34,101，119*/


        //一共要进行数组长度-1趟循环
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {//从下标为i+1的开始一直到最后（下标为i的为最小值）
                if (min > arr[j]) {//说明我们假定的最小值并不是最小
                    min = arr[j];//重置最小值
                    minIndex = j;//重置最小的的下标值
                }
            }
            //将最小值放在arr[0]，把arr[0]放在最小值的位置
            if (minIndex != i){
                arr[minIndex] = arr[i];//把arr[i]放在最小值的位置
                arr[i] = min;//将最小值放在arr[i]
            }
            /*System.out.println("第"+ (i+1) + "轮后：");
            System.out.println(Arrays.toString(arr));*/
        }


    }
}
