package leetcode;


/*
 * It's similar to Merge Intervals.
 * be careful of note1 and note2, note the constrains in while loop. 
 */
import java.util.ArrayList;
import leetcodeLib.Interval;
public class InsertInterval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> mergedInterval = new ArrayList<Interval>();
        int n = intervals.size();
        int i = 0;
        while(i < n && newInterval.start > intervals.get(i).end){ //note1
            mergedInterval.add(intervals.get(i++));
        }
        
        while(i < n && newInterval.end >= intervals.get(i).start){ //note2
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        mergedInterval.add(newInterval);
        while(i < n)
            mergedInterval.add(intervals.get(i++));
        return mergedInterval;
        
    }
	public static void main(String[] args) {
	
	}
}
