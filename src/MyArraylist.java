import java.util.Iterator;

public class MyArraylist<T> implements Iterable<T> {

    private T[] array;
    private int lenght = 0;
    private int capacity = 0;

    public MyArraylist() {
        this(16);
    }

    public MyArraylist(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity" + capacity);
        this.capacity = capacity;
        array = (T[]) new Object[capacity];

    }

    public int size() {
        return lenght;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T elem) {
        array[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            array[i] = null;
        }
        lenght = 0;
    }

    public void add(T elem) {
        if (lenght + 1 > capacity) {
            if (capacity == 0) capacity = 1;
            else capacity = 2 * capacity;
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < lenght; i++) {
                newArray[i] = array[i];

            }
            array = newArray;


        }
        array[lenght++] = elem;


    }

    public T removeAt(int index) {
        if (index > lenght || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T data = array[index];
        T[] newArray = (T[]) new Object[lenght - 1];
        for (int i = 0, j = 0; i < lenght; i++, j++) {
            if (i == index) {
                j--;
            } else newArray[j] = array[i];

        }
        array = newArray;
        capacity = --lenght;
        return data;

    }

    public boolean remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {

                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) == -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < lenght;
            }

            public T next() {
                return array[index++];
            }
        };
    }


    @Override
    public String toString() {
        if (lenght == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(lenght).append("[");
            for (int i = 0; i < lenght - 1; i++) {
                sb.append(array[i] + ", ");
            }
            return sb.append(array[lenght - 1] + "]").toString();
        }

    }

    public static void main(String[] args) {
        MyArraylist<Integer> myArraylist = new MyArraylist<>();
        myArraylist.add(1454);
        myArraylist.add(45);
        myArraylist.add(154);
        myArraylist.add(4);
        System.out.println(myArraylist);
        myArraylist.removeAt(2);
        System.out.println(myArraylist);
        myArraylist.remove(1454);
        System.out.println(myArraylist);
        System.out.println(myArraylist.lenght);
    }
}
