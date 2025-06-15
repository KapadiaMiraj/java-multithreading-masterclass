class Counter {
    int count = 0;

    // Uncomment synchronized to fix the race condition
    public /* synchronized */ void increment() {
        count++;
    }
}

public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Thread 1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.count);
    }
}
