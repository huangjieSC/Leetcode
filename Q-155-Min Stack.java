class MinStack {
    private Stack<Integer> reg = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        reg.push(x);
        if(min.isEmpty()) min.push(x);
        else{
            int val = min.peek();
            if(x <= val) min.push(x);
        }
    }

    public void pop() {
        int val =0;
        if(!reg.isEmpty()) val = reg.peek();
        reg.pop();
        if(!min.isEmpty() && val == min.peek()) min.pop();
    }

    public int top() {
        if(!reg.isEmpty()) return reg.peek();
        else return -1;
    }

    public int getMin() {
        if(!min.isEmpty()) return min.peek();
        else return -1;
    }
}
