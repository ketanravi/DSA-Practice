package AlgoMaster.Stacks;

import java.util.Stack;

/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
    You must implement a solution with O(1) time complexity for each function.



    Example 1:

    Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    Output
    [null,null,null,null,-3,null,0,-2]

    Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2


    Constraints:

    -231 <= val <= 231 - 1
    Methods pop, top and getMin operations will always be called on non-empty stacks.
    At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            min = val;
        }
        else{
            if(val<=min){
                stack.push(min);
                min=val;
            }
            stack.push(val);
        }
    }

    public void pop() {
        if(stack.pop().equals(min)){
            min=stack.pop();

        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}
