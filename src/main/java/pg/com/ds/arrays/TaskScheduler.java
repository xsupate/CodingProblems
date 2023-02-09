package pg.com.ds.arrays;

import java.util.Arrays;

public class TaskScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int leastInterval(char[] tasks, int n) {
		
		int[] feq = new int[26];
		for(char ch : tasks) {
			feq[ch - 'A']++;
		}
		Arrays.sort(feq);
		int chunk = feq[25];
		int idleTime = chunk*2 ;
		
		for(int i = 24; i >=0; i--) {
			idleTime -= Math.min(feq[i], chunk);
			if(idleTime <= 0)
				break;
		}
		
		return idleTime < 0 ? tasks.length : idleTime + tasks.length;
	}

}
