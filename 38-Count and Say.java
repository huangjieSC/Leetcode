public class Solution {
    public String countAndSay(int n) {
        if(n<1) return "";
        String s = "1";
        int index =1, count = 1;
        if(n==1) return s;
        
        for(index =1; index<n; index++){
            StringBuilder curr = new StringBuilder();
            int len = s.length(), j=0;
            while(j<len){
                if(j+1<len && s.charAt(j)==s.charAt(j+1)){
                    count++;
                }
                else{
                    curr.append(count);
                    curr.append(s.charAt(j));
                    count=1;
                }
                j++;
            }
            s = curr.toString();
        }
        return s;
    }
}
