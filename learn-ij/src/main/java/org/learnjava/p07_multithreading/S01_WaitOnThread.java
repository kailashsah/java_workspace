package org.learnjava.p07_multithreading;

class WaitOnThread {

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

public class S01_WaitOnThread {
    public static void main(String[] args) {
        WaitOnThread obj = new WaitOnThread();
        obj.startThread();

        System.out.println("main ends ");

            /*
                output -
                main ends
                waitHereWithLock completed
                waitHere completed
            */

    }
}

