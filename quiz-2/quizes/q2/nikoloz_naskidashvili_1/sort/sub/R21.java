package quizes.q2.nikoloz_naskidashvili_1.sort.sub;

import quizes.q2.nikoloz_naskidashvili_1.sort.A21;
import quizes.q2.nikoloz_naskidashvili_1.thermodynamics.A22;

public class R21 {
    public static void main(String[] args) {
        System.out.printf("Rectangle with height %d and length %d has area %d\n", A21.hei, A21.len, A21.hei * A21.len);

        if (A22.month < 1 || A22.month > 12) {
            System.out.println("Invalid month input. Month should be between 1 and 12.");
        } else {
            System.out.printf("Month: %d\n", A22.month);
        }
    }
}
