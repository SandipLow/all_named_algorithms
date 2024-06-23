package com.sandip;
import java.util.*;


public class Arrays {
    // Kadane's algorithm to find subarray with maximum sum
    public static int[] kadane(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sum=0;
        int maxi=Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            sum+=arr[i];
            ans.add(arr[i]);
            
            if (sum>maxi) {
                maxi=sum;
            }

            if (sum<0) {
                sum=0;
                ans=new ArrayList<>();
            }
        }

        int[] intArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            intArray[i] = ans.get(i);
        }

        return intArray;
    }
}
