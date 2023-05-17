package com.miao.algorithm.test;

import com.miao.algorithm.linear.LinkList;

import java.util.ArrayList;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<>();

        linkList.insert("姚明");
        linkList.insert("麦迪");
        linkList.insert("tom");
        linkList.insert("lky");
        linkList.insert("test", 3);


        System.out.println(linkList.length());

        String s = linkList.get(1);
        System.out.println(s);


        String delete = linkList.remove(1);
        System.out.println(delete);

        for (String s1 : linkList) {
            System.out.println(s1);
        }

        linkList.clear();
        System.out.println(linkList.length());
    }
}
