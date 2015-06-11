class MyStack {
    // Push element x onto stack.
    private Queue<Integer> oldQ = new LinkedList<Integer>();
    private Queue<Integer> newQ = new LinkedList<Integer>();
    
    public void push(int x) {
        oldQ.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        shift(oldQ, newQ);
        oldQ.poll();
        
        Queue<Integer> temp = oldQ;
        oldQ = newQ;
        newQ = temp; 
    }

    // Get the top element.
    public int top() {
        shift(oldQ, newQ);
       
        int val = oldQ.peek();
        newQ.add(oldQ.poll());
        
        Queue<Integer> temp = oldQ;
        oldQ = newQ;
        newQ = temp; 
        
        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return oldQ.isEmpty() && newQ.isEmpty();
    }
    
    public void shift(Queue<Integer> oldQ, Queue<Integer> newQ){
        if(newQ.isEmpty()){
            int size = oldQ.size();
            int count = 0;
            while(!oldQ.isEmpty() && count<size-1){
                newQ.add(oldQ.poll());
                count++;
            }
        }
    }
}
