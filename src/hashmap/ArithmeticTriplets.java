package hashmap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ArithmeticTriplets {
    public static void arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int tripleCount = 0;
        for (int i=0;i<nums.length;i++) {
            int count = nums[i] + diff;
            if (set.contains(count) && set.contains(count + diff)) {
                tripleCount++;
            }
        }
        System.out.println(tripleCount);
    }

    public static void main(String[] args) {
        arithmeticTriplets(new int[]{0,1,4,6,7,10}, 3);
    }
}
