package greedy;

import java.util.Arrays;

public class BuyAndSellStocksI {

    public static int maxProfit(int[] prices) {
       int max = 0;
       int minPrice = 0;
       int maxPrice = 0;
       for(int i=1;i<prices.length;i++) {
           if(prices[i-1] < prices[i]) {
               minPrice = prices[i-1];
           }
       }
       return minPrice;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
