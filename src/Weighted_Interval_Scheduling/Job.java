package Weighted_Interval_Scheduling;

public class Job implements Comparable<Job>{
	int start, finish, profit;

    Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
    public int compareTo(Job other) {
        return Integer.compare(this.finish, other.finish);
    }
}
