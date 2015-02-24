package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Juice {
    private ArrayList<String> juices;
    private ArrayList<String> strings;
    private HashSet hs;
    private int count;

    public Juice(){
        juices = new ArrayList<String>();
        strings = new ArrayList<String>();
        count = 0;
    }

    public void readFile() throws IOException {
        FileReader fr = new FileReader("juice.in");
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            strings.add(s);
            StringTokenizer st = new StringTokenizer(s);
            while(st.hasMoreTokens()) {
                juices.add(st.nextToken());
            }
        }
    }

    public void delReplays(){
        hs = new HashSet(juices);
        juices.clear();
        Iterator<String> i = hs.iterator();
        while(i.hasNext()){
            juices.add(i.next());
        }
    }

    public void out1() throws IOException {
        FileWriter fw = new FileWriter ("juice1.out");
        for(Iterator i = juices.iterator(); i.hasNext();){
            fw.write((String)i.next() + "\n");
        }
        fw.close();
    }


    public void out2() throws IOException{
        HashSet<String> hs = new HashSet<String>();
        for(Iterator i = juices.iterator(); i.hasNext();) {
            hs.add((String)i.next());
        }
        Sort obj = new Sort();
        obj.run(hs);
    }

    public void CountOfClear() throws IOException {
        String s;
        int index = 0;
        int t = 0;
        for (int i = 0; i < strings.size(); i++) {
            s = strings.get(i);
            for (int j = i + 1; j < strings.size(); j++) {
                if(strings.get(j).contains(s)) {
                    count++;
                    index = strings.indexOf(s);
                    s = strings.get(j);
                    strings.remove(index);
                }

            }
        }
    }

    public void out3() throws IOException {
        FileWriter fw = new FileWriter ("juice3.out");
        fw.write("min count = " + (strings.size() - count));
        fw.close();
    }

}
