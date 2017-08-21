package reflect;

/**
 * Created by 申卓 on 2017/8/21.
 */

/**
 * 通过一个对象获得完整的包名和类名
 */
public class GetName {
    public static void main(String[] args) {
        GetName getName = new GetName();
        System.out.println(getName.getClass().getName());
    }
}
