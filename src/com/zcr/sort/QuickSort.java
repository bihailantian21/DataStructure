package com.zcr.sort;

import java.util.Arrays;

/**
 * @author zcr
 * @date 2019/7/7-12:21
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,-1,900,4561};
        quickSort2(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    //快速排序
    public static void quickSort(int[] arr,int left,int right) {
        int  l = left;
        int r = right;
        int temp = 0;//临时变量
        int pivot = arr[(left + right) / 2];//中轴
        while (l < r) {//循环的目的是让比pivot小的值放到左边，比它大的值放到右边
            while (arr[l] < pivot) {//循环的目的是在左边一直找，找到大于等于pivot的值才退出
                l++;
            }
            while (arr[r] > pivot) {//循环的目的是在右边一直找，找到小于等于pivot的值才退出
                r--;
            }
            if (l >= r) {//说明pivot的左右两边的值已经按照左边全部是小于它，右边全部是大于它的顺序排好了
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个值arr[l] == pivot，r--
            if (arr[l] == pivot){
                r--;
            }
            //如果交换完后，发现这个值arr[r] == pivot，l++
            if (arr[r] == pivot){
                l++;
            }
        }

        //如果l== r，必须让l++,r--，否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(arr,left,r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr,l,right);
        }


    }

    //快速排序2
    public static void quickSort2(int[] arr,int low,int high) {
        int pivot;
        if (low >= high) {
            return;
        }
        pivot = partition(arr,low,high);
        quickSort2(arr,low,pivot - 1);
        quickSort2(arr,pivot + 1,high);
    }
    /**
     * 对数组a中下标从low到high的元素，选取基准元素pivotKey，
     * 根据与基准比较的大小，将各个元素排到基准元素的两端。
     * 返回值为最后基准元素的位置
     */
    public static int partition(int[] a, int low, int high) {
        int pivotKey = a[low];  //用第一个元素作为基准元素
        while (low < high) { //两侧交替向中间扫描
            while (low < high && a[high] >= pivotKey)
                high--;
            swap(a, low, high);  //比基准小的元素放到低端
            while (low < high && a[low] <= pivotKey)
                low++;
            swap(a, low, high);  //比基准大的元素放到高端
        }
        return low;     //返回基准元素所在位置
    }

    public static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
