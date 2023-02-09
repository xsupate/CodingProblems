package pg.com.ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures = {30,40,50,60};
		int[] res = noDayToWait(temperatures);
		Arrays.stream(res).forEach(s -> System.out.print(s + " "));
	}

	public static int[] noDayToWait(int[] temperatures) {
		int n = temperatures.length;
		int[] res = new int[n];
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
				res[s.peek()] = i - s.peek();
				s.pop();
			}
			s.push(i);
		}
		return res;

	}
}
