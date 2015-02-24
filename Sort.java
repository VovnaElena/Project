package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Sort implements Runnable {
    @Override
    public void run() {
        System.out.println("Открытие потока");
    }
    public void run(HashSet<String> set) throws IOException
    {
        System.out.println("Открытие потока");
        ArrayList<String> list = new ArrayList<String>(set);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        FileWriter fw = new FileWriter("juice2.out");
        for (int i = 0; i < list.size(); i++) {
            fw.write(list.get(i));
            fw.append("\n");
        }
        fw.close();
    }
}
