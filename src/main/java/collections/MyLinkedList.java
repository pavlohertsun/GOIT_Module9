package collections;

public class MyLinkedList<V> {
    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void add(V value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = null;
        }
        else if (last == null){
            newNode.prev = first;
            first.next = newNode;
            last = newNode;
        }
        else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index is out of range");

        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode.prev == null) {
            first = currentNode.next;
        }
        else {
            currentNode.prev.next = currentNode.next;
        }

        if (currentNode.next == null) {
            last = currentNode.prev;
        }
        else {
            currentNode.next.prev = currentNode.prev;
        }
        size--;
    }
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
    public int size(){ return size;}
    public Object get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index is out of range");

        Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }
    public boolean isEmpty(){ return size > 0 ? false : true; }

    public boolean contains(Object value){
        Node currentNode = first;
        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;
            if(currentNode.value == value) return true;
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder resultArray = new StringBuilder();
        Node currentNode = first;
        for (int i = 0; i < size; i++) {
            resultArray.append(currentNode.value).append(" ");
            currentNode = currentNode.next;
        }
        return resultArray.toString().trim();
    }
    private class Node<V>{
        private Node prev;
        private V value;
        private Node next;

        public Node(V value){
            prev = null;
            next = null;
            this.value = value;
        }
    }
}
