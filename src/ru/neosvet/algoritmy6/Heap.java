package ru.neosvet.algoritmy6;

public class Heap {
    private int heapSize;
    private int[] arr;

    public Heap(int[] arr) {
        heapSize = arr.length;
        this.arr = arr;
        buildHeap();
    }

    private void buildHeap() {
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < heapSize && arr[i] < arr[l])
            largest = l;
        if (r < heapSize && arr[largest] < arr[r])
            largest = r;

        if (i != largest) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    public void sort() {
        heapSize = arr.length;
        while (heapSize > 1) {
            swap(0, heapSize - 1);
            heapSize--;
            heapify(0);
        }
    }

    public int[] getArray() {
        return arr;
    }
}
