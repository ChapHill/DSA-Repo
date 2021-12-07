package priorityQueue;

import java.util.*;

public class PQ <T extends Comparable<T>> {

    private List<T> heap;

    public PQ() {
        heap = new ArrayList<>();
    }

    public PQ(int size) {
        heap = new ArrayList<>(size);
    }

    //return if PQ is empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    //clear heap of all elements/nodes
    public void clear() {
        heap.clear();
    }

    //return the value of the root node
    public T peek() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty Heap");
        }

        return heap.get(0);
    }

    //remove and return the value at the root node
    public T poll() {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty Heap");
        }

        return removeAt(0);
    }

    //check to see if heap contains given value
    public boolean contains(T element) {
        for(int i = 0; i < heap.size(); i++) {
            if(heap.get(i).equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void add(T element) {
        if(element == null) {
            throw new IllegalArgumentException("Cannot be null");
        }

        heap.add(element);

        int lastElementIndex = heap.size()-1;
        bubbleUp(lastElementIndex);
    }

    //test if value of node i <= node j
    public boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);

        return node1.compareTo(node2) <= 0;
    }

    public void bubbleUp(int k) {
        //index of next parent node to k
        int parentNode = (k-1) / 2;

        //keep bubblingUp until reaching root node and while less than parent node
        while(k > 0 && less(k, parentNode)) {
            swap(parentNode, k);
            k = parentNode;

            //get next parent node of k
            parentNode = (k-1) / 2;
        }
    }

    public void bubbleDown(int k) {
        int heapSize = heap.size();

        while(true) {
            int leftChild = 2 * k + 1;
            int rightChild = 2 * k + 2;
            int smallest = leftChild; //default smallest to left child node

            //determine which node is smaller
            if(rightChild < heapSize && less(rightChild, leftChild)) {
                smallest = rightChild;
            }

            //stop if out of bounds or if we can no longer bubbleDown
            if(leftChild >= heapSize || less(k, smallest)) {
                break;
            }

            swap(smallest, k);
            k = smallest;
        }
    }

    public void swap(int i, int j) {
        T elementI = heap.get(i);
        T elementJ = heap.get(j);
        heap.set(i, elementJ);
        heap.set(j, elementI);
    }

    public boolean remove(T element) {
        if(element == null) {
            return false;
        }

        for(int i = 0; i < heap.size(); i++) {
            if(element.equals(heap.get(i))) {
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    public T removeAt(int i) {
        if(isEmpty()) {
            throw new NoSuchElementException("Empty Heap");
        }

        int lastElementIndex = heap.size() -1;
        T data = heap.get(i);
        swap(i, lastElementIndex);

        heap.remove(lastElementIndex);

        //check if last element was removed
        if(i == lastElementIndex) {
            return data;
        }
        T element = heap.get(i);

        //try bubblingDown
        bubbleDown(i);

        //if bubblingDown didn't work, try bubbingUp
        if(heap.get(i).equals(element)) {
            bubbleUp(i);
        }

        return data;
    }



}
