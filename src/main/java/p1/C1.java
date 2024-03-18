package p1;

import p1.p11.C11;
import p2.C3;

public class C1 {
    public static String MESSAGE = "This is C1 message";

    public static void main(String[] args) {
        System.out.println(C1.MESSAGE);
        System.out.println(C2.MESSAGE);
        System.out.println(C11.MESSAGE);
        System.out.println(C3.MESSAGE);
    }
}
