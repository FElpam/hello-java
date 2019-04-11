package threadpool;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadPoolDemoTest {
    ThreadPoolDemo demo = new ThreadPoolDemo();
    @Test(timeout = 10000)
    public void fixedThreadPoolTest() {
        demo.fixedThreadPoolTest();
    }
}