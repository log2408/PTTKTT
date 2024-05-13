package Weighted_Interval_Scheduling;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeightedIntervalScheduling {
	private static int findLastNonConflictingJob(List<Job> jobs, int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs.get(mid).finish <= jobs.get(n).start) {
                if (jobs.get(mid + 1).finish <= jobs.get(n).start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int maxProfit(List<Job> jobs) {
        Collections.sort(jobs); 
        int n = jobs.size(); 
        int[] maxProfit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int incl = jobs.get(i - 1).profit; 
            int index = findLastNonConflictingJob(jobs, i - 1);
            if (index != -1) {
                incl += maxProfit[index + 1];
            }
            maxProfit[i] = Math.max(incl, maxProfit[i - 1]);
        }
        return maxProfit[n]; 
    }
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job(0, 6, 60),
                new Job(1, 4, 30),
                new Job(3, 5, 10),
                new Job(5, 7, 30),
                new Job(5, 9, 50),
                new Job(7, 8, 10)
        );
        System.out.println("The maximum profit is " + maxProfit(jobs));
    }
}
