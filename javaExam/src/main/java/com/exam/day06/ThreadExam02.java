package com.exam.day06;

public class ThreadExam02 {
    public static void main(String[] args) {
        System.out.println("main start");
        Thread thread = new Thread(new MyRunable());
        thread.start();
        System.out.println("main end");
    }
}

class MyRunable implements Runnable {

    @Override
    public void run() {
        System.out.println("스레드에서 할 일 구현");
    }
}
