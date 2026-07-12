package recursion;

import javax.management.relation.RoleList;
import java.util.*;

public class ThreeDigitEven {
    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && i != k) {
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if ( num % 2 == 0) {
                            set.add(num);
                        }
                    }
                }
            }
        }
        return set.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

    public static void main(String[] args) {
        int[] value = findEvenNumbers(new int[]{2,2,8,8,2});
        for(int i = 0;i<value.length;i++) {
            System.out.println(value[i] + " ");
        }
    }
}
