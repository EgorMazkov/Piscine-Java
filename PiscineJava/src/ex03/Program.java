package ex03;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = 0;
        int week = 1;
        int minWeekTest = 0;
        String scan;
        while (week != 19) {
            scan = scanner.nextLine();
            if (scan.equals("42")) {
                print(minWeekTest, week);
                System.exit(0);
            }
            if (scan.equals("Week " + week)) {
                minWeekTest += checkMinNumberts(scanner, week);
                week++;
                scanner.nextLine();
                continue ;
            } else {
                IllegalArgument();
            }
        }
    }

    public static void IllegalArgument() {
            System.err.println("theIllegalArgument");
            System.exit(-1);
    }

    public static int checkMinNumberts(Scanner scanner, int week) {
        int min = 100;
        int num = scanner.nextInt();
        int i = 0;
        while (i != 5) {
            if (min > num) {
                min = num;
            }
            if (i != 4) {
                num = scanner.nextInt();
            }
            i++;
            continue ;
        }
        if (week > 1) {
            for (int q = 1; q < week; ++q) {
                min *= 10;
            }
        }
        return min;
    }

    public static void print(int minWeekTest, int week) {
        int res = 0;
        for (int i = 1; i != week; i++) {
            res = minWeekTest % 10;
            minWeekTest /= 10;
            System.out.print("Week "+ i + " ");
            for (int q = 0; q != res; q++) {
                System.out.print("=");
            }
            System.out.println(">");
        }
    }
}
