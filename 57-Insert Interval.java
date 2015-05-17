/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<Interval>();
        if(intervals==null) return list;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval x, Interval y) {
                return x.start-y.start;
            }
        });
        
        Interval temp = newInterval;
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(temp.end<curr.start){
                list.add(temp);
                temp = curr;
            }
            else if(temp.start>curr.end){
                list.add(curr);
              //  temp = newInterval;
            }
            else
            {   Interval merged = new Interval(Math.min(curr.start,temp.start), Math.max(curr.end,temp.end));
                temp = merged;
            }
        }
        
        list.add(temp);
        return list;
    }
}
