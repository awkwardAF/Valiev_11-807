package com.company.Task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main01 { // не работает
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("words.txt"));
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (sc.hasNext()) {
            map.put(sc.next(), map.);
        }
    }
}
