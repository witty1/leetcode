package weekly.contest323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-323
 * @since 2022/12/11 10:31
 */
public class Question323 {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int ans = 0;
        int idx = grid[0].length - 1;
        while (idx >= 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < grid.length; i++) {
                max = Math.max(max, grid[i][idx]);
            }
            ans += max;
            idx--;
        }
        return ans;
    }

    public int longestSquareStreak(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            int sum = num * num;
            List<Integer> list = map.get(num);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(num);
            map.put(sum, list);
        }

        Set<Map.Entry<Integer, List<Integer>>> entrySet = map.entrySet();
        int ans = -1;
        for (Map.Entry<Integer, List<Integer>> entry : entrySet) {
            int size = entry.getValue().size();
            if (size > 1) {
                ans = Math.max(ans, size);
            }
        }
        return ans;
    }


    static class Allocator {
        TreeSet<Integer> freeSpace;
        HashMap<Integer, List<Integer>> usedSpace;
        int[] space;

        public Allocator(int n) {
            freeSpace = new TreeSet<>();
            usedSpace = new HashMap<>(n);
            space = new int[n];
            for (int i = 0; i < n; i++) {
                freeSpace.add(i);
            }
        }

        public int allocate(int size, int mID) {
            Iterator<Integer> iterator = freeSpace.iterator();
            int pos = -1;
            while (iterator.hasNext()) {
                int temp = size;
                Integer next = iterator.next();
                if (pos != -1 && next < pos) {
                    continue;
                }
                int i = next;
                //todo 优先队列
                while (i < space.length && space[i] == 0 && temp > 0) {
                    i++;
                    --temp;
                }
                if (i >= space.length && temp != 0) {
                    return -1;
                }
                if (temp == 0) {
                    List<Integer> list = usedSpace.getOrDefault(mID, new ArrayList<>());
                    int len = i - size;
                    for (; i > len; i--) {
                        space[i - 1] = mID;
                        list.add(i - 1);
                        freeSpace.remove(i - 1);
                    }
                    usedSpace.put(mID, list);
                    return i;
                }
                pos = i;

            }
            return -1;
        }

        public int free(int mID) {
            List<Integer> list = usedSpace.remove(mID);
            if (list == null) {
                return 0;
            }
            for (Integer integer : list) {
                space[integer] = 0;
                freeSpace.add(integer);
            }
            return list.size();
        }
    }

    public static void main(String[] args) {
        Question323 question323 = new Question323();
//        question323.deleteGreatestValue(new int[][]{{1,2,4}, {3,3,1}});
//        question323.longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2});
        Allocator loc = new Allocator(10); // 初始化一个大小为 10 的内存数组，所有内存单元都是空闲的。
        loc.allocate(1, 1); // 最左侧的块的第一个下标是 0 。内存数组变为 [1, , , , , , , , , ]。返回 0 。
        loc.allocate(1, 2); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,2, , , , , , , , ]。返回 1 。
        loc.allocate(1, 3); // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。
        loc.free(2); // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
        loc.allocate(3, 4); // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,4,4,4, , , , ]。返回 3 。
        loc.allocate(1, 1); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
        loc.allocate(1, 1); // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。
        loc.free(1); // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
        loc.allocate(10, 2); // 无法找出长度为 10 个连续空闲内存单元的空闲块，所有返回 -1 。
        loc.free(7); // 释放 mID 为 7 的所有内存单元。内存数组保持原状，因为不存在 mID 为 7 的内存单元。返回 0 。
    }
}
