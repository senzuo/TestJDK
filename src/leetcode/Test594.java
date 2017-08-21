//package leetcode;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//
///**
// * Created by 申卓 on 2017/8/16.
// */
//public class Test594 {
//    public int findLHS(int[] nums) {
//        Map<Integer,Integer> map = new TreeMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(i)){
//                map.put(i,map.get(i)+1);
//            } else {
//                map.put(i,1);
//            }
//        }
//
//        Set<Integer> set =  map.keySet();
//        int result = 0;
////        int a = set, b = 0;
//        for(Integer i : set) {
//
//        }
//
//
//    }
//}
