public class IntArrayList implements IntList {

    private int[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int count = 0;
    private static final double EXTENSION_COEF = 1.5;

    public IntArrayList () {
        elements = new int[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(int e) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == e) {
                return true;
            }
        }
            return false;
    }

    @Override
    public void add(int e) {
        if (capacity == count) {
            grow();
        }
        elements[count++] = e;
    }

    private void grow () {
        int newCapacity = (int) (capacity * EXTENSION_COEF);
        int[] newElements = new int[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newElements[i] = elements[i];
        }
        capacity = newCapacity;
        elements = newElements;
    }


    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("No such index");
        }
        return elements[index];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("No such index");
        }
        elements[index] = 0;
    }

    @Override
    public void sort() {
        int min;
        int min_i;
        for (int i = 0; i < count - 1; i++) {
            min = elements[i];
            min_i = i;
            for (int j = i + 1; j < count; j++) {
                if (elements[j] < min ) {
                    min = elements[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = elements[i];
                elements[i] = elements[min_i];
                elements[min_i] = tmp;
            }
        }
        System.out.println("Вот так теперь выглядит массив");
        for (int i = 0; i < capacity; i++) {
            System.out.print(elements[i] + " ");
        }
    }

    @Override
    public void addAll(IntList intList, int startPosition) throws IllegalAccessException {
        for (int i = 0; i < intList.size(); i++) {
            if (startPosition >= count ||capacity == count) {
                grow();
            }
            elements[startPosition] = intList.get(i);
            startPosition++;
        }
    }

    @Override
    public int[] toArray() {
        int [] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = elements[i];
        }
        return arr;
    }

    @Override
    public int indexOf(int value) {
        int index = -1; // если не существует индекса со значением value, то возвращаем -1;
        for (int i = 0; i < count; i++) {
            if (elements[i] == value) {
                index = i;
            }
        }
        return index;
    }

}
