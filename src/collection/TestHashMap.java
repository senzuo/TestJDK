package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/12.
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        // 使 key 的哈希值一样，观察碰撞情况
        map.put(1,"one");
        map.put(1,"two");
        map.put(2,"two");


        traverse3(map);

    }

    // traverse 遍历 hash map

    /**
     * for-each entry
     * @param map
     */
    public static void traverse1(Map<Integer,String> map){
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("key= " + entry.getKey());
            System.out.println("value= " + entry.getValue());
        }
    }
    /**
     *  for each keys values
     *  比entrySet迭代具有轻微的性能优势(大约快10%)
     * @param map
     */
    public static void traverse2(Map<Integer,String> map){
        for (Integer key : map.keySet()){
            System.out.println("key= " + key);
        }
        for (String value : map.values()){
            System.out.println("value= " + value);
        }
    }

    /**
     * iterator
     * 在迭代的时候从map中删除entries的(通过调用iterator.remover())唯一方法.
     * 从性能方法看，这个方法等价于使用For-Each迭代
     * @param map
     */
    public static void traverse3(Map<Integer,String> map){
        Iterator<Map.Entry<Integer,String>> entryIterator =
                map.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Integer,String> entry = entryIterator.next();
            System.out.println("key= " + entry.getKey()  + ",value = " + entry.getValue());
        }
    }

    /**
     * 它更慢更低效，通过key得到value值更耗时
     * @param map
     */
    public static void traverse4(Map<Integer,String> map){
        for (Integer key : map.keySet()){
            String value = map.get(key);
            System.out.println("Key= " + key + ",Value= " + value);
        }
    }
}
