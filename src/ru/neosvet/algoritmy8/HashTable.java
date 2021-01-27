package ru.neosvet.algoritmy8;

public class HashTable {
    public enum Mode {
        SAMPLE, DOUBLE_HASH
    }

    private final int IN_LINE = 10;
    private Item[] table;
    private int size;
    private Item none;
    private Mode mode;

    public HashTable(int size, Mode mode) {
        this.size = size;
        this.mode = mode;
        table = new Item[size];
        none = new Item(-1);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            if (table[i] != null)
                System.out.print(table[i].getKey());
            else
                System.out.print("***");
            if ((i + 1) % IN_LINE == 0)
                System.out.println();
            else
                System.out.print("\t");
        }
    }

    public int getHash(int key) {
        return key % size;
    }

    public int getStep(int key) {
        return 5 - key % 5;
    }

    public void insert(int key) {
        int hash = getHash(key);
        int step = getStep(key);
        while (table[hash] != null && table[hash].getKey() != -1) {
            if (mode == Mode.SAMPLE)
                hash++;
            else
                hash += step;
            hash %= size;
        }

        table[hash] = new Item(key);
    }

    public boolean delete(int key) {
        int hash = getHash(key);
        int step = getStep(key);
        while (table[hash] != null) {
            if (table[hash].getKey() == key) {
                table[hash] = none;
                return true;
            }
            if (mode == Mode.SAMPLE)
                hash++;
            else
                hash += step;
            hash %= size;
        }
        return false;
    }
}
