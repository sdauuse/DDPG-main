package com.miao.lambda;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;
import java.util.function.IntBinaryOperator;

public class LambdaDemo01 {
    //当匿名内部类是接口，并且只有一个抽象方法需要重写的时候
    public static void main(String[] args) {

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程中的run方法被执行");
            }
        }).start();*/

        new Thread(() -> {
            System.out.println("新线程中的run方法被执行");
        }).start();

        System.out.println("main线程在被执行");

    }


    @Test
    public void testCalculate() {
        int i = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });

        int i1 = calculateNum((int left, int right) -> left + right);

        System.out.println(i);
        System.out.println(i1);
    }

    public static int calculateNum(IntBinaryOperator operator) {

        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }


}
