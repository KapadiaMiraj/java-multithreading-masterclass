public class ThreadCreation {
    public static void main(String[] args) {
        // Method 1: Extending Thread class
        class MyThread extends Thread {
            public void run() {
                System.out.println("Thread using Thread class: " + Thread.currentThread().getName());
            }
        }

        // Method 2: Implementing Runnable interface
        Runnable myRunnable = () -> {
            System.out.println("Thread using Runnable: " + Thread.currentThread().getName());
        };

        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(myRunnable);

        thread1.start(); // Starts a new thread
        thread2.start(); // Starts another new thread

        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
