/*
    Code by Azat Valiev
    Kazan, KFU, ITIS
*/


import java.util.Arrays;
import java.util.LinkedList;

public class LinkedRadix {

    private LinkedList<Integer> list;
    private LinkedList<Integer> outList = new LinkedList<Integer>();

    public LinkedRadix(LinkedList<Integer> list) {
        this.list = list;
    }

    public int getMax() {
        int max = 0;
        for (Object a:
                list) {
            if ((int)a > max) {
                max = (int)a;
            }
        }
        return (int)max;
    }

    void countSort(LinkedList<Integer> list, int exp)
    {

        int[] output = new int [list.size()]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < list.size(); i++)
            count[ (list.get(i) /exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = list.size() - 1; i >= 0; i--)
        {
            output[count[ (list.get(i) /exp)%10 ] - 1] = list.get(i);
            count[ (list.get(i) /exp)%10 ]--;
        }



        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < list.size(); i++)
            list.set(i, output[i]);
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    LinkedList<Integer> radixSort(LinkedList<Integer> list)
    {
        // Find the maximum number to know number of digits
        int m = getMax();

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(list, exp);
        return list;
    }



}
