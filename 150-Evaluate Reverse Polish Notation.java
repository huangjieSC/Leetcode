public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0) return -1;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int len = tokens.length;
        int i=0;
        String operators = "+-*/";
        
        while(i<len){
            if(!isOp(tokens[i]))
                stack.push(Integer.valueOf(tokens[i]));
            else{
                if(stack.isEmpty()) 
                    return -1;
                int a = stack.pop();
                if(stack.isEmpty()) 
                    return -1;
                int b = stack.pop();
                switch(tokens[i]){
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(b-a);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(b/a);
                        break;
                    default: 
                        return -1;
                }
            }
            i++;
        }
        
        if(!stack.isEmpty()){
            int val = stack.pop();
            return val;
        }
        return -1;
    }
    
    public boolean isOp(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }
}
