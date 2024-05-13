package Erliest_Finish_Time_First;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalScheduling {
	public static void intervalScheduling(List<Interval> intervals) {
		Collections.sort(intervals, Comparator.comparingInt(i -> i.endTime));
		List<Interval> selectedIntervals = new ArrayList<>();
		int lastFinishTime = 0;
		for (Interval interval : intervals) {
            if (interval.startTime >= lastFinishTime) {
                selectedIntervals.add(interval);
                lastFinishTime = interval.endTime;
            }
        }
		for (Interval interval : selectedIntervals) {
			System.out.println(interval.toString());
		}
    }
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(3, 7));
        intervals.add(new Interval(4, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(9, 11));
        IntervalScheduling.intervalScheduling(intervals);
	}
}
