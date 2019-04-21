package com.company;

import java.util.Random;

public class MainApp {

    public static int sumThreads = 0;
    public static int sumArr = 0;

    public static void main(String[] args) throws InterruptedException {

        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }

        for (int i = 0; i < arr.length; i++) {
            sumArr += arr[i];
        }
        System.out.println("wo threads: " + sumArr);

        Thread t1 = new CounterThread(0,200000, arr);
        Thread t2 = new CounterThread(200000,400000, arr);
        Thread t3 = new CounterThread(400000,600000, arr);
        Thread t4 = new CounterThread(600000,800000, arr);
        Thread t5 = new CounterThread(800000,1000000, arr);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("w threads: " + sumThreads);

        if (sumThreads == sumArr) {
            System.out.println("sums are equal");
        }
    }
}
