package com.company;

import com.company.numbers.SetOfNumbers;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        FibonacciHeap myHeap = new FibonacciHeap();
        SetOfNumbers son = new SetOfNumbers();
        Random rd = new Random();
        for (int i = 1; i < 101; i++) {
            int[] arr = son.newSetArray(i * 100);// Array to make a heap from
            int toDelete = arr[i];
            myHeap.arrayToHeap(arr);
            HeapNode nodeToDelete = new HeapNode(10000);
            myHeap.insert(10000);
            long start = System.nanoTime();
            myHeap.delete(nodeToDelete);
            long finish = System.nanoTime();
            long ml = (finish - start);
            System.out.print(ml + "\n");
            // System.out.print(arr.length + "\n");
        }

    }
}
