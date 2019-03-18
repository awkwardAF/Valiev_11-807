import numbers.SetOfNumbers;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SetOfNumbers son = new SetOfNumbers();
        LinkedRadix lr = new LinkedRadix();
        Radix radix = new Radix();
        Random rd = new Random();
        /* Для зависимости времени от входных данных
        for (int i = 1; i < 101; i++) {
            int[] arr = son.newSetArray(i*100); //LinkedList/Array to sort
            long start = System.nanoTime();
            radix.radixSort(arr, arr.length); // calling method that sorts the list/array
            long finish = System.nanoTime();
            long ml = (finish - start);
            System.out.print(ml  + "\n");
            System.out.print(arr.length + "\n");
        }
        */
        for (int i = 1; i < 101; i++) {
            LinkedList list = son.newSetList(i*100); // LinkedList/Array to sort
            lr.radixSort(list);
            System.out.print(lr.getIterations() + "\n");
//            System.out.println(arr.length + "\n");
        }
    }
}
