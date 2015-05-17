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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0) return list;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval x, Interval y) {
                return x.start-y.start;
            }
        });
        
        Interval temp = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(temp.end>=curr.start){
                Interval merged = new Interval(temp.start, Math.max(temp.end, curr.end));
				        temp = merged;
            }
            else{
                list.add(temp);
                temp = curr;
            }
        }
        list.add(temp);
        return list;
    }
}
