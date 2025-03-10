package org.learnjava.p07_multithreading;

/*
===== thread synchronization =====
1. Synchronized method is used to lock an object for any shared resource.
2. When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the thread completes its task.
3. Object.wait()
        method causes current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object.
    Object.notify()
        wakes up a single thread that is waiting on this object's monitor.

4. Why Enclose wait() in a while Loop?
    Since notify() and notifyAll() randomly wake up threads that are waiting on this object’s monitor, it’s not always important that the condition is met. Sometimes the thread is woken up, but the condition isn’t actually satisfied yet.

    We can also define a check to save us from spurious wakeups — where a thread can wake up from waiting without ever having received a notification.

5. Why Do We Need to Synchronize Methods?
    We placed these methods inside synchronized methods to provide intrinsic locks. If a thread calling wait() method does not own the inherent lock, an error will be thrown.

    The synchronized keyword is used to acquire a lock for an object. It is used to lock an object for any shared resource. When a thread invokes a synchronized method, it automatically acquires the lock for that object and releases it when the thread completes its task.

    https://www.baeldung.com/java-wait-notify
*/

class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw...");

        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.amount -= amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount) {
        System.out.println("going to deposit...");
        this.amount += amount;
        System.out.println("deposit completed... ");
        notify();
    }
}

public class SynchronizedMethodsEx {
    public static void main(String args[]) {
        final Customer customer = new Customer();

        new Thread() {
            public void run() {
                customer.withdraw(15000);
            }
        }.start();

        new Thread() {
            public void run() {
                customer.deposit(10000);
            }
        }.start();

    }

	/*
	Output:

	going to withdraw...
	Less balance; waiting for deposit...
	going to deposit...
	deposit completed...
	withdraw completed...

	*/
}