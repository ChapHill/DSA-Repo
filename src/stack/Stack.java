package stack;

/**
 * 2 Main operations: Push and Pop
 * Can only remove and add items from the top of the stack
 */

import java.util.NoSuchElementException;

public class Stack<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return this.size;
    }

    public void push(T data) {
        ++size;
        if(top == null) {
            this.top = new Node<T>(data, null);
        } else {
            Node<T> oldTop = top;
            this.top = new Node<T>(data, oldTop);
        }
    }

    public T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty Stack");
        } else {
            Node<T> oldTop = top;
            T ret = oldTop.data; //return value
            top = top.next;
            oldTop = null; //memory cleanup
            return ret;
        }
    }

    public T peek() {
        return this.top.data;
    }

    public void printStack() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty Stack");
        } else {
            Node<T> runner = top;

            while(runner != null) {
                System.out.println(runner.data + "\n----------");
                runner = runner.next;
            }
        }
    }
}
