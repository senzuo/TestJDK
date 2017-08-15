package leetcode;

/**
 * 167 Two Sum II - Input array is sorted
 * Created by 申卓 on 2017/8/14.
 */


import java.util.Arrays;

/**
 * 二分查找
 * 重复情况考虑
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = Arrays.binarySearch(numbers, target - numbers[i]);
            // 注意！可能会找到自己  这样是不满足要求的
            if (j > 0 && j != i) {
                if (j < i) {
                    int t = j;
                    j = i;
                    i = t;
                }
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        int target = 8;
        int[] a = new TwoSumII().twoSum(numbers, target);
        System.out.println(Arrays.toString(a));
    }
}
