import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a, b;
        while (in.hasNext()) {//注意while处理多个case
            String str = in.nextLine();
            String[] strArr = str.split(" ");
            a = strArr[0];
            b = strArr[1];
            Foo(a, b);
        }
        in.close();
    }

    private static void Foo(String a, String b) {

        int n = a.length();
        if (n != b.length()) {
            System.out.println(-1);
            return;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        if (max < 2)
            System.out.println(0);
        else
            System.out.println(max);
    }
}