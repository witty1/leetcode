package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/8
 * @Time: 9:50
 * @Description: No Description
 */
public class Offer12 {

    public static boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
//        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (work(i, j, board, array, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean work(int i, int j, char[][] board, char[] array, int index) {
        boolean exist = false;
        if (index == array.length) {
            return true;
        }
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || array[index] != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        exist = work(i, j + 1, board, array, index + 1) || work(i + 1, j, board, array, index + 1) || work(i, j - 1, board, array, index + 1) || work(i - 1, j, board, array, index + 1);
        board[i][j] = temp;
        return exist;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}
