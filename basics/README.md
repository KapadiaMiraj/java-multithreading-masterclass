# 🧵 Thread Creation in Java

This example demonstrates two primary ways to create threads in Java:

---

## ✅ Method 1: Extending `Thread` class

```java
class MyThread extends Thread {
    public void run() {
        // Code to run in new thread
    }
}
```

## ✅ Method 2: Implementing `Runnable` interface

```java
Runnable myRunnable = () -> {
    // Code to run in new thread
};
Thread thread = new Thread(myRunnable);
```

---

### ▶️ [`ThreadCreation.java`](./ThreadCreation.java) : Sample Output

```
Main thread: main
Thread using Thread class: Thread-0
Thread using Runnable: Thread-1
```
Note: Output order may vary due to thread scheduling.

---

### 🧠 [`ThreadCreation.java`](./ThreadCreation.java) : Key Concepts

- start() vs run(): Always use start() to initiate a new thread.
- Threads run asynchronously, so their order is not guaranteed.
- Use Runnable when you want to separate logic from the thread control.

<br>

---

<br>

# ⏳ Thread Lifecycle and Coordination (`sleep()` and `join()`)

This demo shows how threads can be paused (`sleep`) and coordinated (`join`).

## 🔄 Key Lifecycle Methods
- `start()`: Moves thread to **Runnable** state.
- `sleep(ms)`: Temporarily **pauses** thread execution.
- `join()`: Makes current thread **wait** for another to finish.
- `interrupt()`: Interrupts a sleeping or waiting thread.

---

### ▶️ [`ThreadLifecycleDemo.java`](./ThreadLifecycleDemo.java) : Sample Output

```
Main thread: Starting worker thread...
Worker thread: Started
Worker thread: Finished
Main thread: Worker completed. Exiting.
```
Note: You’ll see a ~2 second pause while the worker thread sleeps.

---

### 🧠 [`ThreadLifecycleDemo.java`](./ThreadLifecycleDemo.java) : Key Concepts
- **Thread.sleep()** keeps CPU free while thread waits.
- **Thread.join()** ensures thread synchronization in order of execution.
- Without `join()`, main thread might exit before worker finishes.

<br>

---

<br>

# 🔐 Race Condition and Synchronization

```
A race condition happens when two or more threads access shared data at the same time, and the final result depends on the unpredictable timing of their execution.
```

This demo shows what happens when multiple threads access shared data unsafely.

## ⚠️ Without `synchronized`

- Threads may **interleave** and cause missed updates.
- Final result is **unpredictable** (usually < 20000).

## ✅ With `synchronized`

- Only one thread at a time can enter the **critical section**.
- Final result will **always be 20000**.

---

### 🧪 [`RaceConditionDemo.java`](./RaceConditionDemo.java) : Try It Yourself

1. Run as-is and observe `Final count < 20000`.
2. Then uncomment `synchronized` in the `increment()` method.
3. Re-run and see the correct, consistent result: `Final count: 20000`.

---

### 🧠 [`RaceConditionDemo.java`](./RaceConditionDemo.java) : Key Concepts

| Concept             | Description |
|---------------------|-------------|
| Race Condition      | Multiple threads modify shared state without sync |
| Synchronized Method | Makes method execution atomic per object |
| Critical Section    | Code accessing/modifying shared state |

<br>

---

<br>