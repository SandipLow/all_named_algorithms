package com.sandip;

public class Traversing {

    /**
     * Linear Search
     * @param arr search array
     * @param key value to search
     * @return index of element
     */
    public static int linearSearch(int[] arr, int key) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == key) return i;
        }

        return -1;
    }

    
    /**
     * Binary Search
     * @param arr search array
     * @param key value to search
     * @return index of element
     */
    public static int binarySearch(int[] arr, int key) {
        int s=0, e=arr.length-1;
        int mid = s + (e-s)/2;

        while (s<e) {
            if (arr[mid]==key) {
                return mid;
            }

            else if (arr[mid]>key) {
                s=mid+1;
            }

            else {
                e=mid-1;
            }

            mid = s+(e-s)/2;
        }

        return -1;
    }
    
}