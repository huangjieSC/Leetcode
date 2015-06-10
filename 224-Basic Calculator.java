public class Solution {
    public static int calculate(String s) {
        String tokens[] = toRPN(s).split("\\s+");
        int returnValue = 0;

        String operators = "+-";

        Stack<String> stack = new Stack<String>();

        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;
    }

    public static String toRPN(String input) {
        char[] in = input.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < in.length; i++)
            switch (in[i]) {
            case '+':
            case '-':
                while (!stack.empty() && stack.peek() != '(') {
                    out.append(' ');
                    out.append(stack.pop());
                }
                out.append(' ');
                stack.push(in[i]);
                break;
            case '(':
                stack.push(in[i]);
                break;
            case ')':
                while (!stack.empty() && stack.peek() != '(') {
                    out.append(' ');
                    out.append(stack.pop());
                }
                stack.pop();
                break;
            case ' ':
                break;
            default:
                out.append(in[i]);
                break;
            }

        while (!stack.isEmpty()) {
            out.append(' ');
            out.append(stack.pop());

        }
        return out.toString();
    }
}
