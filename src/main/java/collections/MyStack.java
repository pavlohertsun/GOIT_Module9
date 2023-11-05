package collections;

import java.util.Arrays;

public class MyStack <V>{
    private Object[] array;
    private int size;
    private int index;

    public MyStack(int size){
        array = new Object[size];
        this.size = size;
        index = 0;
    }
    public void push(V value){
        if (index == size) {
            increaseSize();
        }
        array[index++] = value;
    }
    public void remove(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index out of range");

        for(int i = index; i < size - 1; ++i){
            array[i] = array[i + 1];
        }

        decreaseSize();
        this.index--;
    }
    public void clear() {
        size = 0;
        array = Arrays.copyOf(array, size);
        index = 0;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty(){ return size > 0 ? false : true; }
    public Object peek() {
        if (isEmpty())
            throw new IllegalStateException("stack is empty");

        return array[index];
    }
    public Object pop() {
        if (isEmpty())
            throw new IllegalStateException("stack is empty");

        Object removedValue = array[index];
        decreaseSize();
        index--;
        return removedValue;
    }
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
        MyStack<?> myStack = (MyStack<?>) o;
        return Arrays.equals(array, myStack.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
