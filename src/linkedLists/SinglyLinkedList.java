package linkedLists;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
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

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(T data) {
        ++this.size;
        if(isEmpty()) {
            this.head = this.tail = new Node<T>(data, null);
        } else {
            Node<T> oldHead = this.head;
            this.head = new Node<T>(data, oldHead);
        }
    }

    public void addToTail(T data) {
        ++size;
        if(isEmpty()) {
            this.head = this.tail = new Node<T>(data, null);
        } else {
            this.tail.next = new Node<T>(data);
            this.tail = this.tail.next;
        }
    }

    //insert at position and move previous elements over to the right
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
            runner.next = new Node<T>(data, oldNext);
            ++this.size;
        }
    }

    public T removeHead() {
        if(isEmpty()) {
            throw new NoSuchElementException("Can't remove from empty list");
        } else if(getSize() == 1) {
            --this.size;
            T ret = this.head.data;
            this.head = this.tail = null;
            return ret;
        } else {
            --this.size;
            Node<T> oldHead = this.head;
            T ret = oldHead.data; //return value
            this.head = this.head.next;
            oldHead = null; //memory cleanup
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
            Node<T> runner = this.head;
            while(runner.next != this.tail) {
                runner = runner.next;
            }
            Node<T> oldTail = this.tail;
            T ret = oldTail.data; //return value
            this.tail = runner;
            this.tail.next = null;
            oldTail = null; //memory cleanup
            return ret;
        }
    }


    public T removeAt(int position) {
        if(position < 1 || position > this.size) {
            throw new IllegalArgumentException("Position not valid");
        } else if(position == 1) {
            return removeHead();
        } else if(position == size) {
            return removeTail();
        } else {
            Node<T> runner = this.head;
            for(int i = 1; i < position-1; i++) {
                runner = runner.next;
            }
            Node<T> temp = runner.next;
            T ret = temp.data; //return value
            runner.next = temp.next;
            temp = null; //memory cleanup
            --size;
            return ret;
        }
    }

    public int getSize() {
        return this.size;
    }

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
