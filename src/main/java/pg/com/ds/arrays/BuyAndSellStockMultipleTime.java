package pg.com.ds.arrays;

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like 
 * (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 */

public class BuyAndSellStockMultipleTime {

	public static void main(String[] args) {
		int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println("Maximum profit is " + maxProfit(prices));
        System.out.println("Maximum profit is " + maxProfitSellStocks(prices));
	}
	
	public static int maxProfit(int[] prices) {
		int profit = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > prices[i-1])
				profit += prices[i] - prices[i-1];
		}

		return profit;
	}
	
	
	// for one buy and one sell 
	public static int maxProfitSellStocks(int[] prices)
    {
        int n = prices.length;
        int cost = 0;
        int maxCost = 0;
 
        if (n == 0) {
            return 0;
        }
 
        // store the first element of array in a variable
 
        int min_price = prices[0];
 
        for (int i = 1; i < n; i++) {
            // now compare first element with all the element of array and find the minimum element
            min_price = Math.min(min_price, prices[i]);
            // since min_price is smallest element of the array so subtract
            // with every element of the array and return the maxCost
            cost = prices[i] - min_price;

            maxCost = Math.max(maxCost, cost);
        }
        return maxCost;
    }

}
