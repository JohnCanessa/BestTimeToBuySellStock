import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class BestTimeToBuySellStock {


    /**
     * Track min price (when to buy).
     * Track max profit (when to sell).
     * O(n)
     */
    static int maxProfit(int[] prices) {

        // **** sanity check(s) ****
        if (prices.length == 0)
            return 0;
            
        // **** initialization ****
        int maxProfit   = 0;
        int minPrice    = Integer.MAX_VALUE;

        // **** traverse the array of prices ****
        for (int i = 0; i < prices.length; i++) {

            // **** look for the min stock price (when to buy) ****
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // **** compute max profit (when to sell) ****
            else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }

            // ???? ????
            // System.out.println( "<<< i: " + i + " minPrice: " + minPrice + 
            //                     " maxProfit: " + maxProfit);
        }

        // **** return profit ****
        return maxProfit;
    }


    /**
     * Test scaffolding
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

        // **** compute and display the day to sell ****
        System.out.println("main <<< profit: " + maxProfit(prices));
    }
}