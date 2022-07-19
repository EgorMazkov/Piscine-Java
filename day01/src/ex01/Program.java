package ex01;
import ex00.Transaction;


public class Program {
    public static void main(String[] args) {
        User userOne = new User("Biba", 500);
        User userTwo = new User("Boba", 100);
        User userThree = new User("Lupa", 500);
        User userFour = new User("Pupa", 500);

        userOne.printUserData();
        userOne.printUserData();
        userOne.printUserData();
        userOne.printUserData();
    }

    public static void printError(String massage) {
        System.out.println(massage);
        System.exit(-1);
    }
}
