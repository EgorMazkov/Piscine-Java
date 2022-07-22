package ex02;

import java.util.Random;

public class CreatingAnArray {
    private static int[] mass;
    private static int numberMass;

    public CreatingAnArray(int numberMass) {
        this.mass = new int[numberMass];
        this.numberMass = numberMass;
    }

    public int[] getMass() {
        return mass;
    }

    public static int[] creatMass() {
        Random random = new Random();

        for (int i = 0; i < numberMass; i++) {
            mass[i] = random.nextInt(Program.MAXMASSNUMBER) * (random.nextBoolean() ? 1 : -1);
        }
        return mass;
    }

}
