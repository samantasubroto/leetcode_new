package sheet.twopointers;

public class SortColors {

    public static void sortColors(int[] nums) {
        int[] constants = new int[3];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            constants[nums[i]]++;
        }
        for (int i = 0; i < constants.length; i++) {
            int size = constants[i];
            while (size != 0) {
                nums[j++] = i;
                size--;
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[] { 2, 0, 2, 1, 1, 0, 0 });
    }
}
