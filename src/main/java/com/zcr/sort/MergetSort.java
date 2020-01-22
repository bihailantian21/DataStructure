package com.zcr.sort;

import java.util.Arrays;

/**
 * @author zcr
 * @date 2019/7/7-16:41
 */
public class MergetSort {

    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length - 1,temp);
        System.out.println("归并排序后="+ Arrays.toString(arr));
    }

    //分 + 合方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归分解
            mergeSort(arr,mid + 1,right,temp);
            //每分解一次合并
            merge(arr,left,mid,right,temp);
        }
    }


    //合并的方法
    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param middle 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr,int left,int middle,int right,int[] temp) {
        System.out.println("xxxx");
        int i = left;//初始化i，左边有序序列的初始索引
        int j = middle + 1;//初始化j，右边有序序列的初始索引
        int t = 0;//指向temp数组的当前索引

        //先把左右两边的数据（已经有序）按照规则填充到temp数组中，直到左右两边有一边全部处理完毕
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {//如果左边的有序序列的当前元素，小于等于，右边有序序列的当前元素
                temp[t] = arr[i];//将左边的当前元素拷贝到temp数组中
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //把有剩余数据的一方依次全部填充到temp数组中
        while (i <= middle){//说明左边的有序序列还有剩余的元素
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){//说明右边的有序序列还有剩余的元素
            temp[t] = arr[j];
            t++;
            j++;
        }
        //将temp数组重新全部拷贝到arr数组中
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft=" + tempLeft + "right=" + right);
        while (tempLeft <= right) {//第一次合并时，tempLeft=0,right=1//第一次合并时，tempLeft=2,right=3//第一次合并时，tempLeft=0,right=3
            arr[tempLeft] = temp[t];//最后一次合并时，tempLeft=0,right=7
            tempLeft++;
            t++;
        }

    }
}
