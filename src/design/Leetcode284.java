/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package design;

import java.util.Iterator;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/10/5 10:20
 */
public class Leetcode284 {

    // Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    List<Integer> nums;
    Iterator<Integer> iterator;

    class PeekingIterator implements Iterator<Integer> {
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iterator.forEachRemaining(integer -> nums.add(integer));

        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
//            iterator.
            return 0;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return 0;
        }

        @Override
        public boolean hasNext() {
            return true;
        }
    }
}
