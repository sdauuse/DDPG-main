package com.miao.exchangeprint;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-25
 * @Copyright：
 */
public class WaitNotifyTest2 {

    public static void main(String[] args) {
        WaitNotifyNum wn = new WaitNotifyNum(1);
        new Thread(() -> {
            wn.print(1, 2);
        }).start();
        new Thread(() -> {
            wn.print(2, 1);
        }).start();
    }
}

class WaitNotifyNum {
    private int number = 1;

    public void print(int curFlag, int nextFlag) {
        for (int i = 1; i <= 50; i++) {
            synchronized (this) {
                while (curFlag != flag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(number + " ");
                number += 1;
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    private int flag;

    public WaitNotifyNum(int flag) {
        this.flag = flag;
    }
}

