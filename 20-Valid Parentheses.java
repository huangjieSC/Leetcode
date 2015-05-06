public class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0) return true;
        int len=s.length(), i=0;
        
        Stack<Character> stack = new Stack<Character>();
        int index = 0;
      
        while(index<len){
             if(s.charAt(index)=='('||s.charAt(index)=='['||s.charAt(index)=='{'){
                stack.push(s.charAt(index));
                index++;
                continue;
             }
            
            if(stack.isEmpty()) return false;
            char current=stack.pop();
            
            if(current=='(' && s.charAt(index)!=')') return false;
            if(current=='[' && s.charAt(index)!=']') return false;
            if(current=='{' && s.charAt(index)!='}') return false;
            
            index++;
        }
        return stack.isEmpty()?true:false;
    }
}
