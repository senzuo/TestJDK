//: interfaces/classprocessor/Apply.java
package interfaces.classprocessor;

import interfaces.filters.HighPass;

import java.util.*;

import static net.mindview.util.Print.*;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }


    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    String process(Object input) { // Covariant return
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    String process(Object input) {
        // The split() argument divides a String into pieces:
        return Arrays.toString(((String) input).split(" "));
    }
}

/**    策略设计模式
 * Apply.process()方法可以接收任何 Process 对象，操作 Object对象 然后打印
 *
 * 创建一个根据参数对象的不同而具有不同行为的方法
 *
 */

public class Apply {
    /**
     * 接受输入参数，更改然后输出
     * @param p
     * @param s
     */
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }

    public static String s =
            "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
//        process(new HighPass(0.4),s);
    }
} /* Output:
Using Processor Upcase
DISAGREEMENT WITH BELIEFS IS BY DEFINITION INCORRECT
Using Processor Downcase
disagreement with beliefs is by definition incorrect
Using Processor Splitter
[Disagreement, with, beliefs, is, by, definition, incorrect]
*///:~
