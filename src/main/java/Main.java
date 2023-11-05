import collections.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<>(1);
        for (int i = 1; i <= 5; ++i){
            array.add(i);
        }
        for (int i = 0; i <= 2; ++i){
            array.remove(i);
        }
        for (int i = 1; i <= 5; ++i){
            array.add(i);
        }
        array.clear();
        MyHashMap map = new MyHashMap();
        map.put(1,"Lox");
        map.put(2,"Lox");
        map.put(3,"Lox");
        map.remove(2);
        map.remove(3);
        map.remove(1);
        map.put(1,"Lox");
        map.put(2,"Lox");
        map.put(3,"Lox");
        map.remove(4);
        map.clear();
    }
}
