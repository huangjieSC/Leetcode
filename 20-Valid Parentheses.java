public class Solution {
    public boolean isValid(String s) {
        if(s.length()==0) return true;
        
        Stack<Character> stack = new Stack<Character>();
        int index =0;
        
        
        while(index<s.length()){
            if(s.charAt(index)=='(' || s.charAt(index)=='{' || s.charAt(index)=='['){
                stack.push(s.charAt(index));
                index++;
            }
                
            else{
                if(stack.isEmpty())
                    return false;
                char c = stack.pop();
                if(c == '(' && s.charAt(index)==')')
                    index++;
                else if(c == '{' && s.charAt(index)=='}')
                    index++;
                else if(c == '[' && s.charAt(index)==']')
                    index++;
                else 
                    return false;
                
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}
