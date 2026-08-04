package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    public static void main(String[] args) {
        int arr[] = twoSum(new int[]{2,7,11,15}, 9);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] twoSum(int[] arr, int target) {
        for(int i=0, j=arr.length-1; i < j ;) {
            if ((arr[i] + arr[j]) < target) {
                i++;
            } else if ((arr[i] + arr[j] > target)) {
                j--;
            } else if ((arr[i] + arr[j]) == target) {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{};
    }
}
