import java.util.Comparator;

interface OurComparable {
    public int compareTo(Object o);
}

class Dog implements Comparable<Dog>{ // better to use java inBuilt Comparable interface to save cast
    private String name;
    private int size;

    Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println(this.name + " Barks! Woof! Woof");
    }

    @Override
    public int compareTo(Dog o) {
        return this.size - o.size;
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }

    private static class NameComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }
}

public class maximizer {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Chelsea", 3), new Dog("Chester", 9), new Dog("Bruno", 15)};
        Dog maxDog = (Dog) max(dogs);
        maxDog.bark();
        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(dogs[1], dogs[2]) > 0) {
            dogs[1].bark();
        } 
        else {
            dogs[2].bark();
        }
    }

    public static Comparable max(Comparable[] items) { //We can also use Collections.max(items) as long as items has a collection of items which implement comparable interface
        int max = 0;
        for( int i = 0; i <  items.length; i++) {
            if (items[i].compareTo(items[max]) > 0) {
                max = i;
            }
        }
        return items[max];
    }
}