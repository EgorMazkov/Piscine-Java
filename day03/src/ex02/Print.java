package ex02;
import ex02.MyThread.*;
public class Print {
    private int sumFromMyThreads;

    public synchronized void printMass(int first, int last, int[] array, int num) {
        int sum = 0;

        if (last > array.length) {
            last = array.length;
        }
        int i = first;
        for (; i < last; i++) {
            sum += array[i];
        }
        System.out.println("Thread " + num + ": from " + first + " to " + (last - 1)
                + " sum is " + sum);
        sumFromMyThreads += sum;
    }

    public int getSumFromMyThreads() {
        return sumFromMyThreads;
    }
}