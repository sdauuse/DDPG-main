package com.miao.algorithm.dayday1;

import java.util.Scanner;

public class FeiManDeKaiGuan {
    static final int N = 6;
    static final int INF = 100000;
    static char[][] g = new char[N][N];
    //备份数组
    static char[][] bg = new char[N][N];
    static int[] dx = new int[]{-1, 0, 1, 0, 0};
    static int[] dy = new int[]{0, 1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            //初始化
            int res = INF;
            for (int r = 0; r < 5; r++) {
                String s = sc.next();
                for (int j = 0; j < 5; j++) {
                    g[r][j] = s.charAt(j);
                }
            }

            //枚举第一行的32总开关方法，第一行的每一个元素有开或关两种做法，第一行一共5个元素，排列组合得2^5中开关方法

            for (int op = 0; op < 32; op++) {
                int count = 0;
                //备份数组
                for (int r = 0; r < 5; r++) {
                    for (int c = 0; c < 5; c++) {
                        bg[r][c] = g[r][c];
                    }
                }

                //按照第一行这一次设定的按法，进行操作
                for (int j = 0; j < 5; j++) {
                    if ((op >> j & 1) == 1) {
                        count++;
                        turn(0, j);
                    }
                }
                // 然后通过第一行按完之后的状态，按234行
                for (int r = 1; r < 4; r++) {
                    for (int c = 0; c < 5; c++) {
                        if (bg[r][c] == '0') {
                            count++;
                            //通过下一行对当前位置进行操作
                            turn(r + 1, c);
                        }
                    }
                }

                boolean flag = true;
                //如果最后一行全是亮着的，就说明该方案可行
                for (int c = 0; c < 5; c++) {
                    if (bg[4][c] == '0') {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    res = Math.min(res, count);
                }
            }

            if (res > 6) {
                res = -1;
            }
            System.out.println(res);
        }

    }


    public static void turn(int x, int y) {

        for (int i = 0; i < 5; i++) {
            int a = x + dx[i];
            int b = y + dy[i];

            if (a < 0 || a >= 5 || b < 0 || b >= 5) {
                continue;
            }

            bg[a][b] ^= 1;
        }
    }
}
