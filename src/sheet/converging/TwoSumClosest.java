package sheet.converging;

import java.util.*;

public class TwoSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{10,20,30,40,50,60,70,80,90}, 1));
    }

    public static int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int closest = arr[0] + arr[1] + arr[2];

        for(int i=0;i<arr.length;i++) {
            int j = i+1;
            int k = arr.length - 1;
            while(j<k) {
                int sum = (arr[k] + arr[i] + arr[j]);
                if(Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                } if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                }
            }
        }
       return closest;
    }
}
