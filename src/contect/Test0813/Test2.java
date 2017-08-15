package contect.Test0813;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/8/13.
 */
public class Test2 {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> list = null;
        Object[] a = arr.toArray();
        int index = Arrays.binarySearch(a, x);
        if (index < 0) {
            index = -index -1;
        }
        int start = 0;
        int m = (int)(k+0.5) / 2;
        if (index <= m)
            start = 0;
        else if (a.length - index <= m)
            start = a.length - k;
        else
            start = index - m;
        list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            list.add((Integer) a[i + start]);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] intArray = new Integer[]{
            0,1,1,1,2,3,6,7,8,9
        };
//        list.add(0);
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(6);
//        list.add(7);
//        list.add(7);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        List<Integer> list1 = new Test2().findClosestElements(list, 2, 3);

        List list1 = Arrays.asList(intArray);
        List<Integer> list2 = new Test2().findClosestElements(list1, 9, 4);
        System.out.println(list2);
    }
}
