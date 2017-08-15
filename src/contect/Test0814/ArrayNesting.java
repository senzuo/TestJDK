package contect.Test0814;


/**
 * Created by Administrator on 2017/8/14.
 */
public class ArrayNesting {
    public static void main(String[] args) {

        int[] arr = {5,4,0,3,1,6,2};
//        int[] arr = {0,2,1};
        System.out.println(new ArrayNesting().arrayNesting(arr));

    }

    public int arrayNesting(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                continue;
            }
            int count = 1;
            int k = nums[i];
            int n = nums[k];
            while (n != k){
                int m = nums[n];
                nums[n] = -1;
                n = m;
                count++;
            }
            nums[i] = -1;
            nums[k] = -1;
            len = len > count? len : count;
        }
        return len;

    }
}
