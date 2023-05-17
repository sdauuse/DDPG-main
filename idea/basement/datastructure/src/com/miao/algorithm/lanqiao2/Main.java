package com.miao.algorithm.lanqiao2;

import java.util.Scanner;
@SuppressWarnings("all")
/**
 * ph[k] 保存的是第k个插入的数的下标
 * hp[k] 保存的是堆中下标是k的点是第几个插入的
 */
public class Main {
    static int N = 100010, size, m;
    static int[] h = new int[N];
    static int[] hp = new int[N];//自身被映射数组
    static int[] ph = new int[N];//映射数组

    public static void swap(int[] a, int x, int y) {


        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void head_swap(int x, int y) {
        //这里因为映射数组跟被映射数组是互相指向对方,如果有两个数更换位置，映射下标也要进行更换
        //ph的下标指向是按顺序插入的下标，hp所对应的值是ph的按顺序的下标，用这两个属性进行交换
        swap(ph, hp[x], hp[y]);
        //因为按照顺序插入ph到指向交换了，对应指向ph的hp也要进行交换
        swap(hp, x, y);
        //最后两个值进行交换
        swap(h, x, y);
    }

    public static void down(int x) {
        int t = x;//x的分身
        //判断一下左下标是不是存在
        //判断一下左下标的值是不是比我t的值小 。那么就将左下标的值赋予t；否则不变
        if (x * 2 <= size && h[x * 2] < h[t]) {
            t = x * 2;
        }
        //判断一下右下标的值是不是比我t的值小。那么就将右下标的值赋予t，否则不变
        if (x * 2 + 1 <= size && h[x * 2 + 1] < h[t]) {
            t = x * 2 + 1;
        }
        if (t != x) {//如果x不等于他的分身
            head_swap(x, t);//那就进行交换顺序
            down(t);//然后一直向下进行操作
        }
    }

    public static void up(int x) {
        //向上操作，判断一下根节点还不是存在
        //看一下根节点是不是比我左分支或者右分支的值大，大的话就进行交换
        while (x / 2 > 0 && h[x / 2] > h[x]) {
            head_swap(x, x / 2);
            x = x / 2;//相当于一直up
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        size = 0;//size是原数组的下标
        m = 0;//m是映射数组的下标
        while (n-- > 0) {
            String s = scan.next();
            if (s.equals("I")) {//插入操作
                int x = scan.nextInt();
                size++;
                m++;//插入一个数两个数组的下标都加上1；
                ph[m] = size;
                hp[size] = m;//ph与hp数组是映射关系
                h[size] = x;//将数插入到堆中最后位置
                up(size);//然后up，往上面排序一遍
            } else if (s.equals("PM")) { //输出当前集合中的最小值
                System.out.println(h[1]);
            } else if (s.equals("DM")) {//删除当前集合中的最小值
                //因为需要用到映射数组与被映射数组,因为需要找到k的位置在哪里，需要让映射的顺序，
                //因为如果用size，size是会随时改变的，不是按顺序的，因为会被up或者down顺序会被修改
                head_swap(1, size);//将最后一个数替换掉第一个最小值元素，然后数量减1，size--
                size--;
                down(1);//插入之后进行向下操作，因为可能不符合小根堆
            } else if (s.equals("D")) {//删除当前集合中第k个插入得数
                int k = scan.nextInt();
                k = ph[k];//ph[k] 是一步一步插入映射的下标，不会乱序，
                head_swap(k, size);//然后将k与最后一个元素进行交换，然后长度减1，size--
                size--;
                up(k);//进行排序一遍，为了省代码量，up一遍down一遍。因为只会执行其中一个
                down(k);
            } else {
                int k = scan.nextInt();
                int x = scan.nextInt();
                k = ph[k];//ph[k] 是一步一步插入映射的下标，顺序是按照插入时候的顺序
                h[k] = x;//然后将第k为数修改为数x
                up(k);//up一遍，down一遍
                down(k);

            }
        }
    }
}
//这里填你的代码^^
//注意代码要放在两组三个点之间，才可以正确显示代码高亮哦~
