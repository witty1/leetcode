package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/13
 * @Time: 13:22
 * @Description: https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static boolean exist(char[][] board, String word) {
        boolean flag = false;
        char[] words = word.toCharArray();
        int y = board.length, x = board[0].length;
        boolean[][] visit = new boolean[y][x];
        for (int i = 0; i < y; i++) {

            for (int j = 0; j < x; j++) {
                int k = 0;
                if (find(board, words, i, j, k, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    //i代表列，j代表行
    public static boolean find(char[][] board, char[] word, int i, int j, int k, boolean[][] visit) {
        if (k == word.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j]) {
            return false;
        }
        visit[i][j] = true;
        if (board[i][j] == word[k]) {
            for (int[] ints : dir) {
                if (find(board, word, i + ints[0], j + ints[1], k + 1, visit)) {
                    return true;
                }
            }
        }

        visit[i][j] = false;
        return false;
    }


    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        System.out.println(exist(board, "ASADFBCCEESE"));
    }
}
