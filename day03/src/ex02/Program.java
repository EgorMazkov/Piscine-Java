package ex02;

import java.sql.SQLOutput;

import static ex02.CreatingAnArray.creatMass;

public class Program {
    public static final int MAXMASS = 2000000;
    public static final int MAXMASSNUMBER = 1000;

    public static void main(String[] args) {
         int numberThread;
         int numberMass;
         int []mass;
         int num = 0;

        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            System.out.println("java Program <--arraySize=> <--threadsCount=>");
            System.exit(-1);
        }

        numberMass = Integer.parseInt(args[0].substring("--arraySize=".length()));
        numberThread = Integer.parseInt(args[1].substring("--threadsCount=".length()));

        if (numberMass > MAXMASS) {
            throw new MassException("Exception: the maximum number of array elements exceeds 2000000 by: " + (MAXMASS - numberMass));
        }
        if (numberThread > numberMass) {
            throw new ThreadException("Exception: The number of threads exceeds the number of array by: " + (numberThread - numberMass));
        }

        CreatingAnArray m = new CreatingAnArray(numberMass);
        mass = creatMass();

        for (int i = 0; i < mass.length; i++) {
            num += mass[i];
        }

        System.out.println("Sum: " + num);
        Print print = new Print();
        int size = (int) Math.ceil(numberMass * 1.0 / numberThread);

        Thread[] threads = new MyThread[numberThread];

        for (int i = 0; i < numberThread; i++) {
            threads[i] = new MyThread(mass, i * size, (i + 1) * size, print, i);
            threads[i].start();
        }
        for (int i = 0; i < numberThread; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
        }
        System.out.println("Sum by threads: " + print.getSumFromMyThreads());
    }
}
