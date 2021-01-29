package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread{

    private Semaphore semaphore;
    private CountDownLatch countDownLatch;

    public PassengerThread(String name, Semaphore semaphore, CountDownLatch countDownLatch) {
        super(name);
        this.semaphore = semaphore;
        this.countDownLatch= countDownLatch;
        start();
    }

    @Override
    public void run() {
        System.out.println(getName()+" подошел на кассу и ждет очереди на кассе");
        try {
            semaphore.acquire();
            System.out.println(getName()+" покупает билет");
            sleep(1000);
            System.out.println(getName()+ " садиться на автобус");
            countDownLatch.countDown();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
