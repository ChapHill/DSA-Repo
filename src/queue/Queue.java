package queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Queue implementation with Java's built in linked list
 * Also providing a way to traverse through the elements
 * of the Queue with the use of an Iterator
 *
 * to implement the Iterator :
 *
 *         Iterator<type> itr = q.iterator();
 *
 *         while(itr.hasNext()) {
 *             System.out.println(itr.next());
 *         }
 */

public class Queue<T> implements Iterable<T>{

    private LinkedList<T> queue = new LinkedList<>();

    public Queue() {

    }

    //create queue with a first element
    public Queue(T element) {
        queue.addLast(element);
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public T peekFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        } else {
            return queue.peekFirst();
        }
    }

    public T peekLast() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        } else {
            return queue.peekLast();
        }
    }

    public void addLast(T element) {
        queue.addLast(element);
    }

    public T removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        } else {
            return queue.poll();
        }
    }


    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }
}
