package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 申卓 on 2017/8/15.
 * Tag  String
 */

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        String s = "wllxdiklosdrdxfohgwringzefwbytmwgxtjhdxwycpbawphcnbmajmeokhoftlmsexakuyixplxmagoojdospvjbcxh";
        System.out.println(test3.lengthOfLongestSubstring(s));
    }


    /**
     * 特殊情况  单个字符  不会进入else
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // String => Array
        char[] buf = s.toCharArray();
        int maxlen = 0;
        int count = 0;
        for (int i = 0; i < buf.length; i++) {
            if (!map.containsKey(buf[i])) {
                count++;
                map.put(buf[i], i);
            } else {
                maxlen = maxlen > count ? maxlen : count;
                int index = map.get(buf[i]);
                count = i - index;
                map.clear();
                for (int j = index + 1; j <= i; j++) {
                    map.put(buf[j], j);
                }
            }
        }
        maxlen = maxlen > count ? maxlen : count;
        return maxlen;
    }

}
