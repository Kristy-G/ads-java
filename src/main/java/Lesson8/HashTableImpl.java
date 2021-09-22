package Lesson8;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        Item nextItem;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.nextItem = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    private final Item<K, V>[] data;

    private final Item<K, V> emptyItem;

    private int size;

    public HashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity];
        emptyItem = new Item<>(null, null);
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {

        int index = hashFunc(key);
        if (data[index] == null) {
            data[index] = new Item<>(key, value);
        }
        else {
            data[index].nextItem = new Item(key, value);
        }
        size++;
        return true;
    }

    protected int getStep(K key) {
        return 1;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }

    private int indexOf(K key) {
        int index = hashFunc(key);

        int count = 0;
        while (count < data.length) {
            Item<K, V> item = data[index];
            if (item == null) {
                break;
            } else if (isKeysEquals(item, key)) {
                return index;
            }

            count++;
            index += getStep(key);
            index %= data.length;
        }

        return -1;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1) return null;
        Item item = data[index];
        while (item != null) {
            if (!item.getKey().equals(key)) {
                item = item.nextItem;
            }else break;

        }
        return (V)item.getValue();
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);

        if (index == -1) {
            return null;
        }
        Item<K, V> tempItem = data[index];

        if (tempItem.getKey().equals(key)) data[index] = data[index].nextItem;
        else {
            Item it = data[index].nextItem;
            while (it != null) {
                if (it.getKey().equals(key)) {
                    tempItem = it;
                } else it = it.nextItem;
            }
        }


        return tempItem.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("---------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
            if (data[i] != null){
                Item item = data[i].nextItem;
                while (item != null) {
                    System.out.printf("%d = [%s]%n", i, item);
                    item = item.nextItem;
                }
            }
        }
        System.out.println("---------------");
    }
}
