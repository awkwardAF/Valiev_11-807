// Radix sort Java implementation

import java.io.*;
import java.util.*;

class Radix {

    private static int iterations;

    public static int getIterations() {
        return iterations;
    }

    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int exp) {
        int output[] = new int[arr.length]; // output array
        int i;
        int count[] = new int[10];

        // Store count of occurrences in count[]
        for (i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
            iterations++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
            iterations++;
        }

        // Build the output array
        for (i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            iterations++;
        }

    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

}