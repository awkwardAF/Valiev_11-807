import numbers.SetOfNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File("src\\numbers\\numbers\\set5.txt");
//        Scanner sc = new Scanner(file);
        SetOfNumbers son = new SetOfNumbers();
        LinkedList<Integer> list = new LinkedList<>(); // LinkedList to sort
        LinkedRadix lr = new LinkedRadix(list);
//        while (sc.hasNextInt()) {
//            list.add(sc.nextInt());
//        }
        Radix radix = new Radix();
        Random rd = new Random();
        for (int i = 0; i < 50; i++) {
            int[] arr = son.newSetArray();
            long start = System.nanoTime();
            radix.radixSort(arr, arr.length); // calling method that sorts the list/array
            long finish = System.nanoTime();
            System.out.println(list); // printing out the result
            long ml = (finish - start);
            System.out.print(ml + " ");
            System.out.print(arr.length + "");
        }
    }
}
