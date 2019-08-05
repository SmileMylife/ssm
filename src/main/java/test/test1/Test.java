package test.test1;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //init five ReentrantLocks and philosophers
        Philosopher[] philosophers = new Philosopher[5];
        ReentrantLock[] reentrantLocks = new ReentrantLock[5];

        for (int i = 0; i < 5; i++) {
            reentrantLocks[i] = new ReentrantLock();
        }

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(reentrantLocks[i]);
            philosophers[i].start();
        }
        for (int i = 0; i < 5; i++) {
            philosophers[i].join();
        }
    }
}
