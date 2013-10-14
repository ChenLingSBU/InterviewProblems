package leetcode;

/*
 * note: [1,4],[2,7],[6,9]. after merge it should be [1,9] according to the test case of leetcode.
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import leetcodeLib.Interval;
public class MergeIntervals {
	
    public class IntervalSort implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
               if(i1.start < i2.start) return -1;
               if(i1.start > i2.start) return 1;
               else return 0;
           }
       } 
       
       public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
           ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();
           if(intervals.size() == 0) return mergedIntervals;
           Collections.sort(intervals, new IntervalSort());
           mergedIntervals.add(intervals.get(0));
           for(int i = 1; i < intervals.size(); i++){
               Interval t = mergedIntervals.get(mergedIntervals.size() - 1);
               if(isMerge(t, intervals.get(i))){
                   t.end = Math.max(t.end, intervals.get(i).end);
               }else{
                   mergedIntervals.add(intervals.get(i));
               }
           }
           return mergedIntervals;
       }
       
       boolean isMerge(Interval i1, Interval i2){
          if(i2.start > i1.end) return false;
          return true;
       }
	
	public static void main(String[] args) {
		
	}
}
