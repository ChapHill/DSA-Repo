package linkedLists;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addToHead(T data) {
        ++size;
        if(isEmpty()) {
            this.head = this.tail = new Node<T>(data);
        } else {
            this.head.prev = new Node<T>(data, this.head, null);
            this.head = this.head.prev;
        }
    }

    public void addToTail(T data) {
        ++size;
        if(isEmpty()) {
            this.head = this.tail = new Node<T>(data);
        } else {
            this.tail.next = new Node<T>(data, null, this.tail);
            this.tail = tail.next;
        }
    }

    public void insertAt(int position, T data) {
        if(position < 1 || position > this.size+1) {
            throw new IllegalArgumentException("Position not valid");
        }
        if(position == 1) {
            addToHead(data);
        } else if(position == this.size + 1) {
            addToTail(data);
        } else {
            Node<T> runner = this.head;
            for(int i = 1; i < position-1; i++) {
                runner = runner.next;
            }
            Node<T> oldNext = runner.next;
            runner.next = new Node<T>(data, oldNext, runner);
            oldNext.prev = runner.next;
            ++this.size;
        }
    }

    public T removeHead() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty List");
        } else if(getSize() == 1){
            --this.size;
            T ret = this.head.data;
            this.head = this.tail = null;
            return ret;
        } else {
            --size;
            T ret = this.head.data; //return value
            this.head = this.head.next;
            this.head.prev = null;
            return ret;
        }
    }

    public T removeTail() {
        if(isEmpty()) {
            throw new NoSuchElementException("Can't remove from empty list");
        } else if(getSize() == 1) {
            --this.size;
            T ret = this.head.data;
            this.head = this.tail = null;
            return ret;
        } else {
            --this.size;
            T ret = this.tail.data; //return value
            this.tail = this.tail.prev;
            this.tail.next = null;
            return ret;
        }
    }

    public int getSize() {
        return this.size;
    }

    //print list in a visible manner and point to null at end of list
    public void printList() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        Node<T> runner = this.head;

        while(runner != null) {
            System.out.print(runner.data + " --> ");
            runner = runner.next;
        }
        System.out.print("null");
    }
}
