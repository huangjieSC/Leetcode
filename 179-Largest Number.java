public class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) return "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int n: nums)
            list.add(n);
            
         Collections.sort(list, new Comparator<Integer>(){
             public int compare(Integer o1, Integer o2) {
                 String s1 = "" + o1 + o2;
                 String s2 = "" + o2 + o1;
                 
                 return s2.compareTo(s1); // pay attention, we want the biggest before the smaller, so it is s2.compareTo(s1)
             }
         });
        StringBuilder s = new StringBuilder();
        for(int n: list)
            s.append(n);
            
        if(s.charAt(0)=='0') return "0";
        return s.toString();
    }
}
