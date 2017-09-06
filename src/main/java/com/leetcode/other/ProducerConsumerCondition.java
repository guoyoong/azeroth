package com.leetcode.other;
/**
 * Created by guoyong1 on 2017/9/4.
 */

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerCondition {

    private int queueSize = 10;
    private PriorityQueue<String> queue = new PriorityQueue<String>(queueSize);

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() == 0) {
                        try {
                            System.out.println("queue is empty");
                            empty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(queue.poll());
                    full.signal();
                }  catch (Exception e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("queue full !");
                            full.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer("11111");
                    empty.signal();
                } catch (Exception e){
                    e.printStackTrace();
                } finally{
                    lock.unlock();
                }
            }
        }
    }

    @Test
    public void test() {
        Producer pro = new Producer();
        Consumer cus = new Consumer();
        new Thread(pro).start();
        new Thread(cus).start();
    }

}
