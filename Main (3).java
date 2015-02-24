package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Juice J = new Juice();
        J.readFile();
        J.delReplays();
        J.out1();
        J.out2();
        J.CountOfClear();
        J.out3();
    }
}
