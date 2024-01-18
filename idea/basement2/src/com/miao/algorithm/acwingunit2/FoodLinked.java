package com.miao.algorithm.acwingunit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-01-18
 * @Copyright：
 */
@SuppressWarnings("all")
public class FoodLinked {
    static int N = 50010;
    static int n, m; //n个动物,m句话
    static int[] p = new int[N];//p[]是父节点
    static int[] d = new int[N];//d[]表示到父节点的距离，在find之后，x的父节点变成祖宗节点，所以变成了到根节点的距离
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 0; i < n; i++) p[i] = i; //初始化并查集
        int res = 0;// 记录谎话的个数
        while (m-- > 0) {
            String[] strs = br.readLine().split(" ");
            int t = Integer.parseInt(strs[0]);
            int x = Integer.parseInt(strs[1]);
            int y = Integer.parseInt(strs[2]);
            if (x > n || y > n) res++; //X或Y比N大是假话
            else {
                int px = find(x), py = find(y); //先找到x,y的根节点px,py
                if (t == 1) //表示说x和y是同类
                {
                    if (px == py && (d[x] - d[y]) % 3 != 0) res++; //但寻找根节点发现不是同类，那么是谎话
                    else if (px != py)//如果还没在一个集合中，那就加到一个集合中，并更新d[]，由于是第一次说xy关系，所以是真话
                    {
                        p[px] = py;//px的根节点指向py
                        d[px] = d[y] - d[x]; //因为px和py之间也有一条边，所以得更新权值
                    }
                } else //吃的关系
                {
                    if (px == py && (d[x] - d[y] - 1) % 3 != 0) res++; //在一个集合里面，不满足x吃y的关系，那么为假话
                    else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] + 1 - d[x];
                    }
                }
            }
        }
        System.out.println(res);
    }

    static int find(int x) ///返回x的祖宗节点，也就是返回x的所在集合编号  + 路径压缩
    {
        if (p[x] != x) //如果x不是树根
        {
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }
}
