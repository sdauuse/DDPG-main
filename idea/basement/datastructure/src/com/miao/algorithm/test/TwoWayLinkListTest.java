package com.miao.algorithm.test;

import com.miao.algorithm.linear.LinkList;
import com.miao.algorithm.linear.TwoWayLinkList;

import java.util.LinkedList;

public class TwoWayLinkListTest {
    public static void main(String[] args) {
        TwoWayLinkList<String> twoWayLinkList = new TwoWayLinkList<>();

        twoWayLinkList.insert("姚明");
        twoWayLinkList.insert("麦迪");
        twoWayLinkList.insert("tom");
        twoWayLinkList.insert("lky");
        twoWayLinkList.insert(3, "test");


        System.out.println("第一个元素是：" + twoWayLinkList.getFirst());
        System.out.println("最后一一个元素是:" + twoWayLinkList.getLast());

        System.out.println(twoWayLinkList.length());

        String s = twoWayLinkList.get(1);
        System.out.println(s);


        String delete = twoWayLinkList.remove(1);
        System.out.println(delete);

        for (String s1 : twoWayLinkList) {
            System.out.println(s1);
        }

        twoWayLinkList.clear();
        System.out.println(twoWayLinkList.length());
    }
}
