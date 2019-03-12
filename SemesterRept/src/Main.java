import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\numbers\\numbers\\set9179.txt");
        Scanner sc = new Scanner(file);
        LinkedList<Integer> list = new LinkedList<>(); // LinkedList to sort
        LinkedRadix lr = new LinkedRadix(list);
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        double start = System.nanoTime();
        list = lr.radixSort(list); // calling method that sorts the list
        double finish = System.nanoTime();
        System.out.println(list); // printing out the result
        double ml = (finish - start) / 1000000;
        System.out.println(ml + " миллисекунд");
    }
}
