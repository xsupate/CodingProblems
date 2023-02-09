package pg.com.ds.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms => room1: (0,30) and  room2: (5,10),(15,20)
 */

public class MinimumMeetingRooms {

	public static void main(String[] args) {
		List<Interval> intervals = Arrays.asList(new Interval(0,30),new Interval(5,10), 
				new Interval(7,12), new Interval(15,20));
        System.out.println("Minimum meeting room required : " + findMiniMeetingRooms(intervals));
	}

	public static int findMiniMeetingRooms(List<Interval> intervals) {
		int roomCount = 0;
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start,b.start));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(Interval interval : intervals) {
			if(!pq.isEmpty() && interval.start >= pq.peek()) {
				pq.poll();
			}else {
				roomCount++;
			}
			pq.add(interval.end);
		}
		
		return roomCount;
	}
	
	/**
	 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
	 * determine if a person could attend all meetings. 
	 * 
	 * @param intervals start and end times 
	 * @return @true if person can attends all meetings else @false
	 */
	
	public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2)
          return true;
       
        Collections.sort(intervals, (a, b)-> Integer.compare(a.start, b.start));
        int firstEnd = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
              if(firstEnd > intervals.get(i).start){
                   return false;
              }else{
                  firstEnd = firstEnd > intervals.get(i).end 
                  ? firstEnd :intervals.get(i).end;
              }
        }
        
        return true;
    }
}
