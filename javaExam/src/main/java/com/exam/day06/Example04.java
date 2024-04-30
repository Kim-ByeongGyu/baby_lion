package com.exam.day06;

public class Example04 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterThread thread1 = new CounterThread(counter, 5000);
        CounterThread thread2 = new CounterThread(counter, 4000);

        thread1.start();
        thread2.start();
        // synchronized가 없다면 스레드기 실행되다가
        // 증가에 이상이 생긴다.
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter.getCount());
    }
}
class Counter {
    private int count = 0;
    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}

class CounterThread extends Thread {
    private Counter counter;
    private int maxCount;
    public CounterThread(Counter counter, int maxCount) {
        this.counter = counter;
        this.maxCount = maxCount;
    }

    public void run() {
        for (int i = 0; i < maxCount; i++) {
            counter.increment();
        }
    }
}




