package reflect;

/**
 * Created by 13010 on 2017/8/21.
 */

/**
 * 通过class对象实例化其他类
 * 注意：必须有默认构造器
 */
public class InstanceGeneralClass {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Person");
        }catch (Exception e){
            e.printStackTrace();
        }
        Person per = null;
        try {
            per = (Person)demo.newInstance();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        per.setName("Curry");
        per.setAge(18);
        System.out.println(per);
    }
}

class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
