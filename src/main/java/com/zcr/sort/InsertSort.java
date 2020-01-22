package com.zcr.sort;

import java.util.Arrays;

/**
 * @author zcr
 * @date 2019/7/7-9:53
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101,34,119,1,-1,89};
        insertSort(arr);
        /*int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);//会生成一个0~80000的随机数
        }

        System.out.println("排序前：");
        //System.out.println(Arrays.toString(arr));
        long l1 = System.currentTimeMillis();
        insertSort(arr);
        long l2  = System.currentTimeMillis();
        System.out.println(l2 - l1);
        System.out.println("排序后：");*/
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr) {
        //使用逐步推导的方式讲解

        //第一轮 [34 101] 119 1
        //定义待插入的数
        /*int insertVal = arr[1];
        int insertIndex = 0;//1-1，即arr[1]的前面这个数的下标
        //给insertVal找到插入的位置
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {//保证在找插入位置时不越界，保证待插入的数还没有找到插入位置
            //当前的arr[insertIndex]后移
            arr[insertIndex + 1] = arr[insertIndex];//101 101 119 1
            insertIndex--;//与前面那个数比较
        }
        //当退出while循环时，说明插入的位置找到，insertIndex + 1
        arr[insertIndex + 1] = insertVal;
        System.out.println("第一轮插入后：");
        System.out.println(Arrays.toString(arr));

        //第二轮 [34 101 119 ]  1
        //定义待插入的数
        insertVal = arr[2];
        insertIndex = 1;//2-1，即arr[1]的前面这个数的下标
        //给insertVal找到插入的位置
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {//保证在找插入位置时不越界，保证待插入的数还没有找到插入位置
            //当前的arr[insertIndex]后移
            arr[insertIndex + 1] = arr[insertIndex];//
            insertIndex--;//与前面那个数比较
        }
        //当退出while循环时，说明插入的位置找到，insertIndex + 1
        arr[insertIndex + 1] = insertVal;
        System.out.println("第二轮插入后：");
        System.out.println(Arrays.toString(arr));

        //第二轮 [1 34 101 119]
        //定义待插入的数
        insertVal = arr[3];
        insertIndex = 2;//3-1，即arr[1]的前面这个数的下标
        //给insertVal找到插入的位置
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {//保证在找插入位置时不越界，保证待插入的数还没有找到插入位置
            //当前的arr[insertIndex]后移
            arr[insertIndex + 1] = arr[insertIndex];//
            insertIndex--;//与前面那个数比较
        }
        //当退出while循环时，说明插入的位置找到，insertIndex + 1
        arr[insertIndex + 1] = insertVal;
        System.out.println("第三轮插入后：");
        System.out.println(Arrays.toString(arr));*/

        //进行数组长度-1次（因为第一个为基准，给后面的几个数找位置）
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;//i-1，即arr[1]的前面这个数的下标
            //给insertVal找到插入的位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {//保证在找插入位置时不越界，保证待插入的数还没有找到插入位置
                //当前的arr[insertIndex]后移
                arr[insertIndex + 1] = arr[insertIndex];//101 101 119 1
                insertIndex--;//与前面那个数比较
            }
            //当退出while循环时，说明插入的位置找到，insertIndex + 1
            //判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            //System.out.println("第"+ i +"轮插入后：");
            //System.out.println(Arrays.toString(arr));
        }


    }
}
