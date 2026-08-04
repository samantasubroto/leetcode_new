package greedy;

import java.util.Arrays;

//881
public class BoatsToSavePeopple {
    public int numRescueBoats(final int[] people, final int limit) {
        Arrays.sort(people);
        int boats = 0;
        int i = 0, j = people.length - 1;

        while (i <= j) {
            int rem = limit - people[j];
            j--;
            boats += 1;
            if(i <= j && people[i] <= rem) {
                i++;
            }
        }
        return boats;
    }
    public static void main(String[] args) {

    }
}
