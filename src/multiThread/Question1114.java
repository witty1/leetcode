package multiThread;

import java.util.concurrent.Semaphore;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/problems/print-in-order/
 * @since 2022/2/11 10:48
 */
public class Question1114 {
    class Foo{
        Semaphore fist;
        Semaphore second;
        Semaphore third;
        public Foo() {
            fist = new Semaphore(1);
            second = new Semaphore(0);
            third = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            fist.acquire();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            second.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            second.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            third.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            fist.release();
        }
    }

}
