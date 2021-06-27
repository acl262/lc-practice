import java.util.ArrayList;

public class BinaryHeap<E extends Comparable<E>>  {

    private ArrayList<E> data;

    public BinaryHeap(int capacity) {
        data = new ArrayList<>();
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

    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void siftUp(int k) {
        while( k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    private void swap(int i, int j) {
        if(i < 0 || i >= data.size() || j < 0 || j >= data.size()) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E t = data.get(i);
        data.set(i, data.get(j);
        data.set(j, t);
    }

}
