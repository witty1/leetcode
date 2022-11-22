package multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/problems/building-h2o/
 * @since 2022/2/11 11:02
 */
public class Question1117 {
    class H2O {
        Semaphore h = new Semaphore(2);
        Semaphore o = new Semaphore(0);
        AtomicInteger count = new AtomicInteger(2);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            if (count.decrementAndGet() == 0) {
                o.release();
            }

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            count.addAndGet(2);
            h.release(2);
        }
    }


    class H2O1 {
        Semaphore h = new Semaphore(2);
        Semaphore o = new Semaphore(1);
        AtomicInteger hC = new AtomicInteger(2);
        AtomicInteger oC = new AtomicInteger(1);
        Lock lock = new ReentrantLock();

        public H2O1() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hC.decrementAndGet();
            conditionLock();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            oC.decrementAndGet();
            conditionLock();
        }

        public void conditionLock() {
            if (oC.get() != 0 || hC.get() != 0) {
                return;
            }
            lock.lock();
            try {
                if (oC.get() == 0 || hC.get() == 0) {
                    h.release(2);
                    o.release();
                    oC.addAndGet(1);
                    hC.addAndGet(2);

                }
            } finally {
                lock.unlock();
            }
        }
    }


    class H2O2 {
        Semaphore h = new Semaphore(2);
        Semaphore o = new Semaphore(1);
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            h.release(2);
            o.release();
        });

        public H2O2() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }


    }
}
