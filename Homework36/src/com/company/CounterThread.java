package com.company;

public class CounterThread extends Thread {

    private int start;
    private int end;
    private int[] arrToCountSum;

    public CounterThread (int start, int end, int[] arrToCountSum) {
        this.start = start;
        this.end = end;
        this.arrToCountSum = arrToCountSum;
    }

    private static final Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized (MUTEX) {
            for (int i = start; i < end; i++) {
                MainApp.sumThreads += arrToCountSum[i];
            }
        }
    }


}
