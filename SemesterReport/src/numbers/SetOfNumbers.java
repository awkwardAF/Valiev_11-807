package numbers;

/* 
    Code by Azat Valiev
    Kazan, KFU, ITIS
*/


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class SetOfNumbers {

    private File file;
    private int count = 1;
    private FileWriter fw;

    public void newSet () throws IOException {
        Random amount = new Random();
        int n = amount.nextInt(9900) + 100;
        file = new File("src\\numbers\\numbers\\set" + n + ".txt");
        // n - количество элементов в документе
        count++;
        fw = new FileWriter(file, true);
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            fw.write(rd.nextInt(10000) + " ");
        }
        fw.flush();
        fw.close();
    }

    public int [] newSetArray(int i) {
        Random rd = new Random();
        int[] arr = new int[i];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = rd.nextInt(10000);
        }
        return arr;
    }

    public LinkedList<Integer> newSetList(int i) {
        LinkedList list = new LinkedList();
        Random rd = new Random();
        for (int j = 0; j < i; j++) {
            list.add(rd.nextInt(10000));
        }
        return list;
    }


}
