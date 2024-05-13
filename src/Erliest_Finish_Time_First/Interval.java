package Erliest_Finish_Time_First;

public class Interval{
	int startTime;
    int endTime;
    public Interval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Override
    public String toString() {
    	return startTime + " -> " + endTime;
    }
}
