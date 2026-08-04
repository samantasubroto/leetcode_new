package sheet.converging;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] a, int target) {
        Arrays.sort(a);
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < a.length-1; i++) {
            for(int z = i+1; z<a.length; z++) {
                int j = z + 1, k = a.length - 1;
                while (j < k) {
                    long sum = (long) a[i] + a[j] + a[k] + a[z];
                    if (sum < target) {
                        j++;
                    } else if (sum > target) {
                        k--;
                    } else if (sum == target) {
                        result.add(Arrays.asList(a[i], a[z], a[j], a[k]));
                        k--;
                        j++;
                    }
                }
            }
        }
        results.addAll(result);
        return results;
    }
}
