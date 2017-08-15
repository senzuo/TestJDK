package typeinfo;//: typeinfo/InterfaceViolation.java
// Sneaking around an interface.

import typeinfo.interfacea.*;

class B implements A {
    @Override
    public void f() {
    }

    public void g() {
    }
}

/**
 * 使用 RTTI a 作为 B 被实现
 * 通过cast to B 可以调用不在A中的 g 方法
 */
public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g(); // Compile error
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
} /* Output:
B
*///:~
