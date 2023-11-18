package pg.com.ds.stack;

import java.util.Stack;

public class StockSpan {

    public static int[] calculateStockSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the current price is greater than the price at the index on the top of the stack
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }

            // If the stack is empty, the span for the current day is i + 1; otherwise,
            // it's the difference between the current index and the index on top of the stack
            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            // Push the current index onto the stack
            stack.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateStockSpan(prices);

        System.out.println("Stock Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        System.out.println("\nStock Spans: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}

