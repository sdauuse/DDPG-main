package com.miao.algorithm.luogu.tidanmeiju;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int start = sc.nextInt();
        int end = sc.nextInt();
        boolean flag;
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                continue;
            }
            flag = true;
            if (isHWS(i)) {
                for (int j = 2; j <= i / j; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    bw.write(i + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean isHWS(int num) {

        int temp = num, ans = 0;
        while (temp != 0) {
            ans = ans * 10 + temp % 10;
            temp /= 10;
        }
        return ans == num;
    }
}
