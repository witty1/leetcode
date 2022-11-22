package weekly.contest279;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/design-bitset/
 * @since 2022/2/7 17:32
 */
public class Question2166 {
    /**
     * ["Bitset","flip","unfix","all","fix","fix","unfix","all","count","toString","toString","toString","unfix","flip","all","unfix","one","one","all","fix","unfix"]
     * [[2],[],[1],[],[1],[1],[1],[],[],[],[],[],[0],[],[],[0],[],[],[],[0],[0]]
     */
    class Bitset {
        int reverse = 0;
        int[] nums;
        int oneCount = 0;
        int size;

        /**
         * 用 size 个位初始化 Bitset ，所有位都是 0 。
         *
         * @param size
         */
        public Bitset(int size) {
            this.size = size;
            nums = new int[size];
        }

        /**
         * 将下标为 idx 的位上的值更新为 1 。如果值已经是 1 ，则不会发生任何改变
         *
         * @param idx
         */
        public void fix(int idx) {
            if ((nums[idx] ^ reverse) == 0) {
                nums[idx] ^= 1;
                ++oneCount;
            }
        }

        /**
         * 将下标为 idx 的位上的值更新为 0 。如果值已经是 0 ，则不会发生任何改变。
         *
         * @param idx
         */
        public void unfix(int idx) {
            if ((nums[idx] ^ reverse) == 1) {
                nums[idx] ^= 1;
                --oneCount;
            }
        }


        /**
         * 10
         * 1
         * 翻转 Bitset 中每一位上的值。换句话说，所有值为 0 的位将会变成 1 ，反之亦然。
         */
        public void flip() {
            reverse ^= 1;
            oneCount = size - oneCount;
        }

        /**
         * 检查 Bitset 中 每一位 的值是否都是 1 。如果满足此条件，返回 true ；否则，返回 false 。
         *
         * @return
         */
        public boolean all() {
            return oneCount == size;
        }

        /**
         * 检查 Bitset 中 是否 至少一位 的值是 1 。如果满足此条件，返回 true ；否则，返回 false 。
         *
         * @return
         */
        public boolean one() {
            return oneCount > 0;
        }

        /**
         * 返回 Bitset 中值为 1 的位的 总数 。
         *
         * @return
         */
        public int count() {
            return oneCount;
        }

        /**
         * 返回 Bitset 的当前组成情况。注意，在结果字符串中，第 i 个下标处的字符应该与 Bitset 中的第 i 位一致。
         *
         * @return
         */
        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (int num : nums) {
                sb.append(num ^ reverse);
            }

            return sb.toString();
        }
    }
}
