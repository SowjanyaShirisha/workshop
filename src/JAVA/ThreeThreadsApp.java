class HelloThread extends Thread {
    private static int threadCount = 0;
    private int threadId;

    public HelloThread() {
        threadId = ++threadCount;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + threadId + ": HELLO");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " + threadId + " has completed.");
    }
}

public class ThreeThreadsApp {
    public static void main(String[] args) {
        HelloThread thread1 = new HelloThread();
        HelloThread thread2 = new HelloThread();
        HelloThread thread3 = new HelloThread();

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("HAPPY ENDING");
    }
}

