package org.apache.commons.io;

class ThreadMonitor implements Runnable {
    private final Thread thread;
    private final long timeout;

    private ThreadMonitor(Thread thread2, long j) {
        this.thread = thread2;
        this.timeout = j;
    }

    private static void sleep(long j) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis() + j;
        do {
            Thread.sleep(j);
            j = currentTimeMillis - System.currentTimeMillis();
        } while (j > 0);
    }

    public static Thread start(long j) {
        return start(Thread.currentThread(), j);
    }

    public static Thread start(Thread thread2, long j) {
        if (j <= 0) {
            return null;
        }
        Thread thread3 = new Thread(new ThreadMonitor(thread2, j), ThreadMonitor.class.getSimpleName());
        thread3.setDaemon(true);
        thread3.start();
        return thread3;
    }

    public static void stop(Thread thread2) {
        if (thread2 != null) {
            thread2.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            sleep(this.timeout);
            this.thread.interrupt();
        } catch (InterruptedException unused) {
        }
    }
}
