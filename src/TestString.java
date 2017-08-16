/**
 * Created by 申卓 on 2017/8/16.
 */
public class TestString {
    public static void main(String[] args) {
        TestString testString = new TestString();
        System.out.println(testString.testSplit("Let's take LeetCode contest"));
    }


    /**
     * String 类型不支持反转 需要转StringBuilder or StringBuffer 才行
     * @param s
     * @return
     */
    public String testSplit(String s){
        String[] strArr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++){
            strArr[i] = new StringBuilder(strArr[i]).reverse().toString();
            stringBuilder.append(strArr[i]+' ');
        }
        return stringBuilder.toString().substring(0,stringBuilder.length()-1);
    }

    public void outputFalse(int n) {
        char[] buf = new char[n];
        for (int i = 0; i < n; i++) {
            buf[i] = 'P';
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                }
                System.out.println(buf);
                buf[i] = 'A';
                System.out.println(buf);
                buf[j] = 'L';
                System.out.println(buf);
            }
        }
    }

//    private void sop(char[] buf){
//        for (char ch )
//    }

    public boolean checkRecord(String s) {
        int n = s.length();
        int countA = 0;
        int countL = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                countA++;
                countL = 0;
            } else if (ch == 'L') {
                countL++;
                if (countL > 2) {
                    return false;
                }
            } else {
                countL = 0;
            }

        }
        return countA < 2;
    }
}
