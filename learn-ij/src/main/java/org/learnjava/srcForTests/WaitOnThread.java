package org.learnjava.srcForTests;

/*
    1. This class is written to show case wait() doesn't return if run using test runtime.
        public class WaitOnThreadTest  <-- check this class
*/

public class WaitOnThread {
    private Object lock = new Object();

    public void startThread() {
        Thread th = new Thread(this::waitHere);
        new Thread(this::waitHereWithLock).start();
        th.start();
    }

    public void waitHere() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            System.out.println("Exception caught : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception caught : " + e.getMessage());
        }
        System.out.println("waitHere completed");
    }

    public void waitHereWithLock() {
        synchronized (lock) {
            try {
                lock.wait(1000);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                System.out.println("Exception caught : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Exception caught : " + e.getMessage());
            }
            System.out.println("waitHereWithLock completed");
        }

    }
}
