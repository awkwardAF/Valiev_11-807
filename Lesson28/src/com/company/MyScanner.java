package com.company;

/*  Code by Azat Valiev
    Kazan KFU, ITIS
*/

import java.io.IOException;
import java.io.InputStream;

public class MyScanner {
    private InputStream is;

    public MyScanner(InputStream is) {
        this.is = is;
    }

    public int nextInt() throws IOException {
        String s = "";
        int x;
        while ((x = is.read()) != -1) {
            if ((x > 47) && (x < 58)) {
                while ((x > 47) && (x < 58)) {
                    s += (char) x;
                    x = (char) is.read();
                }
                return Integer.parseInt(s);
            } else {
                x = is.read();
            }
        }
        return Integer.parseInt(null);
    }

    public double nextDouble() throws IOException { // fixme: govno doesnt work
        String s = "";
        int x;
        boolean hasComma = false;
        while ((x = is.read()) != -1) {
            if (x > 47 && x < 58) {
                while (((x > 47) && (x < 58)) || x == 46) {
                    if (x == 46 && !hasComma) {
                        hasComma = true;
                    }
                    s += (char) x;
                    x = (char) is.read();
                }
                return Double.parseDouble(s);
            }
            else {
                x = is.read();
            }
        }
        return Double.parseDouble(null);
    }

    public String next() throws IOException {
        String s = "";
        char x;
        while ((x = (char) is.read()) != ' ') {
            s += x;
        }
        return s;
    }

    public String nextLine() throws IOException {
        String s = "";
        char x;
        while ((x = (char) is.read()) != '\n') {
            s += x;
        }
        return s;
    }
}
