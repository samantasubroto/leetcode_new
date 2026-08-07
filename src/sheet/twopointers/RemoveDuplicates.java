package sheet.twopointers;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int i = 1, j=1;
        for(i=1,j=1;j<nums.length;j++) {
            if (nums[j] != nums[j-1]) { //unique value found
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
