package contect.Test0813;

/**
 * Created by Administrator on 2017/8/13.
 */
public class Test1 {
    public boolean judgeCircle(String moves) {
        int i=0,j=0;
        char[] buf = moves.toCharArray();
        for(char ch : buf){
            if(ch=='U') j++;
            else if(ch=='D')    j--;
            else if(ch=='L')    i--;
            else if(ch=='R')    i++;
        }
        return i==0&&j==0;
    }

    public static void main(String[] args) {
        String str  = "UD";
        System.out.println(new Test1().judgeCircle(str));

    }
}
