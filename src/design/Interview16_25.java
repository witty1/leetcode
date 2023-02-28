package design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/lru-cache-lcci/
 * @since 2022/11/23 10:04
 */
public class Interview16_25 {
    static class LRUCache {
        LinkedList<Integer> list;
        LinkedHashMap<Integer, Integer> map;
        int capacity;

        public LRUCache(int capacity) {
            list = new LinkedList<>();
            this.capacity = capacity;
            map = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            map.get(key);
            return -1;
        }

        public void put(int key, int value) {
//            map.put();
//            map.remove()
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }
}
