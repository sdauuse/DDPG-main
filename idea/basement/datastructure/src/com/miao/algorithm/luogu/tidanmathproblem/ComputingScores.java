package com.miao.algorithm.luogu.tidanmathproblem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ComputingScores {

    static Stack<Integer> numerator = new Stack<>();
    static Stack<Integer> denominator = new Stack<>();
    static Stack<Character> ops = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        for (int i = 0; i < s.length(); i++) {

            if (i == 0 && s.charAt(i) == '-') {
                i++;
                int a = Integer.parseInt(String.valueOf(s.charAt(i)));
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    a = a * 10 + Integer.parseInt(String.valueOf(s.charAt(i + 1)));
                    i++;
                }
                numerator.push(-a);
                i = i + 2;
                int b = Integer.parseInt(String.valueOf(s.charAt(i)));
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    b = b * 10 + Integer.parseInt(String.valueOf(s.charAt(i + 1)));
                    i++;
                }
                denominator.push(b);
                continue;
            }

            if (s.charAt(i) == '/') {
                i++;
                int a = Integer.parseInt(String.valueOf(s.charAt(i)));
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    a = a * 10 + Integer.parseInt(String.valueOf(s.charAt(i + 1)));
                    i++;
                }
                denominator.push(a);
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (ops.size() >= 1) {
                    Character pop = ops.pop();
                    if (pop == '+') {
                        add();
                    } else {
                        sub();
                    }
                }
                ops.push(s.charAt(i));
            } else {
                int a = Integer.parseInt(String.valueOf(s.charAt(i)));
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    a = a * 10 + Integer.parseInt(String.valueOf(s.charAt(i + 1)));
                    i++;
                }
                numerator.push(a);
            }
        }

        while (!ops.isEmpty()) {
            Character pop = ops.pop();
            if (pop == '+') {
                add();
            } else {
                sub();
            }
        }
        int zi = numerator.pop();
        int mu = denominator.pop();

        //计算结果有可能是50/60，故要考虑这种可以约分的情况
        int g = gcd(zi, mu);
        zi = zi / g;
        mu = mu / g;
        if (mu == 1) {
            System.out.println(zi);
        } else if (mu < 0) {
            System.out.println("-" + zi + "/" + -mu);
        } else {
            System.out.println(zi + "/" + mu);
        }
    }

    public static void add() {
        int da = denominator.pop();
        int db = denominator.pop();
        int l = lcm(da, db);
        int na = l / da * numerator.pop();
        int nb = l / db * numerator.pop();
        int add = na + nb;
        int g = gcd(add, l);
        numerator.push(add / g);
        denominator.push(l / g);
    }

    public static void sub() {
        int da = denominator.pop();
        int db = denominator.pop();
        int l = lcm(da, db);
        int na = l / da * numerator.pop();
        int nb = l / db * numerator.pop();
        int sub = nb - na;
        int g = gcd(sub, l);
        numerator.push(sub / g);
        denominator.push(l / g);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int lcm(int a, int b) {
        int sum = a * b;
        return sum / gcd(a, b);
    }
}
