package cscPortfolioProject;


import java.util.concurrent.atomic.AtomicBoolean;

class Counter {

    // set the flag to start false.
    // set the flag to true when countUp finishes.
    private static final AtomicBoolean finished = new AtomicBoolean(false);

    // Lock object for wait/notify
    private static final Object lock = new Object();

    // Count up to 20, then update the flag and notify the other thread
    public static void countUp() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Thread 1: " + i);
        }

        //set flag to true
        finished.set(true);

        // Notify the waiting thread
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    // Wait until the countUp is finished, then count down from 20
    public static void countDown() {
        synchronized (lock) {
            while (!finished.get()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return; // exit if interrupted
                }
            }
        }

        for (int i = 20; i >= 0; i--) {
            System.out.println("Thread 2: " + i);
        }
    }

    /*
     * The Java program starts with the static void main(String[] args).
     * This method is the entry point. Creates and starts threadOne and threadTwo
     */
    public static void main(String[] args) {

    	//sets finished to false
        finished.set(false);
        
        //creates and starts threadOne and threadTwo
        Thread threadOne = new Thread(Counter::countUp);
        Thread threadTwo = new Thread(Counter::countDown);
        
        threadOne.start();
        threadTwo.start();

        //blocks main thread until threadOne and threadTwo finish executing
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Program Completed");
    }
}