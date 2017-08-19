package access.dessert;

/**
 * Created by 13010 on 2017/8/18.
 */
public class Cookie {
    public Cookie() {
        System.out.println("constructor cookie");
    }

    private void priBite() {
        System.out.println("priBite");

    }

    void pacBite() {
        System.out.println("pacBite");
    }

    protected void proBite() {
        System.out.println("proBite");
    }

    public void pubBite() {
        System.out.println("pubBite");
    }

}
