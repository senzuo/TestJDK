package access;

import access.dessert.Cookie;

/**
 * Created by 13010 on 2017/8/18.
 */
public class ChocolateChip extends Cookie{
    public ChocolateChip() {
        System.out.println("ChocolateChip constructor ");
    }
    public void chomp(){
//        priBite();
//        pacBite();
        proBite();
        proBite();
    }

    public static void main(String[] args) {
        ChocolateChip chocolateChip = new ChocolateChip();
        chocolateChip.chomp();
    }
}
