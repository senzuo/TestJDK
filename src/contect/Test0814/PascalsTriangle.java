package contect.Test0814;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 * 对 LinkedList 不熟悉
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(new PascalsTriangle().getRow(i));
//        System.out.println(new PascalsTriangle().getRow(5));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
//        for (int i = 0; i <= rowIndex; i++) {
//            list.add(0);
//        }
        if (rowIndex < 0) {
            return list;
        }
//        if (rowIndex == 0){
//            list.set(0,1);
//            return list.subList(0,rowIndex+1);
//        }


        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            list.add(0, 1);
            for (int j = 1; j < rowIndex && j < list.size()-1; j++) {
                // update list
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list.subList(0, rowIndex+1);
    }
}
