import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * LeetCode 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuySellStock {


    /**
     * Return the maximum profit you can achieve from this transaction.
     * If you cannot achieve any profit, return 0.
     * 
     * Track min price (when to buy).
     * Track max profit (when to sell).
     * 
     * Runtime: 1 ms, faster than 98.84% of Java online submissions.
     * Memory Usage: 51.7 MB, less than 53.59% of Java online submissions.
     * 
     * Execution: O(n)
     */
    static int maxProfit(int[] prices) {

        // **** perform sanity check(s) ****
        if (prices.length < 2)
            return 0;

        // **** initialization ****
        int maxProfit   = 0;
        int minPrice    = prices[0];

        // **** traverse the array of prices - O(n)****
        for (int i = 1; i < prices.length; i++) {

            // **** look for the min stock price (when to BUY) ****
            if (prices[i] < minPrice)
                minPrice = prices[i];

            // **** compute max profit (when to SELL) ****
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;

            // ???? ????
            System.out.println( "maxProfit <<< i: " + i + " minPrice: " + minPrice + 
                                " maxProfit: " + maxProfit);
        }

        // **** return max profit ****
        return maxProfit;
    }


    /**
     * Test scaffolding
     * 
     * !!!! NOT PART OF THE SOLUTION !!!!
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read price data ****
        String[] strs = br.readLine().trim().split(",");

        // **** close buffered reader ****
        br.close();
        
        // **** create and populate array of prices ****
        int[] prices = Arrays.stream(strs)
                            .mapToInt(Integer::parseInt)
                            .toArray();

        // ???? ????
        System.out.println("main <<< prices: " + Arrays.toString(prices));

        // **** compute and display the max profit ****
        System.out.println("main <<< profit: " + maxProfit(prices));
    }
}