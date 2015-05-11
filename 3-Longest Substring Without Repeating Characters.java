public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        
        Set<Character> set = new HashSet<Character>();
        int max_len = 0;
        int head = 0, tail = 0;
        int len = s.length();
        
        while(head<len && tail<len){
            char ch = s.charAt(tail);
            if(!set.contains(ch)){
                set.add(ch);
            }
            else{
                int cur_len = tail-head;
                max_len = Math.max(max_len,cur_len);
                
                while(head<len && s.charAt(head)!=ch){ 
                    set.remove(s.charAt(head));
                    head++;
                }
                head++;
            }
            tail++;
        }
        max_len = Math.max(max_len, tail-head);
        return max_len;
    }
}
