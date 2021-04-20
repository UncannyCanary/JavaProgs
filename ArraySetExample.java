package JavaProgs;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ArraySet<T> implements Iterable<T>{
    private T[] arr;
    private int size;
    ArraySet() {
        this.arr = (T[]) new Object[100];
        this.size = 0; 
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == null) {
                if (element == null) {
                    return true;
                }
            }
            if (arr[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void add(T element) {
        if (contains(element)) {
            return;
        }
        arr[size] = element;
        size += 1;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPoz;
        public ArraySetIterator() {
            wizPoz = 0;
        }
        @Override
        public boolean hasNext() {
            return wizPoz < size;
        }

        @Override
        public T next() {
            T returnItem = arr[wizPoz];
            wizPoz++;
            return returnItem;
        }
    }
}


public class ArraySetExample {
    public static void main(String[] args) {
        ArraySet<String> a = new ArraySet<>();
        a.add("Vish");
        a.add("Joy");
        a.add("Vishal");
        a.add("Kandane");
        a.add("Euler");
        System.out.println(a.contains("Eler"));
        //System.out.println(a);

        Set<Integer> s = new HashSet<>();
        s.add(10);
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(40);
        s.add(50);
        Iterator<Integer> it = s.iterator(); // implement this in our ArraySet Class.
        while(it.hasNext()) {
            System.out.println(it.next()); //next returns the current value and advances
        }

        Iterator<String> aseer = a.iterator();
        while (aseer.hasNext()) {
            System.out.println(aseer.next());
        }

        for (String i: a) { // for this to work implement the Iterable interface and override the iterator() method
            System.out.println(i);
        }
    }
}
