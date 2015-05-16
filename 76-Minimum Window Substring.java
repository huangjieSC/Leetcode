public class Solution {
    public String minWindow(String S, String T) {
        // Both the begin and end pointers can advance at most N steps (where N is S‘s size) in the worst case, adding to a total of 2N times. Therefore, the run time complexity must be in O(N).
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
         
        for(int i = 0; i < T.length(); ++i) {
            needToFind[T.charAt(i)]++;
        }
         
        int count = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start = 0, end = 0;
        String window = "";
         
        for(end = 0; end < S.length(); end++) { // keep moving end!
            if(needToFind[S.charAt(end)] == 0) 
                continue;
                
            char c = S.charAt(end);
            hasFound[c]++;
             
            if(hasFound[c]>=0 && hasFound[c] <= needToFind[c]) { // don't forget this!!
                count++;
            }
             
            if(count == T.length()) {
                while(needToFind[S.charAt(start)] == 0 ||hasFound[S.charAt(start)] > needToFind[S.charAt(start)]) // pay attention!!
                {
                    if(hasFound[S.charAt(start)] > needToFind[S.charAt(start)])
                        hasFound[S.charAt(start)]--;
                    start++;
                }
                 
                if(end - start + 1 < minWindowSize) {
                    minWindowSize = end - start + 1;
                    window = S.substring(start, end + 1);
                }
            }
        }
         
        return window;
    }
}
