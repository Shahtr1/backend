package threads.execution_models.readers_writers_problem;

import java.util.concurrent.locks.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final StringBuilder document = new StringBuilder("Document Start\n");

    private static final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    /*
     * ReadWriteLock: A special lock that allows:
     * 
     * - Multiple readers at once if no writer is active.
     * - Only one writer, and it blocks all readers during writing.
     */
    private static final Lock readLock = rwLock.readLock();
    private static final Lock writeLock = rwLock.writeLock();

    public static void main(String[] args) {
        // Start writer threads
        for (int i = 1; i <= 3; i++) {
            new Thread(new Writer(), "Writer-" + i).start();
        }

        // Start reader threads
        for (int i = 1; i <= 5; i++) {
            new Thread(new Reader(), "Reader-" + i).start();
        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            while (true) {
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " is reading document:\n" +
                            "--------------------------\n" +
                            document +
                            "--------------------------\n");
                } finally {
                    readLock.unlock();
                }

                sleepRandom(2000, 4000);
            }
        }
    }

    static class Writer implements Runnable {
        private int lineNumber = 1;

        @Override
        public void run() {
            while (true) {
                writeLock.lock();
                try {
                    String newLine = "Line " + lineNumber + " written by " + Thread.currentThread().getName() + "\n";
                    document.append(newLine);
                    System.out.println(Thread.currentThread().getName() + " wrote: " + newLine.trim());
                    lineNumber++;
                } finally {
                    writeLock.unlock();
                }

                sleepRandom(3000, 5000);
            }
        }
    }

    static void sleepRandom(int minMillis, int maxMillis) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(minMillis, maxMillis));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
