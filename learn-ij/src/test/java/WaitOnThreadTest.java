import org.junit.jupiter.api.Test;
import org.learnjava.srcForTests.WaitOnThread;

/*
1.  this test shows wait doesn't return when run from the test runtime. In normal run it works fine
2.  Thread.sleep(1000);
    lock.wait(1000);
    These are the two ways to wait for a thread to complete.

*/
public class WaitOnThreadTest {

    @Test
    public void testMethod() {
        WaitOnThread obj = new WaitOnThread();
        obj.startThread();
    }
}
