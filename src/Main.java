import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void maximumWealth(int[] accounts) {
        Arrays.sort(accounts);
        double average = Double.MAX_VALUE;
        for(int i=0,j=accounts.length-1;i<j;i++,j--) {
            if(((accounts[i] + accounts[j]) / 2.0) < average) {
                average = ((accounts[i] + accounts[j]) / 2.0);
            }
        }
        System.out.println(average);
    }

    public static int findMaxK(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0, j = arr.length - 1; i < j; ) {
            if (arr[j] + arr[i] != 0) {
                if (Math.abs(arr[i]) > arr[j])
                    i++;
                else j--;
            }else {
                return arr[j];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String[] str = new String[]{"abc","bcd","aaaa","cbc"};
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<str.length;i++)
           if(str[i].contains(String.valueOf('c')))
               list.add(i);

    }
}