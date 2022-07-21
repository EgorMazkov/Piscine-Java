package ex03;

import java.util.UUID;

import static ex03.Category.RECEIVING;
import static ex03.Category.SENDING;

public class Program {
    public static void main(String[] args) {
        User one = new User("Paul", 100);
        User two = new User("Bob", 20000010);
        User three = new User("John", 5000);
        User four = new User("Pit", 90600);

        System.out.println(one.toString());
        System.out.println(two.toString());
        System.out.println(three.toString());
        System.out.println(four.toString());
        System.out.println("----------------------\n");

        TransactionsLinkedList commonList = new TransactionsLinkedList();
        System.out.println("commonList is created");
        System.out.println("length of Array after creating a list: " + commonList.toArray().length);
        System.out.println("-------");

        Transaction tr1 = new Transaction(three, four, -100, SENDING);
        Transaction tr2 = new Transaction(one, two, 200, RECEIVING);
        Transaction tr3 = new Transaction(one, two, -10, SENDING);
        Transaction tr4 = new Transaction(one, two, 670, RECEIVING);
        Transaction tr5 = new Transaction(one, two, -100, SENDING);
        Transaction tr6 = new Transaction(one, two, 100, RECEIVING);

        commonList.addTransaction(tr1);
        commonList.addTransaction(tr2);
        commonList.addTransaction(tr3);
        commonList.addTransaction(tr4);
        commonList.addTransaction(tr5);
        commonList.addTransaction(tr6);

        System.out.println("length of Array after adding six trans: " + commonList.toArray().length);
        System.out.println("-------");
        commonList.deleteTransaction(tr3.getIdentifier());
        System.out.println("length of Array after removing 1 middle trans: " + commonList.toArray().length);
        commonList.deleteTransaction(tr1.getIdentifier());
        System.out.println("length of Array after removing first trans: " + commonList.toArray().length);
        commonList.deleteTransaction(tr6.getIdentifier());
        System.out.println("length of Array after removing last trans: " + commonList.toArray().length);
        System.out.println("----------------------\n");

        System.out.println("length of Array in user One list: " + one.getList().toArray().length);
        one.getList().addTransaction(tr2);
        System.out.println("length of Array after adding one trans: " + one.getList().toArray().length);
        one.getList().toArray()[0].printTransfer();
        one.getList().addTransaction(tr3);
        one.getList().addTransaction(tr4);
    }

    public static void printError(String massage) {
        System.out.println(massage);
        System.exit(-1);
    }

}
