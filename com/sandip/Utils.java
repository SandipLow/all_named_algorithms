package com.sandip;

public class Utils {
    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    public static void printArr(int[] arr) {
        for (int e: arr) {
            System.err.print(e);
            System.err.print(" ");
        }
        System.out.println();
    }
}
