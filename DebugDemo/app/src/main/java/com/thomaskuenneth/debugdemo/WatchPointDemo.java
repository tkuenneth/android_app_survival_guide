package com.thomaskuenneth.debugdemo;

class WatchPointDemo {

    private int i;
    private boolean running;

    WatchPointDemo() {
        i = 0;
        running = false;
    }

    synchronized void start() {
        if (!running) {
            running = true;
            Thread t = new Thread(() -> {
                while (running) {
                    if (42 == ((int) (Math.random() * 999999))) {
                        i = i + 1;
                        System.out.println(i);
                    }
                }
            });
            t.start();
        }
    }

    synchronized void stop() {
        running = false;
    }
}
