package sheet.converging;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> arr = threesum(new int[]{-1,0,1,2,-1,-4}, 0);
        System.out.println(arr);
    }

    public static List<List<Integer>> threesum(int[] arr, int target) {
        Arrays.sort(arr);
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();

        for(int i=0;i<arr.length;i++) {
            int j = i+1;
            int k = arr.length - 1;
            while(j<k) {
                int sum = (arr[k] + arr[i] + arr[j]);
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else if (sum == target) {
                    result.add(Arrays.asList(arr[k], arr[i], arr[j]));
                    k--;
                    j++;
                }
            }
        }
        results.addAll(result);
        return results;
    }
}
