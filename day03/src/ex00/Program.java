package ex00;

public class Program {
    public static void main(String[] args) {
        int count;
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.out.println("java Program.java <--count=>");
            System.exit(-1);
        }

        count = Integer.parseInt(args[0].substring("--count=".length()));

        if (count <= 0) {
            System.out.println("Incorrect count: " + count);
            System.exit(-1);
        }
        Thread egg = new Thread(new Egg(count));
        Thread hen = new Thread(new Hen(count));
        egg.start();
        hen.start();
        try {
            egg.join();
            hen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
