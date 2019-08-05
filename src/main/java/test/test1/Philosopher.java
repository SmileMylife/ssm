package test.test1;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread{
    private boolean eating;        //false为思考，true为吃状态
    private Philosopher left, right;
    private ReentrantLock table;
    private Condition condition;
    private int thinkCount;
    private Random random;

    //构造方法
    public Philosopher(ReentrantLock table){
        eating = false;
        random = new Random();
        condition = table.newCondition();
        thinkCount = 0;
        this.table = table;
    }

    public void setLeft(Philosopher left) {
        this.left = left;
    }

    public void setRight(Philosopher right) {
        this.right = right;
    }

    public void think(){
        table.lock();
        try{
            eating = false;
            left.condition.signal();
            right.condition.signal();
        }finally {
            table.unlock();
        }
        thinkCount ++;
        if(thinkCount % 10 == 0){
            System.out.println("Philosopher " + this + "has thought for" + thinkCount + "times");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eat(){
        table.lock();
        try{
            while(left.eating || right.eating){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                eating = true;
            }
        }finally {
            table.unlock();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while(true){
            try{
                think();
                eat();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
