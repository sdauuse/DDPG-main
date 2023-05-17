package com.miao.algorithm.test;

import com.miao.algorithm.linear.LinkList;

public class LinkListTest2 {
    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<>();

        linkList.insert("姚明");
        linkList.insert("麦迪");
        linkList.insert("tom");
        linkList.insert("lky");
        linkList.insert("test", 3);

        for (String s1 : linkList) {
            System.out.println(s1);
        }
        linkList.reverse();

        for (String s1 : linkList) {
            System.out.println(s1);
        }
    }
}
