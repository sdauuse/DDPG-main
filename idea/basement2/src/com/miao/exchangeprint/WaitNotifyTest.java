package com.miao.exchangeprint;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-03-25
 * @Copyright：
 */
public class WaitNotifyTest {


    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify(1, 5);
        new Thread(() -> {
            wn.print("a", 1, 2);
        }).start();
        new Thread(() -> {
            wn.print("b", 2, 3);
        }).start();
        new Thread(() -> {
            wn.print("c", 3, 1);
        }).start();
    }
}

class WaitNotify {

    public void print(String str, int waitFlag, int nextFlag) {
        for (int i = 0; i < loopNum; i++) {
            synchronized (this) {
                while (flag != waitFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }


    private int flag;
    private int loopNum = 5;

    public WaitNotify(int flag, int loopNum) {
        this.flag = flag;
        this.loopNum = loopNum;
    }
}
