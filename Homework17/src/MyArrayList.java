import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private T[] elements;
    private int count = 0;
    private int capacity = 10;
    private static final double EXTENSION_COEF = 1.5;

    public void grow() {
        int newCapacity = (int) (count * EXTENSION_COEF);
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < count; i++) {
            newElements[i] = elements[i];
        }
        capacity = newCapacity;
        elements = newElements;
    }

    public MyArrayList() {
        this.elements = (T[]) new Object[capacity];
    }

    public void add(T e) {
        elements[count++] = e;
    }

    public T get(int index) {
        return elements[index];
    }

    //число элементов в списке
    int size() {
        return count;
    }

    //есть ли в списке такой элемент
    boolean contains(T value) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == value) {
                return true;
            }
        }
        return false;
    }

    //удаление элемента по индекс (со смещением элементов влево)
    void remove(int index) {
        for (int i = index; i < count - index; i++) {
            elements[i] = elements[i+1];
            }
        count--;
        System.out.println("This is how your array looks like now");
        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println(" ");
    }

    //возвращает все элементы из списка в виде массива
    public T[] toArray() {
        T[] arr = (T[]) new Object[count];
        for (int i = 0; i < count; i++) {
            arr[i] = elements[i];
        }
        return arr;
    }

    //добавление всех элементов из списка list в данный список(в конец)
    void addAll(MyArrayList<T> list) {
        T[] newList = list.toArray();
        for (int i = 0; i < newList.length; i++) {
            if (capacity==count) {
                grow();
            }
            elements[count+i]=newList[i];
        }
    }

    //добавление всех элементов из списка list в данный список
    //начиная с позиции index
    void addAll(MyArrayList<T> list, int index) {
        T[] newList = list.toArray();
        for (int i = 0; i < newList.length; i++) {
            if (capacity==count){
                grow();
            }
            elements[index+i] = newList[i];
        }
    }

    public Iterator<T> iterator() {
        return new MyIter();
    }

    public class MyIter implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }

        @Override
        public T next() {
            return elements[currentIndex++];
        }
    }
}