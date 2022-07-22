package ex02;

public class MyThread extends Thread {
    private int[] mass;
    private int startIndex;
    private int endIndex;
    private int sumMass;
    private Print print;
    private int numThread;


    public MyThread(int[] mass, int start, int end, Print print, int num) {
        this.mass = mass;
        this.startIndex = start;
        this.endIndex = end;
        this.print = print;
        this.numThread = num;
    }

    public void setSumMass(int sumMass) {
        this.sumMass = sumMass;
    }

    @Override
    public void run() {
        print.printMass(startIndex, endIndex, mass, numThread);
    }
}
