public class ThreadLifecycleDemo {

    public static void main(String[] args) {

        Thread worker = new Thread(() -> {
            System.out.println("Worker thread: Started");

            try {
                // Simulating time-consuming task
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Worker thread: Interrupted");
            }

            System.out.println("Worker thread: Finished");
        });

        System.out.println("Main thread: Starting worker thread...");
        worker.start();

        try {
            // Wait for worker to finish before continuing
            worker.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread: Interrupted while waiting");
        }

        System.out.println("Main thread: Worker completed. Exiting.");
    }
}
