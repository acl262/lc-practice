import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinaryHeap<E extends Comparable<E>>  {

    private ArrayList<E> data;

    public BinaryHeap(int capacity) {
        data = new ArrayList<>();
    }

    public BinaryHeap(E[] arr) {
        data = new ArrayList<>();
        Collections.addAll(data, arr);
        for(int i = parent(arr.length -1) ; i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if(index == 0 ) {
         throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void offer(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void siftUp(int k) {

        while( k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    public E peek() {
        if(data.size() == 0) {
            throw new IllegalArgumentException("cannot find max as heap is empty");
        }
        return data.get(0);
    }

    public E poll() {
        E res = peek();
        swap(0, data.size() - 1);
        data.remove(data.size() -1);
        siftDown(0);
        return res;
    }

    public E replace(E e) {
        E res = peek();
        data.set(0, e);
        siftDown(0);
        return res;
    }

    private void siftDown(int k) {
        while(leftChild(k) < data.size()) {
            int j = leftChild(k);
            if(j + 1 < data.size() &&
                data.get(j+1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if(data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        if(i < 0 || i >= data.size() || j < 0 || j >= data.size()) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E t = data.get(i);
        data.set(i, data.get(j));
        data.set(j, t);
    }
}
