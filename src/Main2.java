/**
 * Created by 13010 on 2017/8/16.
 */

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String str = in.nextLine();
            str = str.trim();
            int atIndex = str.indexOf('@');
            int pointIndex = str.indexOf('.', atIndex);

            if (str.length() > 3 && "***".equals(str.substring(0, 3))) {
                System.out.println(str);
            } else if (atIndex > 2 && pointIndex - atIndex - 1 <= 119) {
                StringBuilder builder = new StringBuilder(str);
                builder.replace(atIndex - 3, atIndex, "***");
                System.out.println(builder.toString());
            } else {
                System.out.println(str);
            }
        }
        in.close();
    }
}
