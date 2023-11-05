package collections;

public class MyHashMap {
        private Node first;
        private Node last;
        private int size;

        public MyHashMap() {
            first = null;
            last = null;
            size = 0;
        }
        public void put(Object key, Object value) {
            Node newNode = new Node(key, value);

            if (first == null) {
                first = newNode;
            }
            else if(last == null){
                first.next = newNode;
                last = newNode;
            }
            else{
                last.next = newNode;
                last = newNode;
            }
            size++;
        }

        public void remove(Object key) {
            Node current = first;
            Node prev = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    if (prev != null) {
                        if(current.next == null) last = prev;
                        prev.next = current.next;
                    }
                    else {
                        first = current.next;
                    }
                    size--;
                    return;
                }
                prev = current;
                current = current.next;
            }
        }

        public Object get(Object key) {
            Node current = first;

            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }
            return null;
        }
        public void clear() {
            first = null;
            last = null;
            size = 0;
        }
        public int size() { return size; }
        public boolean isEmpty(){ return size > 0 ? false : true; }
        private class Node {
            Object key;
            Object value;
            Node next;

            public Node(Object key, Object value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }
}
