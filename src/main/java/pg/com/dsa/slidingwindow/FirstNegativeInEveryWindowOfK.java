package pg.com.dsa.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class FirstNegativeInEveryWindowOfK {

	public static void main(String[] args) {
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3;
		//int arr[] = {-8, 2, 3, -6, 10}, k = 2;
		printFirstNegative(arr, k);
		System.out.println();
		printFirstNegativeNumber(arr, k);
	}

	public static void printFirstNegative(int[] arr, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		int start = 0, end = 0;
		while(start < arr.length-k+1) {
			end = start;
			while(end-start+1 <= k && end < arr.length) {
				if(arr[end] < 0) {
					q.add(arr[end]);
				}
				
				if(end-start+1 == k) {
					if(!q.isEmpty()) {
						System.out.print(q.peek() + " ");
					}else {
						System.out.print(0 + " ");
					}
					q.remove(arr[start]); // remove the released element from queue also.
					start++;              // Releasing element from sliding window
				}
				
				end++;
			}
		}
	}
	
	public static void printFirstNegativeNumber(int[] arr, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		int start = 0, end = 0;
		while(start < arr.length-k+1) {
			end = start;
			
			while(end < start+k && end < arr.length) {
				if(arr[end] < 0) {
					q.add(arr[end]);
				}
				
				if(end+1 == start+k) {
				  	if(q.isEmpty()) {
				  		System.out.print(0 + " ");
				  	}else {
				  		System.out.print(q.peek() + " ");
				  	}
				  	q.remove(arr[start]);// remove the released element from queue also.
				  	start++; // Releasing element from sliding window
				}
				end++;
			}
			
		}
	}		
}
