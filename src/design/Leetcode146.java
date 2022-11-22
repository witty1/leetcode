/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/7/27 13:58
 */
public class Leetcode146 {
    static class LRUCache {
        LinkedList<Integer> queue;
        int[] count;
        int capacity;

        public LRUCache(int capacity) {
            queue = new LinkedList<>();
            this.capacity = capacity;
            count = new int[10000];
            Arrays.fill(count, -1);
        }

        public int get(int key) {
            if (count[key] != -1) {
                if (queue.getLast() == key) {
                    return count[key];
                }
                Object o = key;
                queue.remove(o);
                queue.addLast(key);
            }
            return count[key];
        }

        public void put(int key, int value) {
            if (count[key] != -1) {
                count[key] = value;
                if (queue.getLast() == key) {
                    return;
                }
                Object o = key;
                queue.remove(o);
                queue.addLast(key);
                return;
            }
            if (queue.size() >= capacity) {
                count[queue.removeFirst()] = -1;
            }
            queue.add(key);
            count[key] = value;
        }
    }


    static class LRUCache1 {
        class DataNode {
            int key;
            int val;
            DataNode next;
            DataNode pre;

            public DataNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        DataNode head;
        DataNode tail;
        int capacity;
        HashMap<Integer, DataNode> map;

        public LRUCache1(int capacity) {
            head = new DataNode(-2,-2);
            tail = new DataNode(-2,-2);
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            DataNode dataNode = map.getOrDefault(key, new DataNode(-1, -1));
            if (dataNode.key == -1) {
                return -1;
            }
            DataNode move = map.get(key);
            move(move);
            return move.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                DataNode dataNode = map.get(key);
                dataNode.val = value;
                move(dataNode);
                return;
            }
            DataNode dataNode = new DataNode(key, value);
            map.put(key, dataNode);
            add(dataNode);
            if (map.size() > capacity) {
                deleteTail();
            }
        }

        public void add(DataNode dataNode) {
            DataNode next = head.next;
            head.next = dataNode;
            dataNode.pre = head;
            dataNode.next = next;
            next.pre = dataNode;
        }

        public void move(DataNode dataNode) {
            dataNode.pre.next = dataNode.next;
            dataNode.next.pre = dataNode.pre;
            DataNode next = head.next;
            head.next = dataNode;
            dataNode.pre = head;
            dataNode.next = next;
            next.pre = dataNode;
        }

        public void deleteTail() {
            DataNode pre = tail.pre;
            pre.pre.next = tail;
            tail.pre = pre.pre;
            map.remove(pre.key);
            pre = null;
        }
    }

    public static void main(String[] args) {
        LRUCache1 cache = new LRUCache1(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));

        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}
