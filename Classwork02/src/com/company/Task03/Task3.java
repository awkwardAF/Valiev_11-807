package com.company.Task03;

import java.io.File;
import java.io.FileNotFoundException;

public class Task3 {

    public static boolean running;

    public static void main(String[] args) throws FileNotFoundException {
        running = true;
        Char container = new Char(' ', false);

        InputThread input = new InputThread(container, new File("text1.txt"));
        OutputThread output = new OutputThread(container, new File("text2.txt"));

        input.start();
        output.start();

    }

}