import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private T[] elements;
    private int count = 0;

    public MyArrayList() {
        this.elements = (T[]) new Object[10];
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
    T[] toArray() {
        T[] arr = (T[]) new Object[count];
        for (int i = 0; i < count; i++) {
            arr[i] = elements[i];
        }
        return arr;
    }

    //добавление всех элементов из списка list в данный список(в конец)
    void addAll(MyArrayList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list[i]);
        }
    }

    //добавление всех элементов из списка list в данный список
    //начиная с позиции index
    void addAll(MyArrayList<T> list, int index) {
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