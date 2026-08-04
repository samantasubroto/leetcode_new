package sheet.fastandslow;

public class DuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        System.out.println(slow + "  " + fast);
        slow = 0;

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast]; //fast should move slow now in next step because they want to meet at certain position.
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }
}
