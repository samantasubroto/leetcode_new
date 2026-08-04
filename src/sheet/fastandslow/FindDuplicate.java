package sheet.fastandslow;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        int i=0;
        int j = i+1;
        while (j < nums.length) {
            if(nums[i] == nums[j])
                return nums[i];
            i++;
            j = j + 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
}
