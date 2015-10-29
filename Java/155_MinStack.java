/*************************************************************************
    > File Name: 155_MinStack.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 15:32:43 2015
 ************************************************************************/
class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minstack = new Stack<Integer>();
    
    public void push(int x) {
        if (minstack.isEmpty() || x <= minstack.peek()) {
            minstack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minstack.peek())) {
            minstack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
/*
class MinStack {
    Node top = null;

    public void push(int x) {
        if (top == null) {
            top = new Node(x);
            top.min = x;
        } else {
            Node temp = new Node(x);
            temp.next = top;
            top = temp;
            top.min = Math.min(top.next.min, x);
        }
    }

    public void pop() {
        top = top.next;
        return;
    }

    public int top() {
        return top == null ? 0 : top.val;
    }

    public int getMin() {
        return top == null ? 0 : top.min;
    }
}

class Node {
    int val;
    int min;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
*/

