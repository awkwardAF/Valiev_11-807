import java.util.Arrays;

public class SimpleMap<K, V> implements Map<K, V> {
    private static int size = 10;
    private Entry[] entries;
    private int count;
    private final double COEF = 1.5;

    public SimpleMap() {
        this.entries = new Entry[size];
        this.count = 0;
    }

    @Override
    public void put(K key, V value) {
        if (count >= size) {
            entries = Arrays.copyOf(entries, (int) (size*COEF));
            size = (int) (size*COEF);
        }
        for (int i = 0; i < count; i++) {
            if (entries[i].key.equals(key)) {
                entries[i].value = value;
                return;
            }
        }
        entries[count++] = new Entry<>(key, value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (entries[i].key.equals(key)) {
                return (V) entries[i].value;
            }
        }

        return null;
    }

    @Override
    public void out() {
        for (int i = 0; i < count; i++) {
            System.out.println(get((K) entries[i].key));
        }
    }


    class Entry<I, E> {
        I key;
        E value;

        public Entry(I key, E value) {
            this.key = key;
            this.value = value;
        }
    }
}