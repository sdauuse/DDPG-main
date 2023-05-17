package com.miao.algorithm.test;

import com.miao.algorithm.linear.SequenceList;

import java.util.ArrayList;

public class SequenceListTest  {
    public static void main(String[] args) {
        SequenceList<String> sequenceList = new SequenceList(10);

        sequenceList.insert("姚明");
        sequenceList.insert("麦迪");
        sequenceList.insert("tom");
        sequenceList.insert("lky");


        ArrayList arrayList = new ArrayList();

        String s = sequenceList.get(1);
        System.out.println(s);


        String delete = sequenceList.delete(1);
        System.out.println(delete);

        for (String s1 : sequenceList) {
            System.out.println(s1);
        }

        sequenceList.clear();
        System.out.println(sequenceList.length());


    }
}
