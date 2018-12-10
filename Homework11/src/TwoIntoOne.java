import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoIntoOne {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        Scanner sc1 = new Scanner(new File("in1.txt"));
        Scanner sc2 = new Scanner(new File("in2.txt"));
        int a = sc1.nextInt();
        int b = sc2.nextInt();
        while (sc1.hasNextInt() && sc2.hasNextInt()) {
            if (a < b) {
                pw.println(a);
                a = sc1.nextInt();
            } else {
                pw.println(b);
                b = sc2.nextInt();
            }
        }
        if (!sc1.hasNextInt()) {
            while (sc2.hasNextInt()) {
                if (a < b) {
                    pw.println(a);
                    a = Integer.MAX_VALUE;
                } else {
                    pw.println(b);
                    b = sc2.nextInt();
                }
            }
            if (a!=Integer.MAX_VALUE) {
                pw.println(a+b-Math.max(a,b));
                pw.println(Math.max(a,b));
            } else {
                pw.println(b);
            }
        } else {
            while (sc1.hasNextInt()) {
                if (b < a) {
                    pw.println(b);
                    b = Integer.MAX_VALUE;
                } else {
                    pw.println(a);
                    a = sc1.nextInt();
                }
            }
            if (b!=Integer.MAX_VALUE) {
                pw.println(a+b-Math.max(a,b));
                pw.println(Math.max(a,b));
            } else {
                pw.println(a);
            }
        }
        pw.close();
    }
}
