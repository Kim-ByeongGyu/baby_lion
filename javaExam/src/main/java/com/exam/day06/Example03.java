package com.exam.day06;

public class Example03 {
    public static void main(String[] args) {
        Thread timer1 = new Thread(new Timer("timer1",1, 10));
        Thread timer2 = new Thread(new Timer("timer2",0, 15));
        Thread timer3 = new Thread(new Timer("timer3",5, 8));

        timer1.start();
        timer2.start();
        timer3.start();
    }
}

class Timer implements Runnable {
    private int start;
    private int end;
    private String name;

    public Timer(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(name + " ::: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}