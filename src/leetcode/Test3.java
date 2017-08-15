package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by 申卓 on 2017/8/15.
 * Tag  String
 */

public class Test3 {
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        String s = "wllxdiklosdrdxfohgwringzefwbytmwgxtjhdxwycpbawphcnbmajmeokhoftlmsexakuyixplxmagoojdospvjbcxh";
//        String s = "abcabc";
//        System.out.println(test3.lengthOfLongestSubstring2(s));
        System.out.println(test3.lengthOfLongestSubstringM(s));
//        System.out.println(test3.BruteForce(s));
    }

    /**
     * 暴力求解法
     * @param s
     * @return
     */
    public int BruteForce(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }


    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(s.charAt(i))){
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }


    /**
     * 特殊情况  单个字符  不会进入else
     *
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

    /**
     * Sliding Window  => two point
     * count => width of windows  j - i
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优解
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringM(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


}
