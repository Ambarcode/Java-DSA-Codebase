package com.ak.HashMapAndHeap;

public class HeapSort {

    private static void heapify(int[] arr, int size, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < size && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;
            heapify(arr, size, largest);
        }
    }

    private static void buildHeap(int[] arr) {
        int size = arr.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }
    }

    public static void heapSort(int[] arr) {
        int size = arr.length;

        buildHeap(arr);

        for (int i = size - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] elements = { 10, 7, 8, 5, 6, 1, 3 ,45,-1,7,66,543,0};
        int n = elements.length;

        System.out.println("Original array:");
        for (int element : elements) {
            System.out.print(element + " ");
        }

        heapSort(elements);

        System.out.println("\nSorted array using Heap Sort:");
        for (int element : elements) {
            System.out.print(element + " ");
        }
    }
}
