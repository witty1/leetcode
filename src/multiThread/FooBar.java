package multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/8/7
 * @Time: 21:32
 * @Description: https://leetcode-cn.com/problems/print-foobar-alternately/
 * Reentrantlock+condition实现
 */
public class FooBar {
    private int n;
    private int flag = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();

            while (flag != 0) {
                condition.await();
            }
            try {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                condition.signalAll();
                flag = 1;
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            while (flag != 1) {
                condition.await();
            }
            try {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                condition.signalAll();
                flag = 0;
            } finally {
                lock.unlock();
            }
        }
    }
}
