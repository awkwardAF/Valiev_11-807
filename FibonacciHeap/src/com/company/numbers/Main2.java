package com.company.numbers;


import com.company.numbers.SetOfNumbers;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {
        SetOfNumbers son = new SetOfNumbers();
        for (int i = 0; i < 50; i++) {
            son.newSet();
        }
//        son.test();
    }
}
