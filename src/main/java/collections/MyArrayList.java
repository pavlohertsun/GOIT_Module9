package collections;

import java.util.Arrays;

public class MyArrayList<V> {
    private Object[] arrayList;
    private int size;
    private int index;

    public MyArrayList(int size){
        arrayList = new Object[size];
        this.size = size;
        index = 0;
    }
    public void add(V value){
        if (index == size) {
            increaseSize();
        }
        arrayList[index++] = value;
    }
    public void remove(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index out of range");

        for(int i = index; i < size - 1; ++i){
            arrayList[i] = arrayList[i + 1];
        }

        decreaseSize();
        this.index--;
    }
    public void clear() {
        size = 0;
        arrayList = Arrays.copyOf(arrayList, size);
        index = 0;
    }
    public Object get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index out of range");

        return arrayList[index];
    }
    public int size() {
        return size;
    }
    public boolean isEmpty(){ return size > 0 ? false : true; }
    private void increaseSize(){ arrayList = Arrays.copyOf(arrayList, ++size); }
    private void decreaseSize(){ arrayList = Arrays.copyOf(arrayList, --size); }

    @Override
    public String toString(){
        StringBuilder array = new StringBuilder();
        for(Object value : arrayList){
            array.append(value).append(" ");
        }
        return array.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return Arrays.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayList);
    }
}
