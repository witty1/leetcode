package offer;

import java.util.Arrays;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/10
 * @Time: 16:11
 * @Description: No Description
 */
public class Offer40 {
    public int[] getLeastNumber(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return judge(arr, k - 1, 0, arr.length - 1);
    }

    public int[] judge(int[] arr, int k, int low, int high) {
        int i = quickSort(arr, low, high);
        if (i == k) {
            return Arrays.copyOf(arr, k + 1);
        }
        return i > k ? judge(arr, k, low, i - 1) : judge(arr, k, i + 1, high);
    }

    public int quickSort(int[] arr, int low, int high) {

        int basic = arr[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i <= high && arr[i] < basic) ;
            while (--j >= low && arr[j] > basic) ;
            if (i >= j) {
                break;
            }
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        arr[low] = arr[j];
        arr[j] = basic;

        return j;
    }

    public static void main(String[] args) {
        Offer40 offer40 = new Offer40();
        Arrays.stream(offer40.getLeastNumbers(new int[]{9, 3, 2, 4, 5, 6}, 2)).forEach(System.out::print);
    }
}
