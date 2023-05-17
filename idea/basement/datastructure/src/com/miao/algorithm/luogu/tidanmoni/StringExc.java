package com.miao.algorithm.luogu.tidanmoni;

import java.util.Scanner;

public class StringExc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        int p3 = sc.nextInt();
        String s = sc.next();
        StringBuffer sb = new StringBuffer();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != '-') {
                sb.append(c);
            } else if ((isNumber(s.charAt(i-1)) && isLetter(s.charAt(i+1))) || (isLetter(s.charAt(i-1)) && isNumber(s.charAt(i+1))) ) {
                sb.append('-');
            } else {
                char start = s.charAt(i - 1);
                char end = s.charAt(i + 1);

                if (end <= start) {
                    sb.append(c);
                } else {
                    StringBuffer sb2 = new StringBuffer();
                    if (p1 == 1) {
                        for (char temp = (char) (start + 1); temp < end; temp = (char) (temp + 1)) {
                            String t = String.valueOf(temp);
                            t = t.toLowerCase();

                            for (int j = 0; j < p2; j++) {
                                sb2.append(t);
                            }
                        }
                    } else if (p1 == 2) {
                        for (char temp = (char) (start + 1); temp < end; temp = (char) (temp + 1)) {
                            String t = String.valueOf(temp);
                            t = t.toUpperCase();

                            for (int j = 0; j < p2; j++) {
                                sb2.append(t);
                            }
                        }
                    } else {
                        for (char temp = (char) (start + 1); temp < end; temp = (char) (temp + 1)) {

                            for (int j = 0; j < p2; j++) {
                                sb2.append("*");
                            }
                        }
                    }

                    if (p3 == 2) {
                        sb2.reverse();
                    }
                    sb.append(sb2);

                }

            }
        }

        System.out.println(sb);

    }

    public static boolean isNumber(char x) {
        if (x >= '1' && x <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLetter(char x) {
        if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }
}
