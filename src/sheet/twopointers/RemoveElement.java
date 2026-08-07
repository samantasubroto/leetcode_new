package sheet.twopointers;

public class RemoveElement {

    public static int removeElement(int[] arr, int val) {
        int count = 0;
        int i=0,j=arr.length-1;
        for (i=0,j=arr.length-1;i<=j;) {
            if (arr[i] == val) {
                count++;
                if (arr[j] != val) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    j--;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return (arr.length) - count;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));;
        // removeElement(new int[]{3,3,3,3}, 3);
    }
}
