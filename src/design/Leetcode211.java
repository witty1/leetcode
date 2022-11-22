package design;

/**
 * TODO
 *
 * @author zhengcp
 * @version V2.1
 * @since 2021/12/14 9:31
 * @description: https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
 */
public class Leetcode211 {
    static class WordDictionary {
        Node root;
        static char ch = '.';

        class Node {
            Node[] children;
            boolean isEnd;

            public Node() {
                children = new Node[26];
                isEnd = false;
            }
        }

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (node.children[pos] == null) {
                    node.children[pos] = new Node();
                }
                node = node.children[pos];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {

            return dfs(root, word, 0);
        }

        private boolean dfs(Node node, String word, int i) {
            if (i >= word.length()) {
                return node.isEnd;
            }
            //.的情况
            if (ch == word.charAt(i)) {
                int temp = i  + 1;
                for (Node child : node.children) {
                    if (child != null) {
                        if (dfs(child, word, temp)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            int pos = word.charAt(i) - 'a';
            if (node.children[pos] == null) {
                return false;
            }

            return dfs(node.children[pos], word, ++i);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        System.out.println(wordDictionary.search("..d"));

    }
}
