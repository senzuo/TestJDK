package reflect;

/**
 * Created by 申卓 on 2017/8/21.
 */
public class Instance {
    public static void main(String[] args) {
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;
        try {
            //一般尽量采用这种形式
            demo1 = Class.forName("reflect.Instance");
        } catch (Exception e) {
            e.printStackTrace();
        }
        demo2 = new Instance().getClass();
        demo3 = Instance.class;

        System.out.println("类名称   " + demo1.getName());
        System.out.println("类名称   " + demo2.getName());
        System.out.println("类名称   " + demo3.getName());
    }
}
