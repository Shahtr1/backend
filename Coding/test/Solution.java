package test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    Queue<String> buffer = new LinkedList<>();

    int capacity = 3;

    class Producer implements Runnable {
        String[] messages = new String[] { "Hi!!", "How are you!!", "I love you!", "What's going on?!!",
                "That's really funny!!" };

        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(500);
                    publish(messages[i]);
                    i = (i + 1) % messages.length;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(500);
                    String msg = consume();
                    System.out.println(Thread.currentThread().getName() + " consumed: " + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    synchronized void publish(String message) throws InterruptedException {
        String name = Thread.currentThread().getName();
        while (buffer.size() == capacity) {
            System.out.println("Queue full inside " + name);
            wait();
        }

        buffer.add(message);
        System.out.println("Message published: " + message);
        notifyAll();
    }

    synchronized String consume() throws InterruptedException {
        String name = Thread.currentThread().getName();
        while (buffer.size() == 0) {
            System.out.println("Queue is empty " + name);
            wait();
        }
        String message = buffer.poll();
        notifyAll();
        return message;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        Solution.Producer producer = sol.new Producer();

        Solution.Consumer consumer1 = sol.new Consumer();
        Solution.Consumer consumer2 = sol.new Consumer();
        Solution.Consumer consumer3 = sol.new Consumer();

        Thread pThread = new Thread(producer);

        Thread thread1 = new Thread(consumer1);
        Thread thread2 = new Thread(consumer2);
        Thread thread3 = new Thread(consumer3);

        pThread.start();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
