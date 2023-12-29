package com.sandip;


public class Sorting {
    /**
     * Steps: (sorting in increasing order)
     *     ● First-of-all, we will find the smallest element of the array and swap it with index 0.
     *     ● Similarly, we will find the second smallest and swap that with the element at index 1 and so on…
     *     ● Ultimately, we will be getting a sorted array in increasing order only.
     * 
     * TC = O(n2)
     * SC = O(1)
     */
    public static void selectionSort(int arr[]) {

        for (int i=0; i<arr.length; i++) {
            int min = arr[i];
            int idx = i;

            for (int j=i+1; j<arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    idx=j;
                }
            }

            Utils.swap(arr, i, idx);
        }
    }


    /**
     * In this technique, we just compare the two adjacent elements of the array and then sort them
     * manually by swapping if not sorted. Similarly, we will compare the next two elements (one
     * from the previous position and the corresponding next) of the array and sort them manually.
     * This way the elements from the last get placed in their correct position. This is the difference
     * between selection sort and bubble sort.
     * 
     * TC = O(n2)
     * Sc = O(1)
     */
    public static void bubbleSort(int[] arr) {

        for (int i=arr.length-1; i>=0; i--) {
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    Utils.swap(arr, j, j+1);
                }
            }
        }
    }


    /**
     * Just like cards
     *     1. take element one by one,
     *     2. arrange them in sorting order
     *     3. if one card is there iterate over prevs and put where it is just bigger than that.
     *     4. keep elements moving towards right
     * 
     * TC = O(n2)
     * SC = O(1)
     */
    public static void insertionSort(int[] arr) {
        
        for (int i=0; i<arr.length; i++) {
            int curr = arr[i];
            
            for (int j=i-1; j>=0; j--) {
                if (arr[j] < curr) {
                    arr[j+1] = curr;
                    break;
                }

                arr[j+1] = arr[j];

                if (j==0) 
                    arr[j] = curr;
            }
        }
    }


    /**
     * Devide Array into sections till they become a single element then merge them in sorted order
     * 
     * TC = O(nlogn)
     * SC = O(n)
     */
    public static void mergeSort(int[] arr) {
        if (arr.length == 1) return;

        // left portion
        int[] left = new int[arr.length/2];

        for(int i=0; i<arr.length/2; i++) {
            left[i] = arr[i];
        }

        mergeSort(left);

        // right portion
        int temp = arr.length%2;

        int[] right = new int[arr.length/2 + temp];

        for (int i=0; i<arr.length/2 + temp; i++) {
            right[i] = arr[arr.length/2+i];
        }

        mergeSort(right);

        // merge left and right portion
        int l=0, r=0, i=0;
        
        while (l<left.length || r<right.length) {
            if (l>=left.length) {
                arr[i] = right[r];
                r++;
            } 

            else if (r>=right.length) {
                arr[i] = left[l];
                l++;
            } 

            else if (left[l] > right[r]) {
                arr[i] = right[r];
                r++;
            }

            else {
                arr[i] = left[l];
                l++;
            }

            i++;
        }

    }


    // TBD
    public static void countSort(int[] arr) {

    }
}
