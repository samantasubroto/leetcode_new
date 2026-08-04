package array;

import java.util.HashMap;
import java.util.Map;

//167
public class TwoSum {

    public static void main(String[] args) {
        int arr[] = twoSum(new int[]{3, 2, 4}, 6);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            map.put(arr[i], i);
        }
        for(int i=0;i<arr.length;i++) {
            if (map.containsKey(target - arr[i]) && map.get(target - arr[i]) != i){
                return new int[]{i, map.get(target - arr[i])};
            }
        }
        return new int[]{};
    }
}
