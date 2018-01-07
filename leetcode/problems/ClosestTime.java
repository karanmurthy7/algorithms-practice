package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
 * There is no limit on how many times a digit can be reused. 
 * You may assume the given input string is always valid. 
 * For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 * Example 1:
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * 
 * Example 2:
 * Input: "23:59"
 * Output: "22:22" 
 */

public class ClosestTime {

    public static String nextClosestTime(String time) {
    	String[] val = time.split(":");
    	Set<Integer> numberSet = new HashSet<Integer>();
    	int hour = addToSet(numberSet, val[0]);
    	int minute = addToSet(numberSet, val[1]);
    	
    	int times[] = new int[] {hour, minute};
    	nextTime(times);
    	while(!setContainsNumbers(numberSet, times[0], times[1])) {
    		nextTime(times);
    	}
    	
    	return (valid(times[0]) + ":" + valid(times[1]));
    }
    
	private static String valid(int time) {
		if (time <= 9 && time >= 0) 
			return "0" + time;
		return "" + time;
	}

	private static boolean setContainsNumbers(Set<Integer> numberSet, int hour, int minute) {
		return numberSet.contains(hour / 10) &&
				numberSet.contains(hour % 10) && 
				numberSet.contains(minute / 10) && 
				numberSet.contains(minute % 10);
	}

	private static void nextTime(int[] times) {
		int hour = times[0];
		int minute = times[1];
		
		minute++;
		if(minute == 60) {
			minute = 0;
			hour ++;
			if (hour == 24) hour = 0;
		}
		
		times[0] = hour;
		times[1] = minute;
	}

	private static int addToSet(Set<Integer> numberSet, String timeStr) {
		int time = Integer.parseInt(timeStr);
		numberSet.add(time % 10);
		numberSet.add(time / 10);
		return time;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nextClosestTime("23:51"));
	}

}
