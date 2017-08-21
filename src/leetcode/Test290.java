package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by 申卓 on 2017/8/16.
 */
public class Test290 {

    public static void main(String[] args) {
        Test290 test290 = new Test290();
        String pattern = "abba";
        String str = "dog dog dog dog";
        boolean bool = test290.wordPattern(pattern,str);
        System.out.println(bool);
    }

    public boolean wordPattern0(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        String[] strArr = str.split(" ");
        int n = pattern.length();
        if (n != strArr.length) return false;
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                if (set.contains(strArr[i]))
                    return false;
                set.add(strArr[i]);
                map.put(ch, strArr[i]);
            } else {
                if (!map.get(ch).equals(strArr[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}
