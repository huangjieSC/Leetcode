public class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return s;
        
        String[] l = s.split(" ");
        if(l.length==0) return "";
        
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i=0; i<l.length; i++){
            if(!l[i].isEmpty()) // pay attention to this
                list.add(l[i]);
        }
        
        Collections.reverse(list);
        
        StringBuilder result = new StringBuilder();
        int i=0;
        for(i=0; i<list.size()-1; i++){
            if(!list.get(i).isEmpty()){
                result.append(list.get(i));
                result.append(" ");
            }
        }
        result.append(list.get(list.size()-1));
        return result.toString();
    }
}
