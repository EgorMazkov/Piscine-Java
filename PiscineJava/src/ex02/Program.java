package ex02;

import java.util.Scanner;

public class Program {
    public static void main (String[] args) {

        int res = 0;
        boolean check = false;
        Scanner userInput = new Scanner(System.in);
        while (userInput.hasNextInt()) {
            int num = userInput.nextInt();
            if (num < 2)
                error();
            while (true ){
                if (num == 42) {
                    sout(res);
                }
                if (!(check = checkPrimeNumber(num))){
                    break;
                }
                res++;
                break ;
                    }
                }
            }
    public static void error()
    {
        System.err.println("theIllegalArgument");
        System.exit(-1);
    }

    public static void sout(int res) {
        System.out.println("Count of coffee - request - " + res);
        System.exit(0);

    }

    public static boolean checkPrimeNumber(int num){
        int number = num;
        num = 0;
        while (number > 0){
            num += number % 10;
            number /= 10;
        }
        for (int iterator = 2; iterator * iterator <= num; iterator++) {
            if (num % iterator == 0) {
                return false;
            }
        }
        return true;
    }
}
