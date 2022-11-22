package weekly.contest280;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-alternating/
 * @since 2022/2/13 10:49
 */
public class Question6005 {
    public int minimumOperations(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        HashMap<Integer, Integer> odd = new HashMap<>();
        int oddMax = 0, oddCount = 0, evenMax = 0, evenCount = 0;
        int evenMaxCount = 0, oddMaxCount = 0;
        HashMap<Integer, Integer> even = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                evenCount++;
                int value = even.getOrDefault(nums[i], 0) + 1;
                if (value > evenMaxCount) {
                    evenMaxCount = value;
                    evenMax = nums[i];
                }
                even.put(nums[i], value);
            } else {
                oddCount++;
                int value = odd.getOrDefault(nums[i], 0) + 1;
                if (value > oddMaxCount) {
                    oddMaxCount = value;
                    oddMax = nums[i];
                }
                odd.put(nums[i], value);
            }
        }
        if (evenMax == oddMax) {
            int oldOddMax = oddMax;
            int oldOddMaxCount = 0;
            for (Map.Entry<Integer, Integer> next : odd.entrySet()) {
                if (next.getKey() != oddMax && next.getValue() >= oldOddMaxCount) {
                    oldOddMax = next.getKey();
                    oldOddMaxCount = next.getValue();
                }
            }
            if (oldOddMax == oddMax) {
                int oldEvenMax = evenMax;
                int oldEvenMaxCount = 0;
                for (Map.Entry<Integer, Integer> next : even.entrySet()) {
                    if (next.getKey() != evenMax && next.getValue() >= oldEvenMaxCount) {
                        oldEvenMax = next.getKey();
                        oldEvenMaxCount = next.getValue();
                    }
                }
                return Math.min(oddCount + evenCount - evenMaxCount, oddCount - oddMaxCount + evenCount - oldEvenMaxCount);
            } else {
                oddMax = oldOddMax;
            }
        }

        int opeEven = evenCount - even.get(evenMax);
        int opeOdd = oddCount - odd.get(oddMax);

        return opeEven + opeOdd;
    }

    public int[] findNum(int[] nums) {
        int[] maxs = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            if (num > maxs[1]) {
                maxs[1] = num;
            } else if (num > maxs[0]) {
                maxs[0] = num;

            }
            swap(maxs);
        }
        return maxs;
    }

    public void swap(int[] maxs) {
        // maxs[0] > maxs[1];
        if (maxs[1] > maxs[0]) {
            int temp = maxs[0];
            maxs[0] = maxs[1];
            maxs[1] = temp;
        }
    }

    public static void main(String[] args) {
//        new Question6005().minimumOperations(new int[]{48,38,42,18,13,1,97,88,82,48,54,16,78,59,52,30,40,77,59,87,71,28});
//        new Question6005().minimumOperations(new int[]{1,2,2,2,2});
        Question6005 question6005 = new Question6005();
//        question6005.minimumOperations(new int[]{2, 1, 2, 2, 2, 2});
//        new Question6005().minimumOperations(new int[]{4,12,91,17,29,2,32,49,5,30,89,21,91,34,71,22,88,32,36,64,28,69,7,100,35,41,62,91,85,61,4,79,77,52,57,97,41,91,13,34,37,84,10,10,37,93,58,35,81,36,81,6,50,27,68});

        int[] arr1 = new int[]{1, 1, 1, 1, 1, 1};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr3 = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] arr4 = new int[]{1, -1, -100, 98, -2, 0, 4, 5};
        System.out.println(Arrays.toString(question6005.findNum(arr1)));
        System.out.println(Arrays.toString(question6005.findNum(arr2)));
        System.out.println(Arrays.toString(question6005.findNum(arr3)));
        System.out.println(Arrays.toString(question6005.findNum(arr4)));



    }
}
