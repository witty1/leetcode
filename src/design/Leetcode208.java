package design;

import java.util.LinkedList;

/**
 * TODO
 *
 * @author zhengcp
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @since 2021/12/13 16:34
 */
public class Leetcode208 {
    static class Trie {
        LinkedList<String>[] list;

        public Trie() {
            list = new LinkedList[123];
            for (int i = 0; i < list.length; i++) {
                list[i] = new LinkedList<>();
            }
        }

        public void insert(String word) {
            list[word.charAt(0)].add(word);
        }

        public boolean search(String word) {
            if (list[word.charAt(0)].isEmpty()) {
                return false;
            }
            for (Object o : list[word.charAt(0)]) {
                String str = (String) o;
                if (str.equals(word)) {
                    return true;
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            if (list[prefix.charAt(0)].isEmpty()) {
                return false;
            }
            for (Object o : list[prefix.charAt(0)]) {
                String str = (String) o;
                if (prefix.length() > str.length()) {
                    continue;
                }
                if (str.substring(0, prefix.length()).equals(prefix)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    static class Trie1 {
        private Trie1[] children;
        private boolean isEnd;

        public Trie1() {
            children = new Trie1[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie1 node = this;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (node.children[pos] == null) {
                    node.children[pos] = new Trie1();
                }
                node = node.children[pos];

            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie1 node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie1 node = searchPrefix(prefix);
            return node != null;
        }

        private Trie1 searchPrefix(String prefix) {
            Trie1 node = this;
            for (int i = 0; i < prefix.length(); i++) {
                int pos = prefix.charAt(i) - 'a';
                if (node.children[pos] == null) {
                    return null;
                }
                node = node.children[pos];
            }
            return node;
        }
    }

}
