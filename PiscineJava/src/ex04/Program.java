package ex04;

import java.sql.SQLOutput;
import java.util.Scanner;
public class Program {

    private static final int MAX = 10;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] line = new char[1];
        char[] symbol = new char[65535];
        int[] numbertSymbol = new int[999];
        int i = 0;
        int q = 0;
        line = scanner.nextLine().toCharArray();
        symbol[i] = line[q];
        while (q != line.length - 1){
            if (symbol[i] == line[q]){
                i++;
                if (q != line.length - 1) {
                    q++;
                }
                if (checkSymbol(line, symbol, q)) {
                    i--;
                }
                else {
                    symbol[i] = line[q];
                }

            } else {
                q++;
            }
        }
        numberOfEachCharacter(symbol, line, numbertSymbol, i + 1);
        printSybmolAndNumber(numbertSymbol, symbol, i + 1);
    }

    public static boolean checkSymbol(char[] line, char [] symbol, int q){
        for (int iter = 0; iter != q; iter++) {
            if (symbol[iter] != line[q]) {
                ;
            } else {
              return true;
            }
        }
        return false;
    }

    public static void numberOfEachCharacter(char[] symbol, char[] line, int[] numbertSymbol, int i) {
        int q = 0;
        int iter = 0;
        while (iter != i){
            while (q != line.length) {
                if (symbol[iter] == line[q]) {
                    numbertSymbol[iter]++;
                    q++;
                } else {
                    q++;
                }
            }
            iter++;
            q = 0;
        }
    }

    public static void printSybmolAndNumber(int[] numbertSymbol, char[] symbol, int allSybmol) {
        int[] fromMaxToMin = new int[allSybmol];
        int iterator = 0;
        int maxNumb = numbertSymbol[0];
        int[] mass = new int[allSybmol];
        char[] massChar = new char[MAX];
        int i = 0;



        while (i != allSybmol) {
            mass[i] = numbertSymbol[i];
            i++;
        }
        i = 0;
        while (iterator != allSybmol) {
            if (maxNumb < mass[iterator]) {
                maxNumb = mass[iterator];
                fromMaxToMin[i] = iterator;
                iterator++;

            } else {
                iterator++;
            }
            if (iterator == allSybmol) {
                mass[fromMaxToMin[i]] = 0;
                i++;
                iterator = 0;
                maxNumb = 0;
            }
            if (i == MAX || i == allSybmol) {
                break ;
            }
        }
        print(symbol, fromMaxToMin, numbertSymbol);
    }

    public static void print(char[] symbol, int[] fromMaxToMin, int[] numbertSymbol) {
        int i = 0;
        while (i != fromMaxToMin.length) {
            System.out.print(numbertSymbol[fromMaxToMin[i]] + "\t");
            i++;
        }
        System.out.println();
        i = 0;
        while (i != fromMaxToMin.length) {
            System.out.print(symbol[fromMaxToMin[i]] + "\t");
            i++;
        }
    }
}
