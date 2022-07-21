package ex01;

public class Hen implements Runnable{
    private int count;

    private Print print;

    public Hen(int count, Print print) {
        this.count = count;
        this.print = print;
    }

    @Override
    public void run() {
        try {
            print.printHen();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
