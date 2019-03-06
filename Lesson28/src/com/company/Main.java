package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("text.txt");
	    MyScanner scan = new MyScanner(is);
        System.out.println(scan.next());
        System.out.println(scan.nextDouble());
        System.out.println(scan.nextLine());
    }
}
