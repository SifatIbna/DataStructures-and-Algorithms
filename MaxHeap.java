package Q1;

import java.util.Arrays;

public class MaxHeap {
    public int[] A;

    public MaxHeap(int[] a) {
        // TODO Auto-generated constructor stub
        A = a;
    }

    static void Exchange(int[] A, int x, int y) // Does a Swap
    {
        int temp = A[x - 1]; // Place A[x-1] into temp
        A[x - 1] = A[y - 1]; // Place A[y-1] into A[x-1]
        A[y - 1] = temp; // Place temp into A[y-1]
    }

    public void HeapSort(int[] A) { // Heap sort Method
        BuildMaxHeap(A); // First Step is to Build a Heap
        int heapSize = A.length;
        for (int i = A.length; i >= 2; i--) { // Once build heap is done, start
            // from last element down to 2
            Exchange(A, 1, i); // Swap last element with root
            heapSize--; // Decrease the size of heap by 1
            MaxHeapify(A, 1, heapSize); // Again do a heapify by call root
        }
    }

    public void BuildMaxHeap(int[] A) { // Build Heap Method
        for (int i = A.length / 2; i >= 1; i--) { // Start with the first
            // Internal node and move
            // down to the root
            MaxHeapify(A, i, A.length); // Max Heapify it
        }
    }

    public void MaxHeapify(int[] A, int i, int heapSize) { // Max Heapify
        // Method
        int l = 2 * i; // Get the index of element to its left
        int r = (2 * i) + 1; // Get the index of element to its right
        int largest;
        if (l <= heapSize && A[l - 1] > A[i - 1]) { // Check if the element at
            // left is greater than its
            // parent
            largest = l; // assign largest to left index
        } else {
            largest = i; // otherwise assign largest to parent index
        }
        if (r <= heapSize && A[r - 1] > A[largest - 1]) { // Check if the
            // element at right
            // is greater than
            // its parent
            largest = r; // assign largest to right index
        }
        if (largest != i) // If largest is not equal to parent
        {
            Exchange(A, i, largest); // Exchange largest with the parent
            MaxHeapify(A, largest, heapSize); // Do a Max heapify by passing the
            // largest element
        }
    }

    public static void main(String[] args) {
        int[] random = new int[] { 2, 9, -11, 8, 5, 9001, 3 };
        MaxHeap m = new MaxHeap(random);
        m.HeapSort(random); // Call to the function HeapSort
        System.out.println("Expect random to be: -11, 2, 3, 5, 8, 9, 9001: " + Arrays.toString(random));
        int[] LowtoHight = new int[] { 2, 9, -11, 8, 5, 9001, 3 };
        MaxHeap m1 = new MaxHeap(random);
        m1.HeapSort(LowtoHight); // Call to the function HeapSort
        System.out.println("Expect LowtoHight to be: -11, 2, 3, 5, 8, 9, 9001: " + Arrays.toString(LowtoHight));
        int[] HighttoLow = new int[] { 9001, 9, 8, 5, 3, 2, -11 };
        MaxHeap m2 = new MaxHeap(random);
        m2.HeapSort(HighttoLow); // Call to the function HeapSort
        System.out.println("Expect HighttoLow to be: -11, 2, 3, 5, 8, 9, 9001: " + Arrays.toString(HighttoLow));
    }
}
