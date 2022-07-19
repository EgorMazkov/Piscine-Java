package ex01;

import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        Scanner userInput = new Scanner(System.in);
        if (userInput.hasNextInt()) {
            int num = userInput.nextInt();
            if (num < 2)
                error();
            else {
                boolean res = true;
                int iterator;
                for (iterator = 2; iterator * iterator <= num; iterator++) {
                    if (num % iterator == 0) {
                        res = false;
                        break;
                    }
                }
                System.out.println(res + " " + --iterator);
            }
        }
        else
            System.err.println("Error!\nJust numbers are allowed");
    }
    public static void error() {
        System.err.println("theIllegalArgument");
        System.exit(-1);
    }
}