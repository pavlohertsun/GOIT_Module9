package collections;

import java.util.Arrays;

public class MyQueue<V> {
    private Object[] array;
    private int index;
    private int size;

    public MyQueue(int capacity) {
        array = new Object[capacity];
        index = 0;
        size = 0;
    }

    public void add(V value) {
        if (index == size) {
            increaseSize();
        }
        array[index++] = value;
        size++;
    }
    public void clear() {
        size = 0;
        array = Arrays.copyOf(array, size);
        index = 0;
    }
    public int size() {
        return size;
    }
    public Object peek() {
        if (isEmpty())
            throw new IllegalStateException("queue is empty");

        return array[0];
    }
    public Object poll() {
        if (isEmpty())
            throw new IllegalStateException("queue is empty");

        Object removedValue = array[0];
        for(int i = 0; i < size; ++i){
            array[i] = array[i + 1];
        }
        decreaseSize();
        index--;
        return removedValue;
    }
    public boolean isEmpty() { return size > 0 ? false : true; }
    private void increaseSize(){ array = Arrays.copyOf(array, ++size); }
    private void decreaseSize(){ array = Arrays.copyOf(array, --size); }

    @Override
    public String toString(){
        StringBuilder resultArray = new StringBuilder();
        for(Object value : array){
            resultArray.append(value).append(" ");
        }
        return resultArray.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyQueue<?> myQueue = (MyQueue<?>) o;
        return Arrays.equals(array, myQueue.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
