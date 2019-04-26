package com.company.Task01;

public class MyMap implements Map<String, Integer> {



    @Override
    public void put(String key, Integer value) {
        for (int i = 0; i < count; i++) {
            if (entries[i].key.equals(key)) {
                entries[i].value = value;
                return;
            }
        }
        entries[count++] = new Entry(key, value);
    }

    @Override
    public Integer get(String key) {
        return null;
    }
}
