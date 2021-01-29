package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        CountDownLatch countDownLatch = new CountDownLatch(101);

        for (int i = 0; i < 101; i++) new PassengerThread("Пассажир" + i, semaphore, countDownLatch);
        try {
            countDownLatch.await();
            System.out.println("Автобус отправился в Ош");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

    }
}
