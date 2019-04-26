package com.company.Task03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputThread extends Thread {

    Char myChar;
    File in;
    FileInputStream fileInputStream;

    public InputThread(Char c, File in) throws FileNotFoundException {
        this.myChar = c;
        this.in = in;
        fileInputStream = new FileInputStream(in);
    }

    @Override
    public void run() {
        try {
            while (Task3.running) {
                synchronized (myChar) {
                    while (myChar.isRead) {
                        myChar.wait();
                    }
                    int x;
                    x = fileInputStream.read();
                    myChar.isRead = true;

                    if (x != -1) myChar.c = (char) x;
                    else Task3.running = false;

                    myChar.notify();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
