import java.sql.Array;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    static void printArray(int[] arr){
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void removeElement(int[] arr, int val) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min_idx] == val) {
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
        for(int i=arr.length-1;i>=0 && arr[i]==val;i--) {
            count++;
        }
        System.out.println(n - count);
        printArray(arr);
    }

    public static void rearrengeArray(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i=0,j=arr.length-1;i<j;i++,j--) {
            list.add(arr[i]);
            list.add(arr[j]);
        }
        System.out.println(list);
    }

//    public static int[] countWordOccurrences(String[] chunks, String[] queries) {
//
//        String combined = String.join("", chunks);
//        System.out.println(combined);
//        String[] tokens = combined.split(" ");
//        Map<String, Integer> incomingMap = new HashMap<>();
//        int[] result = new int[queries.length];
//        for (String chunk : tokens) {
//            for (int i=0;i<queries.length;i++) {
//                if (chunk.matches(queries[i])) {
//                    incomingMap.put(queries[i], incomingMap.getOrDefault(queries[i], 0) + 1);
//                }
//            }
//        }
//        for(int i=0;i<queries.length;i++) {
//            result[i] = incomingMap.get(queries[i]) != null ? incomingMap.get(queries[i]) : 0;
//        }
//        return result;
//    }

    public static int[] countWordOccurrences(String[] chunks, String[] queries) {
        String combined = String.join("", chunks);
        String[] tokens = combined.split("[^a-zA-Z]+");
        Map<String, Integer> map = new HashMap<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                map.put(token, map.getOrDefault(token, 0) + 1);
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = map.getOrDefault(queries[i], 0);
        }
        return result;
    }

    public static void main(String[] args) {

        for (int values : countWordOccurrences(new String[]{"hello wor","ld hello"}, new String[]{"hello","world","wor"})) {
            System.out.print(values + " ");
        }
    }
}