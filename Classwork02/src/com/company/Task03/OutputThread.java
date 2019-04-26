package com.company.Task03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputThread extends Thread {

    Char myChar;
    File out;
    FileOutputStream fileOutputStream;

    public OutputThread(Char c, File out) throws FileNotFoundException {
        this.myChar = c;
        this.out = out;
        fileOutputStream = new FileOutputStream(out);
    }

    @Override
    public void run() {
        try {
            while (Task3.running) {
                synchronized (myChar) {
                    while (!myChar.isRead) {
                        myChar.wait();
                        if (!Task3.running)
                            return;
                    }
                    fileOutputStream.write(myChar.c);
                    myChar.isRead = false;
                    myChar.notify();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
