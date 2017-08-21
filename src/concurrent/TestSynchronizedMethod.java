package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 申卓 on 2017/8/21.
 */
public class TestSynchronizedMethod {
    private Lock lock = new ReentrantLock();
    private int count = 0;

    public int inc() {
        lock.lock();
        this.count++;
        lock.unlock();
        return count;
    }
}
