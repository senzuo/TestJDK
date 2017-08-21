package reflect;

import java.lang.reflect.Constructor;

/**
 * Created by 13010 on 2017/8/21.
 */

/**
 * 通过构造器实现实例化
 */
public class InstanceWithConstructor {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Lover");
        }catch (Exception e){
            e.printStackTrace();
        }
        Lover per1 = null;
        Lover per2 = null;
        Lover per3 = null;
        Lover per4 = null;

        Constructor<?> cons[] = demo.getConstructors();
        try {
            per1 = (Lover)cons[0].newInstance(29);
            per2 = (Lover)cons[1].newInstance("Curry");
            per3 = (Lover)cons[2].newInstance();
            per4 = (Lover)cons[3].newInstance(29,"Curry");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(per1);
        System.out.println(per2);
        System.out.println(per3);
        System.out.println(per4);
    }
}

class Lover{
    private int age;
    private String name;

    @Override
    public String toString() {
        return "Lover{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Lover() {

    }

    public Lover(String name) {
        this.name = name;
    }

    public Lover(int age) {

        this.age = age;
    }

    public Lover(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
