import java.util.Stack;

class MyQueue {
    // Two stacks to simulate the queue behavior
    private Stack<Integer> main;
    private Stack<Integer> helper;

    // Constructor to initialize the stacks
    public MyQueue() {
        main = new Stack<>();
        helper = new Stack<>();
    }
    
    // Push element x to the back of the queue
    public void push(int x) {
        // Step 1: Move all elements from main stack to helper stack
        while (main.size() > 0) {
            helper.push(main.pop());
        }
        
        // Step 2: Push the new element onto the empty main stack
        main.push(x);
        
        // Step 3: Move all elements back from helper stack to main stack
        while (helper.size() > 0) {
            main.push(helper.pop());
        }
    }
    
    // Removes the element from the front of the queue and returns it
    public int pop() {
        return main.pop();
    }
    
    // Get the front element
    public int peek() {
        return main.peek();
    }
    
    // Returns whether the queue is empty
    public boolean empty() {
        return main.isEmpty();
    }
}