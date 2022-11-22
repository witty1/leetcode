package weekly.contest271;


/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/maximum-fruits-harvested-after-at-most-k-steps/
 * @since 2021/12/12 11:15
 */
public class Question5955 {


    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        if (startPos - k > fruits[fruits.length - 1][0]){
            return 0;
        }
        int fruitLen = fruits[fruits.length - 1][0] + 1;
        int[] amount = new int[Math.max(fruitLen, startPos + k + 1)];
        for (int[] fruit : fruits) {
            amount[fruit[0]] = fruit[1];
        }
        for (int i = startPos + 1, j = startPos - 1; i <= startPos + k && j >= startPos - k; i++, j--) {
            amount[i] += amount[i - 1];
            if (j < 0 ) {
                continue;
            }
            if (j + 1 >= amount.length){
                j = amount.length - 1;
            }
            amount[j] += amount[j + 1];
        }

        int max = amount[startPos];
        int startVal = amount[startPos];

        for (int i = startPos; i <= startPos + k && i < amount.length; i++) {
            int res = amount[i];
            int temp = k - (i - startPos) * 2;
            int pos = startPos - temp;
            if (temp > 0) {
                pos = Math.max(pos, 0);
                res += amount[pos];
            }
            res -= startVal;
            max = Math.max(res, max);
        }
        int i = Math.min(startPos, amount.length -1);
        for (; i >= 0 && i >= startPos - k; i--) {
            int res = amount[i];
            int temp = k - (startPos - i) * 2;
            int pos = startPos + temp;
            if (temp > 0) {
                pos = Math.min(amount.length - 1, pos);
                res += amount[pos];
            }
            res -= startVal;
            max = Math.max(res, max);
        }

        return max;

    }

    public static void main(String[] args) {
        Question5955 q = new Question5955();
//        int[][] fruit = {{200000, 10000}};
//        int[][] fruit = {{0, 9}, {4,1}, {5,7}, {6,2}, {7,4}, {10,9}};
//        int[][] fruit = {{0,10000}};
//        int[][] fruit = {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
//        int[][] fruit = {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
//        int[][] fruit = {{0,10000}};
        int[][] fruit = {{0, 10}, {1, 6}, {2, 4}, {8, 10}, {9, 5}, {13, 3}, {14, 3}, {23, 4}, {28, 5}, {29, 7}, {30, 6}, {32, 2}, {33, 8}, {36, 4}, {40, 9}};
//        int[][] fruit = {{0, 15}, {3, 56}, {4, 98}, {5, 81}, {7, 16}, {8, 77}, {9, 89}, {12, 82}, {13, 49}, {14, 59}, {17, 40}, {18, 83}, {19, 35}, {20, 31}, {21, 44}, {22, 92}, {25, 84}, {26, 42}, {29, 4}, {33, 78}, {35, 83}, {36, 3}, {37, 71}, {41, 24}, {44, 81}, {45, 35}, {46, 81}, {48, 81}, {50, 85}, {52, 32}, {53, 93}, {54, 89}, {55, 82}, {56, 60}, {59, 52}, {62, 79}, {63, 90}, {64, 41}, {66, 15}, {68, 43}, {69, 32}, {70, 51}, {71, 79}, {75, 39}, {76, 21}, {78, 16}, {79, 44}, {80, 73}, {81, 95}, {83, 95}, {85, 11}, {87, 80}, {88, 2}, {90, 89}, {99, 35}, {100, 95}};
//        System.out.println(q.maxTotalFruits1(fruit, 86, 107));
//        System.out.println(q.maxTotalFruits1(fruit, 5, 4));
//        System.out.println(q.maxTotalFruits1(fruit, 200000, 0));
//        System.out.println(q.maxTotalFruits1(fruit, 0, 200000));
        System.out.println(q.maxTotalFruits(fruit, 0, 23));
    }
}
