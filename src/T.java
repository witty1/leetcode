import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/19 9:52
 */
@SuppressWarnings("all")
public class T {



    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
//        Semaphore semaphore1 = new Semaphore(1);

        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        semaphore.acquire();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                map.put(i, i);
            }
            semaphore.release();
            long start = System.currentTimeMillis();
            System.out.println("start:" + start);

            for (int i = 0; i < 1000; i++) {
                Thread.yield();
            }
            map.get(1);
            long end = System.currentTimeMillis();
            System.out.println("end:" + end);
            System.out.println(end - start);
        });
        thread.setPriority(1);
        thread.start();
        semaphore.acquire();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 10000; j++) {
                    sb.append(j);
                }
                System.out.println(Thread.currentThread().getName() + " end time:" + System.currentTimeMillis());
            }).start();
        }
        Thread thread1 = new Thread(() -> {
            int j = 0;
            for (int i = 0; i < 10000000; i++) {

                j += i;
            }
        });
        thread1.setPriority(10);

        thread1.start();

    }
}
