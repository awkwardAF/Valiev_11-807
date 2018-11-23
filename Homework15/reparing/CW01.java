import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class CW01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i+1]){
                a = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = a;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
